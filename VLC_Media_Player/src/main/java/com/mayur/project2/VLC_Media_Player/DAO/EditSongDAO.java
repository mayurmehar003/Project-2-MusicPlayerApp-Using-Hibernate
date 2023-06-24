package com.mayur.project2.VLC_Media_Player.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mayur.project2.VLC_Media_Player.DTO.SongDTO;

public class EditSongDAO {
	
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
	
	public static void UpdateSongDetails()
	{
		try {
			openConnection();
			transaction.begin();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Song Id : ");
			SongDTO song1 = manager.find(SongDTO.class,sc.nextInt());
			System.out.println("Enter Song Name : ");
			song1.setSongName(sc.next());
			System.out.println("Enter Singer Name : ");
			song1.setSingerName(sc.next());
			System.out.println("Enter Song Duration (e.g 5.14) : ");
			song1.setDuration(sc.nextDouble());
			manager.persist(song1);
			System.out.println("Details Successfully Updated.....");
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
