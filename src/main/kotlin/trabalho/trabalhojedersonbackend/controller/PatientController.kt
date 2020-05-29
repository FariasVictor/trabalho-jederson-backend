package trabalho.trabalhojedersonbackend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.services.impl.PatientServiceImpl

@RestController
@RequestMapping("/patient")
class PatientController(val patientService: PatientServiceImpl) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Patient {
        return patientService.findById(id)
    }

    @GetMapping()
    fun findAll(): List<Patient> {
        return patientService.findAll();
    }
}