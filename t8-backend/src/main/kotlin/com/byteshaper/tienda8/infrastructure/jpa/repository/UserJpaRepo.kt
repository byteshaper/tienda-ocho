package com.byteshaper.tienda8.infrastructure.jpa.repository

import org.springframework.data.repository.CrudRepository
import com.byteshaper.tienda8.infrastructure.jpa.entity.UserEntity

interface UserJpaRepo: CrudRepository<UserEntity, Long> {
  
  fun findByUsername(username: String): UserEntity?
}