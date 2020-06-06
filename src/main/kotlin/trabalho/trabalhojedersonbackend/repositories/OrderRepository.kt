package trabalho.trabalhojedersonbackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import trabalho.trabalhojedersonbackend.model.Order

interface OrderRepository : JpaRepository<Order, Long> {
}