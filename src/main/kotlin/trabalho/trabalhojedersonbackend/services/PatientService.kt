package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.model.Patient

interface PatientService {
    fun findById(id: Long): Patient?

    fun findAll(): List<Patient>

    fun delete(id:Long)
}