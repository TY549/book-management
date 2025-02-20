package com.example.book_management

import com.example.book_management.model.BookModel
import com.example.book_management.model.AuthorModel
import com.example.book_management.model.PublicationStatus
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.math.BigDecimal

@SpringBootTest
@AutoConfigureMockMvc
class BookManagementTests {

	@Autowired
	private lateinit var mockMvc: MockMvc

	@Test
	fun `test add book`() {
		val bookModel = BookModel(
			title = "Test Book",
			price = BigDecimal(20),
			publicationStatus = PublicationStatus.未出版,
			authors = listOf(AuthorModel(name = "Author", birthDate = java.time.LocalDate.of(1980, 1, 1)))
		)

		mockMvc.perform(MockMvcRequestBuilders.post("/api/books/add")
			.contentType(MediaType.APPLICATION_JSON)
			.content("""
                {
                    "title": "Test Book",
                    "price": 20,
                    "publicationStatus": "未出版",
                    "authors": [{"name": "Author", "birthDate": "1980-01-01"}]
                }
            """))
			.andExpect(MockMvcResultMatchers.status().isCreated)
			.andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Book"))
	}

	@Test
	fun `test add author`() {
		val authorModel = AuthorModel(name = "New Author", birthDate = java.time.LocalDate.of(1980, 1, 1))

		mockMvc.perform(MockMvcRequestBuilders.post("/api/authors/add")
			.contentType(MediaType.APPLICATION_JSON)
			.content("""
                {
                    "name": "New Author",
                    "birthDate": "1980-01-01"
                }
            """))
			.andExpect(MockMvcResultMatchers.status().isCreated)
			.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("New Author"))
	}
}
