package com.example.book_management.repository

import com.example.generated.Tables
import com.example.book_management.model.AuthorModel
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class AuthorRepository(private val dslContext: DSLContext) {

    fun findAll(): List<AuthorModel> {
        return dslContext.selectFrom(Tables.AUTHOR)
            .fetchInto(AuthorModel::class.java)
    }

    fun addAuthor(author: AuthorModel): AuthorModel {
        val authorId = dslContext.insertInto(Tables.AUTHOR)
            .set(Tables.AUTHOR.NAME, author.name)
            .set(Tables.AUTHOR.BIRTH_DATE, author.birthDate)
            .returning(Tables.AUTHOR.AUTHOR_ID)
            .fetchOne()!!
            .get(Tables.AUTHOR.AUTHOR_ID)

        return author.copy(authorId = authorId)
    }
}

