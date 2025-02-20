package com.example.book_management.model

import java.time.LocalDate

data class AuthorModel(
    val authorId: Int? = null,
    val name: String,
    val birthDate: LocalDate
)