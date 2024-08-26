package com.example.blog.repositories

import com.example.blog.entities.Article
import com.example.blog.entities.Author
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class ArticleRepositoryTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val articleRepository: ArticleRepository) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val johnDoe = Author("johnDoe", "John", "Doe")
        entityManager.persist(johnDoe)
        val article = Article("Lorem", "Lorem", "dolor sit amet", johnDoe)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }
}