package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.model.request.PatientRequest

interface PatientService {
    fun findById(id: Long): Patient?

    fun findAll(): List<Patient>

    fun create(patient: PatientRequest): Patient

    fun update(id: Long, patient: Patient)

    fun delete(id: Long)
}