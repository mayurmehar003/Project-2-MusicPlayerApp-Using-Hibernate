package com.mayur.project2.VLC_Media_Player.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name="SongDetails")
public class SongDTO {
	@Id
	@Column (name="Id")
	private int songId;
	@Column (name="Name")
	private String songName;
	@Column (name="Singer")
	private String singerName;
	@Column (name="TimeDuration")
	private Double duration;
	

}
