package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Clinic

interface ClinicService {

    fun findAll(): List<Clinic>?

    fun findById(id: Long): Clinic?

    fun save(clinic: Clinic): Clinic

    fun update(id: Long, clinic: Clinic)

    fun delete(id: Long)

}