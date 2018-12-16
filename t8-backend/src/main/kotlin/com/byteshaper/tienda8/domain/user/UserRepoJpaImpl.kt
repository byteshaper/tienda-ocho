package com.byteshaper.tienda8.domain.user

import org.springframework.stereotype.Repository
import com.byteshaper.tienda8.infrastructure.jpa.repository.UserJpaRepo

@Repository
class UserRepositoryJpaImpl(val userJpaRepo: UserJpaRepo): UserRepo {
  
  override fun findUserByUsername(username: String): User? {
    val userEntity = userJpaRepo.findByUsername(username)
    
    if(userEntity != null) {
      return User.Builder(userEntity.username!!)
              //.withRole() TODO
              .withEncryptedPassword(userEntity.encryptedPassword!!)
              .withSalt(userEntity.salt!!)
              .build()
    }
    
    return null;
  }
  
}