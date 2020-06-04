package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.services.impl.PatientServiceImpl

@RestController
@RequestMapping("/patients")
class PatientController(val patientService: PatientServiceImpl) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Patient> {
        return patientService.findById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping()
    fun findAll(): List<Patient> = patientService.findAll()

}