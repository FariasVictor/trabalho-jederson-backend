package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Doctor

interface DoctorService {

    fun findAll(): List<Doctor>?

    fun findById(id: Long): Doctor?

    fun save(doctor: Doctor): Doctor

    fun deleteById(id: Long)
}