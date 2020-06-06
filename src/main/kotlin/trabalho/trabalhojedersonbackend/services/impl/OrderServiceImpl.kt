package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.exceptions.OrderAlreadyAnsweredException
import trabalho.trabalhojedersonbackend.enums.OrderStatusEnum
import trabalho.trabalhojedersonbackend.model.Order
import trabalho.trabalhojedersonbackend.repositories.OrderRepository
import trabalho.trabalhojedersonbackend.services.OrderService
import javax.persistence.EntityNotFoundException

@Service
class OrderServiceImpl(val orderRepository: OrderRepository) : OrderService {

    override fun findById(id: Long): Order? = orderRepository.findByIdOrNull(id)

    override fun findAll(): List<Order> = orderRepository.findAll()

    override fun create(order: Order): Long {
        order.status = OrderStatusEnum.SOLICITACAO_ABERTA
        return orderRepository.save(order).id;
    }

    override fun update(id: Long, newStatusEnum: OrderStatusEnum) {
        orderRepository.findByIdOrNull(id)?.let {
            if (it.status!=(OrderStatusEnum.SOLICITACAO_ABERTA)) {
                throw OrderAlreadyAnsweredException()
            }
            it.status = newStatusEnum
        } ?: throw EntityNotFoundException()
    }
}