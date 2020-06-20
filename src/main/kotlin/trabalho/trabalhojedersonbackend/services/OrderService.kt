package trabalho.trabalhojedersonbackend.services

import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.enums.OrderStatusEnum
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import trabalho.trabalhojedersonbackend.model.Exam
import trabalho.trabalhojedersonbackend.model.Order

@Service
interface OrderService {
    fun findById(id:Long): Order?
    fun findAll(): List<Order>

    //Encontrar todos os orders do usuário logado
    fun findAllByUser(userType: UserTypeEnum, userId: Long): List<Order>
    fun findAllByClinicId(clinicId: Long): List<Order>
    fun findAllByDoctorId(doctorId: Long): List<Order>
    fun findAllByPatientId(patientId: Long): List<Order>

    fun create(order:Order): Long
    fun update(id: Long, newStatusEnum: OrderStatusEnum )
}