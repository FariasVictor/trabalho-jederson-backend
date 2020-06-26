package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.exceptions.OrderAlreadyAnsweredException
import trabalho.trabalhojedersonbackend.enums.OrderStatusEnum
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import trabalho.trabalhojedersonbackend.mapper.OrderMapper
import trabalho.trabalhojedersonbackend.model.Exam
import trabalho.trabalhojedersonbackend.model.Order
import trabalho.trabalhojedersonbackend.model.request.OrderRequest
import trabalho.trabalhojedersonbackend.repositories.OrderRepository
import trabalho.trabalhojedersonbackend.services.ExamService
import trabalho.trabalhojedersonbackend.services.OrderService
import javax.persistence.EntityNotFoundException

@Service
class OrderServiceImpl(val orderRepository: OrderRepository,
                       val orderMapper: OrderMapper,
                        val examService: ExamService) : OrderService {

    override fun create(orderRequest: OrderRequest): Long {
        val order = orderMapper.toPatient(orderRequest)
        order.status = OrderStatusEnum.SOLICITACAO_ABERTA
        return orderRepository.save(order).id!!;
    }

    override fun findById(id: Long): Order? = orderRepository.findByIdOrNull(id)

    override fun findAll(): List<Order> = orderRepository.findAll()

    override fun findAllByUser(userType: UserTypeEnum, userId: Long): List<Order> {
        return when (userType) {
            UserTypeEnum.CLINIC -> {
                findAllByClinicId(userId)
            }
            UserTypeEnum.DOCTOR -> {
                findAllByDoctorId(userId)
            }
            UserTypeEnum.PATIENT -> {
                findAllByPatientId(userId)
            }
        }
    }

    override fun findAllByPatientId(patientId: Long): List<Order> {
        return orderRepository.findByPatientId(patientId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findAllByClinicId(clinicId: Long): List<Order> {
        return orderRepository.findByClinicId(clinicId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findAllByDoctorId(doctorId: Long): List<Order> {
        return orderRepository.findByDoctorId(doctorId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findUserOrdersByStatus(userType: UserTypeEnum, userId: Long, status: OrderStatusEnum): List<Order> {
        return when (userType) {
            UserTypeEnum.CLINIC -> {
                findClinicOrdersByStatus(userId, status)
            }
            UserTypeEnum.DOCTOR -> {
                findDoctorOrdersByStatus(userId, status)
            }
            UserTypeEnum.PATIENT -> {
                findPatientOrdersByStatus(userId, status)
            }
        }
    }

    override fun findPatientOrdersByStatus(patientId: Long, status: OrderStatusEnum): List<Order> {
        return orderRepository.findByStatusAndPatientId(status, patientId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findClinicOrdersByStatus(clinicId: Long, status: OrderStatusEnum): List<Order> {
        return orderRepository.findByStatusAndClinicId(status, clinicId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findDoctorOrdersByStatus(doctorId: Long, status: OrderStatusEnum): List<Order> {
        return orderRepository.findByStatusAndDoctorId(status, doctorId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun update(id: Long, newStatusEnum: OrderStatusEnum) {
        orderRepository.findByIdOrNull(id)?.let {
            if (it.status != (OrderStatusEnum.SOLICITACAO_ABERTA)) {
                throw OrderAlreadyAnsweredException()
            }
            it.status = newStatusEnum
            val order = orderRepository.save(it)
            if (newStatusEnum == OrderStatusEnum.SOLICITACAO_ACEITA) {

                examService.save(Exam(null,
                        null,
                        order.examType!!,
                        null,
                        null,
                        order.patient!!,
                        order.doctor!!,
                        order.clinic!!)
                )
            }
        } ?: throw EntityNotFoundException()
    }

}