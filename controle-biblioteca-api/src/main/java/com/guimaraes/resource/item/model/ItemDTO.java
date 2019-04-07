package com.guimaraes.resource.item.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ItemDTO implements Serializable {

	private static final long serialVersionUID = -4016242614109974907L;

	private String oid;

	private String author;
	private String title;
	private String editor;
	private Date releaseDate;
	private Integer releaseEdition;

	public ItemDTO(String oid, String title, String author) {
		this.oid = oid;
		this.title = title;
		this.author = author;

		editor = "Editor <Name>";
		releaseDate = new Date();
		releaseEdition = 1;
	}

}
