package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.repositories.PatientRepository
import trabalho.trabalhojedersonbackend.services.PatientService

@Service
class PatientServiceImpl(val patientRepository: PatientRepository) : PatientService {

    override fun findById(id: Long): Patient? = patientRepository.findByIdOrNull(id)

    override fun findAll(): List<Patient> = patientRepository.findAll()

    override fun delete(id: Long) = patientRepository.deleteById(id);

}