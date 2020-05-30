package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.repositories.ClinicRepository
import trabalho.trabalhojedersonbackend.services.ClinicService
import java.util.*

@Service
class ClinicServiceImpl(val clinicRepository: ClinicRepository) : ClinicService {

    override fun findById(id: Long): Clinic? = clinicRepository.findByIdOrNull(id)

    override fun persistence(clinic: Clinic): Clinic = clinicRepository.save(clinic)
}