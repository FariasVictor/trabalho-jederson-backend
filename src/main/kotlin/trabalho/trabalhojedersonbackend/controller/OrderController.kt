package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import trabalho.trabalhojedersonbackend.enums.OrderStatusEnum
import trabalho.trabalhojedersonbackend.model.Order
import trabalho.trabalhojedersonbackend.services.OrderService
import java.net.URI
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/orders")
class OrderController(val orderService: OrderService) {

    @GetMapping
    fun findAll(): List<Order> = orderService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Order> {
        return orderService.findById(id)?.let { ResponseEntity.ok(it) }
                ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody order: Order): ResponseEntity<Any> {
        val id: Long = orderService.create(order)
        var location: URI = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(id)
        return ResponseEntity.created(location).build()
    }

    @PutMapping("/{id}/{status}")
    fun update(@PathVariable("id") id: Long, @PathVariable("status") newStatusEnum: OrderStatusEnum): ResponseEntity<Any> {
        return try {
            orderService.update(id, newStatusEnum)
            ResponseEntity.noContent().build()
        }catch (ex: EntityNotFoundException){
            ResponseEntity.notFound().build()
        }
    }

}