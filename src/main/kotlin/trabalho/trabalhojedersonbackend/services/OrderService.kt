package trabalho.trabalhojedersonbackend.services

import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.enums.OrderStatusEnum
import trabalho.trabalhojedersonbackend.model.Order

@Service
interface OrderService {
    fun findById(id:Long): Order?
    fun findAll(): List<Order>
    fun create(order:Order): Long
    fun update(id: Long, newStatusEnum: OrderStatusEnum )
}