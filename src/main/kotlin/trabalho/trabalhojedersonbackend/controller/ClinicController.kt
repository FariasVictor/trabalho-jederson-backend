package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.HttpStatus
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
    fun findAllClinics() = clinicRepository.findAll()


    @GetMapping("/{id}")
    fun getClinicById(@PathVariable(value = "id") id: Long): ResponseEntity<Clinic> {
        return clinicService.findById(id).map { clinic ->
            ResponseEntity.ok(clinic)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping()
    fun createClinic(@Valid @RequestBody clinic: Clinic) {
        clinicRepository.save(clinic)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteClinicById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return clinicRepository.findById(id).map { clinic ->
            clinicRepository.delete(clinic)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}