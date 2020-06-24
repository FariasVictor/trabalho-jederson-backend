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
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.services.ClinicService
import javax.validation.Valid

@RestController
@RequestMapping("/clinic")
class ClinicController(private val clinicService: ClinicService) {

    @GetMapping
    fun findAllClinics() = clinicService.findAll()


    @GetMapping("/{id}")
    fun findClinicById(@PathVariable(value = "id") id: Long): ResponseEntity<Clinic> {
        return clinicService.findById(id)?.let {
            ResponseEntity.ok(it)
        }?:ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createClinic(@Valid @RequestBody clinic: Clinic): ResponseEntity<Clinic> {
        return clinicService.save(clinic).let {
            ResponseEntity.ok(it)
        }
    }

    @PatchMapping("/{id}")
    fun updateClinic(@Valid @RequestBody clinic: Clinic,
                     @PathVariable(value = "id") id: Long): ResponseEntity<Clinic>? {
        if(clinicService.findById(id) == null) {
            return ResponseEntity.notFound().build()
        }

        return clinicService.save(Clinic(id,
                clinic.name,
                clinic.phone,
                clinic.address,
                clinic.cnpj)).let {
            ResponseEntity.ok(it)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteClinicById(@PathVariable(value = "id") id: Long): ResponseEntity<Clinic>? {
        if (clinicService.findById(id) == null) {
            return ResponseEntity.notFound().build()
        }
        return clinicService.deleteById(id).let {
            ResponseEntity.noContent().build()
        }
    }
}