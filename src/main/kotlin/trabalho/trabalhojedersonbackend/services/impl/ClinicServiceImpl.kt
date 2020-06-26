package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.repositories.ClinicRepository
import trabalho.trabalhojedersonbackend.services.ClinicService
import javax.persistence.EntityNotFoundException

@Service
class ClinicServiceImpl(val clinicRepository: ClinicRepository) : ClinicService {

    override fun findAll(): List<Clinic>? = clinicRepository.findAll()

    override fun findById(id: Long): Clinic? = clinicRepository.findByIdOrNull(id)

    override fun save(clinic: Clinic) = clinicRepository.save(clinic)

    override fun update(id: Long, clinic: Clinic) {
        clinicRepository.findByIdOrNull(id)?.let {
            clinic.id = it.id
            clinicRepository.save(clinic)
        } ?: throw EntityNotFoundException("O id informado não foi encontrado")
    }

    override fun delete(id: Long) {
        clinicRepository.findByIdOrNull(id)?.let {
            clinicRepository.deleteById(id);
        } ?: throw EntityNotFoundException("O id informado não foi encontrado")
    }

}