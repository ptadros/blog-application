package com.example.blog

import com.example.blog.entities.Article
import com.example.blog.entities.Author
import com.example.blog.repositories.ArticleRepository
import com.example.blog.repositories.AuthorRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(authorRepository: AuthorRepository,
                            articleRepository: ArticleRepository
    ) = ApplicationRunner {

        val johnDoe = authorRepository.save(Author("johnDoe", "John", "Doe"))
        articleRepository.save(
            Article(
            title = "Lorem",
            headline = "Lorem",
            content = "dolor sit amet",
            author = johnDoe
        )
        )
        articleRepository.save(
            Article(
            title = "Ipsum",
            headline = "Ipsum",
            content = "dolor sit amet",
            author = johnDoe
        )
        )
    }
}