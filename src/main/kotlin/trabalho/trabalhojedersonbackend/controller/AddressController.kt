package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import trabalho.trabalhojedersonbackend.model.Address
import trabalho.trabalhojedersonbackend.services.AddressService
import javax.validation.Valid

@RestController
@RequestMapping("/Address")
class AddressController(private val addressService: AddressService) {

    @GetMapping
    fun findAll() = addressService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<Address> {
        return addressService.findById(id)?.let {
            ResponseEntity.ok(it)
        }?:ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@Valid @RequestBody address: Address): ResponseEntity<Address> {
        return addressService.save(address).let {
            ResponseEntity.ok(it)
        }
    }

    @PatchMapping("/{id}")
    fun update(@Valid @RequestBody address: Address): ResponseEntity<Address> {
        return addressService.save(address).let {
            ResponseEntity.ok(it)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") id: Long) {
        return addressService.deleteById(id).let {
            ResponseEntity.noContent()
        }
    }
}