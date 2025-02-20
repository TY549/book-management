package com.example.book_management.repository

import com.example.generated.Tables
import com.example.book_management.model.BookModel
import com.example.book_management.model.PublicationStatus
import com.example.book_management.model.AuthorModel
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class BookRepository(private val dslContext: DSLContext) {

    fun findById(bookId: Int): BookModel? {
        val record = dslContext
            .select(Tables.BOOK.BOOK_ID, Tables.BOOK.TITLE, Tables.BOOK.PRICE, Tables.BOOK.PUBLICATION_STATUS)
            .from(Tables.BOOK)
            .where(Tables.BOOK.BOOK_ID.eq(bookId))
            .fetchOne()

        return record?.let {
            BookModel(
                bookId = it[Tables.BOOK.BOOK_ID],
                title = it[Tables.BOOK.TITLE],
                price = it[Tables.BOOK.PRICE],
                publicationStatus = PublicationStatus.valueOf(it[Tables.BOOK.PUBLICATION_STATUS]),
                authors = emptyList() // 著者情報は別途取得する場合に補完
            )
        }
    }

    fun addBook(book: BookModel): BookModel {
        val bookId = dslContext.insertInto(Tables.BOOK)
            .set(Tables.BOOK.TITLE, book.title)
            .set(Tables.BOOK.PRICE, book.price)
            .set(Tables.BOOK.PUBLICATION_STATUS, book.publicationStatus.name)
            .returning(Tables.BOOK.BOOK_ID)
            .fetchOne()!!
            .get(Tables.BOOK.BOOK_ID)

        // **著者情報が空でないことを確認**
        book.authors.forEach { author ->
            if (author.authorId == null) {
                throw IllegalArgumentException("著者情報が不正です")
            }
            dslContext.insertInto(Tables.BOOKAUTHOR)
                .set(Tables.BOOKAUTHOR.BOOK_ID, bookId)
                .set(Tables.BOOKAUTHOR.AUTHOR_ID, author.authorId)
                .execute()
        }
        return book.copy(bookId = bookId)
    }

    fun updateBook(book: BookModel): Boolean {
        // **出版済みの書籍を未出版に変更できない制約を追加**
        val existingBook = findById(book.bookId ?: return false)

        // **既存の書籍の出版状況が「出版済み」ならば変更不可**
        if (existingBook!!.publicationStatus == PublicationStatus.出版済み) {
            throw IllegalArgumentException("出版済みの書籍は出版状況を変更できません")
        }

        val result = dslContext.update(Tables.BOOK)
            .set(Tables.BOOK.TITLE, book.title)
            .set(Tables.BOOK.PRICE, book.price)
            .set(Tables.BOOK.PUBLICATION_STATUS, book.publicationStatus.name)
            .where(Tables.BOOK.BOOK_ID.eq(book.bookId))
            .execute()

        return result > 0
    }

    fun getBooksByAuthor(authorId: Int): List<BookModel> {
        val records = dslContext
            .select(Tables.BOOK, Tables.AUTHOR)
            .from(Tables.BOOK)
            .join(Tables.BOOKAUTHOR)
            .on(Tables.BOOK.BOOK_ID.eq(Tables.BOOKAUTHOR.BOOK_ID))
            .join(Tables.AUTHOR)
            .on(Tables.BOOKAUTHOR.AUTHOR_ID.eq(Tables.AUTHOR.AUTHOR_ID))
            .where(Tables.BOOKAUTHOR.AUTHOR_ID.eq(authorId))
            .fetch()

        return records.map {
            BookModel(
                bookId = it[Tables.BOOK.BOOK_ID],
                title = it[Tables.BOOK.TITLE],
                price = it[Tables.BOOK.PRICE],
                publicationStatus = PublicationStatus.valueOf(it[Tables.BOOK.PUBLICATION_STATUS]),
                authors = listOf(
                    AuthorModel(
                        authorId = it[Tables.AUTHOR.AUTHOR_ID],
                        name = it[Tables.AUTHOR.NAME],
                        birthDate = it[Tables.AUTHOR.BIRTH_DATE]
                    )
                ) // 著者情報を埋め込む
            )
        }
    }
}
