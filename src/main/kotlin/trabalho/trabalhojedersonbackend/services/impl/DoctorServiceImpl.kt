package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.model.Doctor
import trabalho.trabalhojedersonbackend.repositories.DoctorRepository
import trabalho.trabalhojedersonbackend.services.DoctorService

@Service
class DoctorServiceImpl(val doctorRepository: DoctorRepository, val doctor: Doctor) : DoctorService {

    override fun findAll(): List<Doctor>? = doctorRepository.findAll()

    override fun findById(id: Long): Doctor? = doctorRepository.findByIdOrNull(id)

    override fun save(doctor: Doctor): Doctor = doctorRepository.save(doctor)

    override fun deleteById(id: Long) = doctorRepository.deleteById(id)
}