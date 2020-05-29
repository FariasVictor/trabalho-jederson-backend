package trabalho.trabalhojedersonbackend.services

import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.repositories.PatientRepository

@Service
class PatientService(val patientRepository: PatientRepository) {

    fun findById(id: Long):Patient {
        return patientRepository.findById(id).get()
    }

    fun findAll():List<Patient>{
        return patientRepository.findAll();
    }

}