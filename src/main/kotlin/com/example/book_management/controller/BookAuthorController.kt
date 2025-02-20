package com.example.book_management.controller

import com.example.book_management.model.BookModel
import com.example.book_management.model.AuthorModel
import com.example.book_management.service.BookAuthorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class BookAuthorController(
    private val bookAuthorService: BookAuthorService
) {

    // **書籍追加API**
    @PostMapping("/books/add")
    fun addBook(@RequestBody bookModel: BookModel): ResponseEntity<BookModel> {
        try {
            val savedBook = bookAuthorService.addBook(bookModel)
            return ResponseEntity(savedBook, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
    }

    // **著者追加API**
    @PostMapping("/authors/add")
    fun addAuthor(@RequestBody authorModel: AuthorModel): ResponseEntity<AuthorModel> {
        try {
            val savedAuthor = bookAuthorService.addAuthor(authorModel)
            return ResponseEntity(savedAuthor, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
    }

    // **著者IDに紐づく書籍を取得するAPI**
    @GetMapping("/authors/{authorId}/books")
    fun getBooksByAuthor(@PathVariable authorId: Int): ResponseEntity<List<BookModel>> {
        val books = bookAuthorService.getBooksByAuthor(authorId)
        return if (books.isNotEmpty()) {
            ResponseEntity.ok(books)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(emptyList())
        }
    }
}