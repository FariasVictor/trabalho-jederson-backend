package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Clinic

interface ClinicService {
    fun findById(id: Long)

    fun persistir(clinic: Clinic)
}