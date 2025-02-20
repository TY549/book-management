package com.example.book_management.service

import com.example.book_management.model.BookModel
import com.example.book_management.model.AuthorModel
import com.example.book_management.repository.BookRepository
import com.example.book_management.repository.AuthorRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class BookAuthorService(private val bookRepository: BookRepository, private val authorRepository: AuthorRepository) {

    fun addBook(book: BookModel): BookModel {
        // **価格が0以上であることを検証**
        require(book.price >= BigDecimal.ZERO) { "価格は0以上でなければなりません" }
        // **最低1人の著者が指定されていることを検証**
        require(book.authors.isNotEmpty()) { "最低1人の著者を指定してください" }

        // 書籍登録
        return bookRepository.addBook(book)
    }

    fun updateBook(book: BookModel): Boolean {
        return bookRepository.updateBook(book)
    }

    fun getBooksByAuthor(authorId: Int): List<BookModel> {
        return bookRepository.getBooksByAuthor(authorId)
    }

    fun addAuthor(author: AuthorModel): AuthorModel {
        // **生年月日が過去日付であることを検証**
        require(author.birthDate.isBefore(java.time.LocalDate.now())) { "生年月日は過去日付でなければなりません" }

        // 著者登録
        return authorRepository.addAuthor(author)
    }
}