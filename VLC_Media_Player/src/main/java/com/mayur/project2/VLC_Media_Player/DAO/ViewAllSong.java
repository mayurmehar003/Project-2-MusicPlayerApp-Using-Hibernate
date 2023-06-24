package com.mayur.project2.VLC_Media_Player.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mayur.project2.VLC_Media_Player.DTO.SongDTO;
import com.mysql.cj.Query;

public class ViewAllSong {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String JPQL;
	private static javax.persistence.Query query;

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

		if (transaction != null) {
			transaction.rollback();
		}
	}

	public static void ListOfSongs() {
		try {
			openConnection();
			transaction.begin();

			JPQL = "From SongDTO";
			query = manager.createQuery(JPQL);

			List<SongDTO> song = query.getResultList();

			for (SongDTO songList : song) {
				System.out.println(songList);
			}

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
