package com.example.blog.repositories

import com.example.blog.entities.Author
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class AuthorRepositoryTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val authorRepository: AuthorRepository) {

    @Test
    fun `When findByLogin then return Author`() {
        val johnDoe = Author("johnDoe", "John", "Doe")
        entityManager.persist(johnDoe)
        entityManager.flush()
        val author = authorRepository.findByLogin(johnDoe.login)
        assertThat(author).isEqualTo(johnDoe)
    }
}