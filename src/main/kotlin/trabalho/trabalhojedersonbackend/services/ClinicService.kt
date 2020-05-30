package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Clinic
import java.util.*

interface ClinicService {
    fun findById(id: Long): Clinic?

    fun persistence(clinic: Clinic): Clinic
}