package trabalho.trabalhojedersonbackend.services

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.enums.OrderStatusEnum
import trabalho.trabalhojedersonbackend.model.Order
import trabalho.trabalhojedersonbackend.model.OrderRequest

@Service
interface OrderService {
    fun findById(id:Long): Order?
    fun findAll(): List<Order>
    fun create(order:Order): Long
    fun update(id: Long, newStatusEnum: OrderStatusEnum )
}