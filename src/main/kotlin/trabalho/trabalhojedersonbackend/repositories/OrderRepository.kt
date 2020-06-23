package trabalho.trabalhojedersonbackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import trabalho.trabalhojedersonbackend.enums.OrderStatusEnum
import trabalho.trabalhojedersonbackend.model.Order

interface OrderRepository : JpaRepository<Order, Long> {
   
    fun findByPatientId(patientId: Long): List<Order>
    fun findByClinicId(clinicId: Long): List<Order>
    fun findByDoctorId(doctorId: Long): List<Order>

    fun findByStatusAndPatientId(status: OrderStatusEnum, patientId: Long): List<Order>
    fun findByStatusAndClinicId(status: OrderStatusEnum, clinicId: Long): List<Order>
    fun findByStatusAndDoctorId(status: OrderStatusEnum, doctorId: Long): List<Order>
}