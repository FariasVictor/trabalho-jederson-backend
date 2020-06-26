package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.DeleteMapping
import trabalho.trabalhojedersonbackend.model.Doctor
import trabalho.trabalhojedersonbackend.services.DoctorService
import javax.validation.Valid

@RestController
@RequestMapping("/doctor")
class DoctorController(private val doctorService: DoctorService) {

    @GetMapping()
    fun findAllDoctors() = doctorService.findAll()

    @GetMapping("/{id}")
    fun findDoctorById(@PathVariable(value = "id") id: Long): ResponseEntity<Doctor> {
        return doctorService.findById(id)?.let {
            ResponseEntity.ok(it)
        }?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createDoctor(@Valid @RequestBody doctor: Doctor): ResponseEntity<Doctor> {
        return doctorService.save(doctor).let {
            ResponseEntity.ok(it)
        }
    }

    @PatchMapping
    fun updateDoctor(@Valid @RequestBody doctor: Doctor): ResponseEntity<Doctor>? {
        return doctorService.save(doctor).let {
            ResponseEntity.ok(it)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteDoctorById(@PathVariable(value = "id") id: Long) {
        return doctorService.deleteById(id).let {
            ResponseEntity.ok()
        }
    }
}