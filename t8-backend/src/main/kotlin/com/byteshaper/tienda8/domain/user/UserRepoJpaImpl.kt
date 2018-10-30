package com.byteshaper.tienda8.domain.user

import org.springframework.stereotype.Repository
import com.byteshaper.tienda8.infrastructure.jpa.repository.UserJpaRepo

@Repository
class UserRepositoryJpaImpl(val userJpaRepo: UserJpaRepo): UserRepo {
  
  override fun findUserByUsername(username: String): User? {
    val userEntity = userJpaRepo.findByUsername(username)
    return if(userEntity != null) User(userEntity.username ?: "") else null 
  }
  
}