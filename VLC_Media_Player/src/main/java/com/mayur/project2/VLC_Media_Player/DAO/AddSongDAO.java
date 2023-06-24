package com.mayur.project2.VLC_Media_Player.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mayur.project2.VLC_Media_Player.DTO.SongDTO;

public class AddSongDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() throws Exception {
		factory = Persistence.createEntityManagerFactory("vlc_media");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() throws Exception {
		if (factory != null) {
			factory.close();
		}

		if (manager != null) {
			manager.close();
		}

		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public static void addNewSong() {
		try {
			openConnection();
			transaction.begin();

			SongDTO song1 = new SongDTO();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Song Id : ");
			song1.setSongId(sc.nextInt());
			System.out.println("Enter Song Name : ");
			song1.setSongName(sc.next());
			System.out.println("Enter Singer Name : ");
			song1.setSingerName(sc.next());
			System.out.println("Enter Song Duration (e.g 5.14) : ");
			song1.setDuration(sc.nextDouble());
			manager.persist(song1);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
