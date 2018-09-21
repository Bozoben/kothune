package org.bozoben.kothune

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Salaire(
        val name: String,
        val job: String,
        val company: String,
        val income: String,
        @Id @GeneratedValue val id: Long? = null,
        val addedAt: LocalDateTime = LocalDateTime.now())