package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.model.request.PatientRequest
import trabalho.trabalhojedersonbackend.services.impl.PatientServiceImpl
import java.net.URI
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

@RestController
@RequestMapping("/patients")
class PatientController(val patientService: PatientServiceImpl) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Patient> {
        return patientService.findById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping()
    fun findAll(): List<Patient> = patientService.findAll()

    @PostMapping()
    fun create(@RequestBody patient: PatientRequest): ResponseEntity<Patient> {
        val savedPatient = patientService.create(patient)
        val location: URI = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(savedPatient.id)
        return ResponseEntity.created(location).build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody patient: Patient): ResponseEntity<Patient>{
        return try {
            patientService.update(id,patient)
            ResponseEntity.noContent().build()
        } catch (ex: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return try {
            patientService.delete(id)
            ResponseEntity.noContent().build()
        } catch (ex: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

}