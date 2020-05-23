package trabalho.trabalhojedersonbackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import trabalho.trabalhojedersonbackend.model.Clinic

@Repository
interface ClinicRepository : JpaRepository<Clinic, Long>{
}