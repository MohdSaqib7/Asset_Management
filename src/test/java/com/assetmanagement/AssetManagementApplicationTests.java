package com.assetmanagement;

import com.assetmanagement.models.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AssetManagementApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testAddCategory() throws Exception {

		Category input = new Category(204, "keyboard", "electronic");

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.post("http://localhost:8080/category/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(input)))
				.andExpect(status().isOk())
				.andReturn();

		String response = result.getResponse().getContentAsString();
		assertEquals(response,"Success: "+input.toString(), "Desired Result");
	}


	@Test
	public void testUpdateCategory_Success() throws Exception {

		Category input = new Category(204, "keyboard", "electronic");

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
					.patch("http://localhost:8080/category/update")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(input)))
			.andExpect(status().isOk())
			.andReturn();

		String response = result.getResponse().getContentAsString();
		assertEquals(response,"Success: "+ input.toString(), "Desired Result");
	}


	@Test
	public void testGetAllCategories() throws Exception {
//		List<Category> categories = Arrays.asList(
//			new Category(225, "keyboard", "electronic"),
//			new Category(226, "keyboard", "electronic")
//		);
//
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//					.get("http://localhost:8080/category/getAll")
//					.contentType(MediaType.APPLICATION_JSON)
//					.content(objectMapper.writeValueAsString(categories)))
//			.andExpect(status().isOk())
//			.andReturn();
//
//		String response = result.getResponse().toString();
//		assertEquals(response, categories.toString(), "Desired Result");

	}

}
