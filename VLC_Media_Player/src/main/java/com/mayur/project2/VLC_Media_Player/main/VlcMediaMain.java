package com.mayur.project2.VLC_Media_Player.main;

import java.util.Scanner;

import com.mayur.project2.VLC_Media_Player.DAO.AddSongDAO;
import com.mayur.project2.VLC_Media_Player.DAO.EditSongDAO;
import com.mayur.project2.VLC_Media_Player.DAO.PlaySongDAO;
import com.mayur.project2.VLC_Media_Player.DAO.ViewAllSong;

public class VlcMediaMain {

	private static void AppDriver() {
		System.out.println("1. Add Song\n" + "2. Play Song\n" + "3. Edit Song\n" + "4. View All Song\n");
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			AddSongDAO.addNewSong();
			break;
		case 2:
			PlaySongDAO.PlayNewSong();
			break;
		case 3:
			EditSongDAO.UpdateSongDetails();
			break;
		case 4:
			ViewAllSong.ListOfSongs();
			break;

		default:
			System.out.println("Please Select correct option");
			System.out.println();
			AppDriver();
			break;
		}
	}

	public static void main(String[] args) {
		AppDriver();
	}

}
