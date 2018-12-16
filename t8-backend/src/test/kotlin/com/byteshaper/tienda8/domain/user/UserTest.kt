package com.byteshaper.tienda8.domain.user

import org.assertj.core.api.Assertions.*
import org.junit.Test

class UserTest {
  
  final val PLAINTEXT = "supersecretpassword"
  
  final val SALT = "1234"
  
  final val USERNAME = "username"
  
  @Test(expected = InternalErrorException::class)
  fun invalidCombinationEcryptedAndPlaintext() {
    User.Builder(USERNAME)
            .withEncryptedPassword("abc")
            .withPlaintextPassword(PLAINTEXT)
            .build()
  }
  
  @Test
  fun encryptPasswordAndValidatePlaintextPassword() {    
    val user = User.Builder(USERNAME)
            .withSalt(SALT)
            .withPlaintextPassword(PLAINTEXT)
            .build()
    assertThat(user).isNotNull()
    assertThat(user.encryptedPassword).isNotNull()
    assertThat(user.salt).isNotNull()
    assertThat(user.salt).isEqualTo(SALT)
    assertThat(user.isCorrectPassword(PLAINTEXT)).isTrue()
    assertThat(user.isCorrectPassword(PLAINTEXT + "something")).isFalse()    
  }
  
}