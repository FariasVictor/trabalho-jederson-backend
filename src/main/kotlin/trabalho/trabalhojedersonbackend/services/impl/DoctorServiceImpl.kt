package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.model.Doctor
import trabalho.trabalhojedersonbackend.repositories.DoctorRepository
import trabalho.trabalhojedersonbackend.services.DoctorService
import javax.persistence.EntityNotFoundException

@Service
class DoctorServiceImpl(val doctorRepository: DoctorRepository) : DoctorService {

    override fun findAll(): List<Doctor>? = doctorRepository.findAll()

    override fun findById(id: Long): Doctor? = doctorRepository.findByIdOrNull(id)

    override fun save(doctor: Doctor): Doctor = doctorRepository.save(doctor)

    override fun update(id: Long, doctor: Doctor) {
        doctorRepository.findByIdOrNull(id)?.let {
            doctor.id = it.id
            doctorRepository.save(doctor)
        } ?: throw EntityNotFoundException("O id informado não foi encontrado")
    }

    override fun delete(id: Long) {
        doctorRepository.findByIdOrNull(id)?.let {
            doctorRepository.deleteById(id);
        } ?: throw EntityNotFoundException("O id informado não foi encontrado")
    }
}