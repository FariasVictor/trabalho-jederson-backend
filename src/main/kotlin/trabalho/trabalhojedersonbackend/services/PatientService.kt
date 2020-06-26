package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Patient

interface PatientService {
    fun findById(id: Long): Patient?

    fun findAll(): List<Patient>

    fun create(patient: Patient): Patient

    fun update(id: Long, patient: Patient)

    fun delete(id: Long)
}