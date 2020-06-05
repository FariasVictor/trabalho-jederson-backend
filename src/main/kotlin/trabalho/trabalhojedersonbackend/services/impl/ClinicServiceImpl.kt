package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.repositories.ClinicRepository
import trabalho.trabalhojedersonbackend.services.ClinicService

@Service
class ClinicServiceImpl(val clinicRepository: ClinicRepository, val clinic: Clinic) : ClinicService {

    override fun findAll(): List<Clinic>? = clinicRepository.findAll()

    override fun findById(id: Long): Clinic? = clinicRepository.findByIdOrNull(id)

    override fun save(clinic: Clinic) = clinicRepository.save(clinic)

    override fun deleteById(id: Long) = clinicRepository.deleteById(id)
}