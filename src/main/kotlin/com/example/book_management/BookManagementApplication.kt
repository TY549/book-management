package com.example.book_management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.jooq.impl.DSL
import org.jooq.SQLDialect
import org.jooq.DSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@SpringBootApplication
class BookManagementApplication

fun main(args: Array<String>) {
	runApplication<BookManagementApplication>(*args)

}

// jOOQ 設定用のクラス
@Configuration
class JooqConfig {

	@Bean
	fun dslContext(dataSource: DataSource): DSLContext {
		return DSL.using(dataSource, SQLDialect.POSTGRES)
	}
}