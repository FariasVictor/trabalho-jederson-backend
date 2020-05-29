package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.model.Patient

interface PatientService {
    fun findById(id: Long): Patient

    fun persist(clinic: Clinic): List<Patient>
}