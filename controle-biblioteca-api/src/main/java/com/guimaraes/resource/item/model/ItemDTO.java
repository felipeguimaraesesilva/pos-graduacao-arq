package com.guimaraes.resource.item.model;

import java.math.BigDecimal;
import java.util.Date;

import com.guimaraes.resource.basemodels.BaseRequestDTO;

import lombok.Data;

@Data
public class ItemDTO extends BaseRequestDTO {

	private static final long serialVersionUID = -4016242614109974907L;

	private String oid;

	private String author;
	private String title;
	private String editor;
	private Date releaseDate;
	private Integer releaseEdition;
	private BigDecimal price;

	private CommentsDTO comments = new CommentsDTO();

	public ItemDTO(String oid, String title, String author) {
		this.oid = oid;
		this.title = title;
		this.author = author;

		editor = "Editor <Name>";
		releaseDate = new Date();
		releaseEdition = 1;

		price = new BigDecimal(Math.random() * 10);
	}

}
