package trabalho.trabalhojedersonbackend.mapper

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import trabalho.trabalhojedersonbackend.exceptions.BadRequestException
import trabalho.trabalhojedersonbackend.model.Order
import trabalho.trabalhojedersonbackend.model.request.OrderRequest
import trabalho.trabalhojedersonbackend.repositories.ClinicRepository
import trabalho.trabalhojedersonbackend.repositories.DoctorRepository
import trabalho.trabalhojedersonbackend.repositories.PatientRepository

@Component
class OrderMapper(val clinicRepository: ClinicRepository,
                  val patientRepository: PatientRepository,
                  val doctorRepository: DoctorRepository) {

    fun toPatient(orderRequest: OrderRequest): Order {
        val order = Order()
        order.examType=orderRequest.examType
        order.patient=patientRepository.findByIdOrNull(orderRequest.patientId)?: throw BadRequestException("Informe o paciente")
        order.clinic=clinicRepository.findByIdOrNull(orderRequest.clinicId)?: throw BadRequestException("Informe a clínica")
        order.doctor=doctorRepository.findByIdOrNull(orderRequest.doctorId)?: throw BadRequestException("Informe o médico")
        return order
    }
}