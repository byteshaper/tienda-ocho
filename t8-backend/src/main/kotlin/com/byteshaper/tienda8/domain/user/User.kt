package com.byteshaper.tienda8.domain.user

import com.byteshaper.tienda8.infrastructure.security.generateRandomSalt
import com.byteshaper.tienda8.infrastructure.security.encryptPassword
import java.lang.IllegalArgumentException

class User private constructor (
        val username: String,
        val roles: Set<Role>,
        val encryptedPassword: String,
        val salt: String) {
  
  fun isCorrectPassword(plaintextPasswordToCheck: String): Boolean {
    val encryptedPasswordToCheck = encryptPassword(plaintextPasswordToCheck, salt)
    return encryptedPassword == encryptedPasswordToCheck
  }
  
  class Builder(
          val username: String,
          var roles: MutableSet<Role> = mutableSetOf(),
          var encryptedPassword: String? = null,
          var plaintextPassword: String? = null,
          var salt: String? = null) {
    
    fun withEncryptedPassword(encryptedPassword: String) = apply {
      this.encryptedPassword = encryptedPassword
      this.plaintextPassword = null
    }
    
    fun withPlaintextPassword(plaintextPassword: String) = apply {
      this.plaintextPassword = plaintextPassword
      this.encryptedPassword = null
    }
    
    fun withSalt(salt: String) = apply {
      this.salt = salt
    }
    
    fun withRandomSalt() = apply {
      this.salt = generateRandomSalt()
    }
    
    fun withRole(role: Role) = apply {
      roles.add(role)
    }
    
    fun build(): User {
      val password = encryptedPassword ?: encryptPlaintextPassword(plaintextPassword, salt)
      return User(username, roles, password, salt!!)
    }
    
    private fun encryptPlaintextPassword(plaintextPassword: String?, salt: String?): String {

      if (plaintextPassword == null) {
        throw InternalErrorException("Either plaintext or encrypted password must be set")
      }

      if (salt == null) {
        throw InternalErrorException("Salt must be set")
      }
              
      return encryptPassword(plaintextPassword, salt)
    }
  }
}