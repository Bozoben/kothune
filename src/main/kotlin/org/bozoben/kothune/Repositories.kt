package org.bozoben.kothune

import org.springframework.data.repository.CrudRepository

interface SalaireRepository : CrudRepository<Salaire, Long> {
    fun findAllByOrderByName(): Iterable<Salaire>
}