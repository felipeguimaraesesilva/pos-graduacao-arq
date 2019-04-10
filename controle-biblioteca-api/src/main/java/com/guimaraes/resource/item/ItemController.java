package com.guimaraes.resource.item;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.repository.ItemRepository;
import com.guimaraes.resource.item.model.CommentsDTO;
import com.guimaraes.resource.item.model.ItemDTO;
import com.guimaraes.resource.item.model.ResponseItensDTO;

@RestController
@RequestMapping("/itens")
public class ItemController {
	ItemRepository itemRepository = new ItemRepository();

	@GetMapping
	public ResponseItensDTO getItens() {
		ResponseItensDTO response = new ResponseItensDTO();
		response.setCount(itemRepository.getBooksMemory().size());
		response.setItens(itemRepository.getBooksMemory());

		response.setHttpStatus(HttpStatus.OK);
		return response;
	}

	@PostMapping
	public ResponseItensDTO createItem(@RequestBody ItemDTO item) {
		item.setOid("id" + (itemRepository.getBooksMemory().size() + 1));
		itemRepository.getBooksMemory().add(item);

		ResponseItensDTO response = new ResponseItensDTO();
		response.setItens(Arrays.asList(item));
		response.setHttpStatus(HttpStatus.CREATED);
		return response;
	}

	@RequestMapping(value = "/{bookId}/comments", method = RequestMethod.POST)
	public ResponseItensDTO createComments(@PathVariable("bookId") String bookId, @RequestBody CommentsDTO comments) {
		ResponseItensDTO response = new ResponseItensDTO();

		Optional<ItemDTO> item = itemRepository.getBooksMemory().stream().filter(i -> i.getOid().equals(bookId))
				.findAny();

		if (item.isPresent()) {
			item.get().getComments().getComments().addAll(comments.getComments());
			response.setItens(Arrays.asList(item.get()));
			response.setHttpStatus(HttpStatus.CREATED);
		} else {
			response.setHttpStatus(HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@RequestMapping(value = "/search/title/{title}", method = RequestMethod.GET)
	public ResponseItensDTO getItensByTitle(@PathVariable("title") String title) {
		ResponseItensDTO response = new ResponseItensDTO();

		if (!org.springframework.util.StringUtils.isEmpty(title)) {
			response.setItens(itemRepository.getBooksMemory().stream()
					.filter(i -> i.getTitle().toUpperCase().contains(title.toUpperCase()))
					.collect(Collectors.toList()));
		}

		response.setHttpStatus(HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/search/author/{author}", method = RequestMethod.GET)
	public ResponseItensDTO getItensByAuthor(@PathVariable("author") String author) {
		ResponseItensDTO response = new ResponseItensDTO();

		if (!org.springframework.util.StringUtils.isEmpty(author)) {
			response.setItens(itemRepository.getBooksMemory().stream()
					.filter(i -> i.getAuthor().toUpperCase().contains(author.toUpperCase()))
					.collect(Collectors.toList()));
		}

		response.setHttpStatus(HttpStatus.OK);
		return response;
	}

}
