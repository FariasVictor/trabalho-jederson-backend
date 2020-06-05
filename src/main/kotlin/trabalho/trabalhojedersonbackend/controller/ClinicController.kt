package trabalho.trabalhojedersonbackend.controller

import com.sun.jdi.request.EventRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.repositories.ClinicRepository
import trabalho.trabalhojedersonbackend.services.ClinicService
import javax.validation.Valid


@RestController
@RequestMapping("/clinic")
class ClinicController(private val clinicService: ClinicService, private val clinicRepository: ClinicRepository) {

    @GetMapping()
    fun findAllClinics() = clinicService.findAll()


    @GetMapping("/{id}")
    fun findClinicById(@PathVariable(value = "id") id: Long): ResponseEntity<Clinic> {
        return clinicService.findById(id)?.let {
            ResponseEntity.ok(it)
        }?:(ResponseEntity.notFound().build())
    }

    @PostMapping("/save")
    fun createClinic(@Valid @RequestBody clinic: Clinic): ResponseEntity<Clinic> {
        return clinicRepository.save(clinic).let {
            ResponseEntity.ok(it)
        }
    }

    @PatchMapping
    fun updateClinic(@Valid @RequestBody clinic: Clinic): ResponseEntity<Clinic>? {
        return clinicRepository.save(clinic).let {
            ResponseEntity.ok(it)
        }

    }

    @DeleteMapping("/delete/{id}")
    fun deleteClinicById(@PathVariable(value = "id") id: Long): ResponseEntity<Clinic>? {
        return clinicService.deleteById(id)?.let {
            ResponseEntity.ok(it)
        }?:(ResponseEntity.notFound().build())
    }
}