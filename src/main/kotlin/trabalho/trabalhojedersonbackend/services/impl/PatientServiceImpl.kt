package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.mapper.PatientMapper
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.model.request.PatientRequest
import trabalho.trabalhojedersonbackend.repositories.PatientRepository
import trabalho.trabalhojedersonbackend.services.PatientService
import javax.persistence.EntityNotFoundException

@Service
class PatientServiceImpl(val patientRepository: PatientRepository,val patientMapper: PatientMapper) : PatientService {


    override fun findById(id: Long): Patient? = patientRepository.findByIdOrNull(id)

    override fun findAll(): List<Patient> = patientRepository.findAll()

    override fun create(patient: PatientRequest): Patient {
        return patientRepository.save(patientMapper.convertToPatient(patient))
    }

    override fun update(id: Long, patient: Patient) {
        patientRepository.findByIdOrNull(id)?.let {
            patient.id = it.id
            patientRepository.save(patient)
        } ?: throw EntityNotFoundException("O id informado não foi encontrado")
    }

    override fun delete(id: Long) {
        patientRepository.findByIdOrNull(id)?.let {
            patientRepository.deleteById(id);
        } ?: throw EntityNotFoundException("O id informado não foi encontrado")
    }
}