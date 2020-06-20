package trabalho.trabalhojedersonbackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import trabalho.trabalhojedersonbackend.model.Access
import java.util.*

interface AccessRepository: JpaRepository<Access, Long> {
    fun findByUsernameAndPassword(username: String, password: String): Access?
}