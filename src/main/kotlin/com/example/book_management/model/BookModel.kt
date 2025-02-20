package com.example.book_management.model

import java.math.BigDecimal

data class BookModel(
    val bookId: Int? = null,
    val title: String,
    val price: BigDecimal,
    val publicationStatus: PublicationStatus,
    val authors: List<AuthorModel>
)

enum class PublicationStatus{
    未出版, 出版済み
}