package trabalho.trabalhojedersonbackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import trabalho.trabalhojedersonbackend.model.Patient

@Repository
interface PatientRepository: JpaRepository<Patient, Long> {
}