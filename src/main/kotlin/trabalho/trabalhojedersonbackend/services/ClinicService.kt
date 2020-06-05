package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Clinic

interface ClinicService {

    fun findAll(): List<Clinic>?

    fun findById(id: Long): Clinic?

    fun save(clinic: Clinic): Clinic

    fun deleteById(id: Long): Clinic?

}