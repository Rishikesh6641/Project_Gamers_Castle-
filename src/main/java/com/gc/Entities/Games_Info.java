package com.gc.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Games_info")
@Getter
@Setter
@NoArgsConstructor

public class Games_Info extends BaseEntity{
	
	@Column(name = "game_title")
	private String title;
	@Column(length =  500)
	private String description;
	@Column(name = "image_url")
	private String image;
	@Column(name = "trailer_url")
	private String trailer;
}
