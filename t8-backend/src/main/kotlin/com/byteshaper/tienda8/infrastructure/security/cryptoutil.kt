package com.byteshaper.tienda8.infrastructure.security

import org.apache.commons.lang3.RandomStringUtils
import java.security.MessageDigest
import java.math.BigInteger

val SALT_LENGTH = 25

val MESSAGE_DIGEST = "SHA-512"

fun encryptPassword(plaintextPassword: String, salt: String): String {
  val messageDigest= MessageDigest.getInstance(MESSAGE_DIGEST)
  val plaintext: String = plaintextPassword + salt
  messageDigest.update(plaintext.toByteArray(Charsets.UTF_8))
  val result = BigInteger(1, messageDigest.digest())
  return result.toString(16)
}

fun generateRandomSalt(): String {
  return RandomStringUtils.randomAscii(SALT_LENGTH)
}
