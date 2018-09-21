package org.bozoben.kothune

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class RepositoriesTests(@Autowired val entityManager: TestEntityManager,
                        @Autowired val salaireRepository: SalaireRepository) {

    @Test
    fun whenFindByIdThenReturnSalaire() {
        val salaire = Salaire("Patrice", "Jardinier", "Ville de rochefort", "50000")
        entityManager.persist(salaire)
        entityManager.flush()

        val found = salaireRepository.findById(salaire.id!!)

        assertThat(found.get()).isEqualTo(salaire)
    }
}