package com.byteshaper.tienda8.domain.entity

import javax.persistence.MappedSuperclass
import org.springframework.data.annotation.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@MappedSuperclass
abstract class AbstractEntity() {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long? = null
     
    set(id: Long?) {
      if(field == null) {
        field = id
      }
    }

  override fun equals(other: Any?): Boolean {
    
    if(other == null || other !is AbstractEntity) {
      return false;
    }
    
    return id == other.id;
  }

  override fun hashCode(): Int {
    val idHash = id?.hashCode() ?: 0
    return idHash * 31
  }
}