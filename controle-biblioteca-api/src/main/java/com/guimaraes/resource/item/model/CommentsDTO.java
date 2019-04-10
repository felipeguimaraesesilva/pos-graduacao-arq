package com.guimaraes.resource.item.model;

import java.util.ArrayList;
import java.util.List;

import com.guimaraes.resource.basemodels.BaseRequestDTO;

import lombok.Data;

@Data
public class CommentsDTO extends BaseRequestDTO {

	private static final long serialVersionUID = 1608862835632739652L;
	private List<String> comments;

	public CommentsDTO() {
		comments = new ArrayList<>();
	}

}
