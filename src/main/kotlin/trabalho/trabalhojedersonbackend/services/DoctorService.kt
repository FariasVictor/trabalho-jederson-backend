package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Doctor

interface DoctorService {

    fun findAll(): List<Doctor>?

    fun findById(id: Long): Doctor?

    fun save(doctor: Doctor): Doctor

    fun update(id: Long, doctor: Doctor)

    fun delete(id: Long)
}