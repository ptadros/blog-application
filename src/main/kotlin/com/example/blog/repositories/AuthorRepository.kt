package com.example.blog.repositories

import com.example.blog.entities.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Long> {
    fun findByLogin(login: String): Author?
}