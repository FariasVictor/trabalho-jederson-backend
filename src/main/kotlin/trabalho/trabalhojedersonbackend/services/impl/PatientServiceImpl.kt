package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.repositories.PatientRepository
import trabalho.trabalhojedersonbackend.services.PatientService

@Service
class PatientServiceImpl(val patientRepository: PatientRepository):PatientService {
    override fun findById(id: Long): Patient {
        return patientRepository.findById(id).get()
    }

    override fun persist(clinic: Clinic): List<Patient> {
        return patientRepository.findAll()
    }


//    override fun findById(id: Long):Patient {
//    }
//
//    override fun findAll():List<Patient>{
//    }

}