package trabalho.trabalhojedersonbackend.controller

import io.kotlintest.matchers.numerics.beOdd
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.exceptions.BadRequestException
import trabalho.trabalhojedersonbackend.exceptions.ExamAlreadyAnalisedException
import trabalho.trabalhojedersonbackend.model.Exam
import trabalho.trabalhojedersonbackend.services.ExamService
import java.net.URI
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

@RestController
@RequestMapping("/exam")
class ExamController(private val examService: ExamService) {

    @GetMapping()
    fun findAllExams() = examService.findAll()

    @GetMapping("/{id}")
    fun findExamById(@Valid @PathVariable(value = "id") id: Long): ResponseEntity<Exam> {
        return examService.findById(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/filter")
    fun findExamFiltered(
            @RequestParam(required = false) name: String?,
            @RequestParam(required = false) status: ExamStatusEnum?
    ): ResponseEntity<List<Exam>> {
        return try {
            examService.findFiltered(name, status)?.let {
                ResponseEntity.ok().body(it)
            } ?: ResponseEntity.notFound().build()
        } catch (ex: BadRequestException) {
            ResponseEntity.badRequest().build()
        }
    }

    //Não finalizado, só tem por patient+status
    @GetMapping("{patientId}/filter")
    fun findPatientExamsFiltered(
            @PathVariable patientId: Long,
            @RequestParam(required = false) name: String?,
            @RequestParam(required = false) status: ExamStatusEnum?
    ): ResponseEntity<List<Exam>> {
        return try {
            examService.findPatientExamsFiltered(patientId, name, status)?.let {
                ResponseEntity.ok().body(it)
            } ?: ResponseEntity.notFound().build()
        } catch (ex: BadRequestException) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    fun create(@RequestBody exam: Exam): ResponseEntity<Exam> {
        val examCreated = examService.save(exam)
        val location: URI = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(examCreated?.id)
        return ResponseEntity.created(location).body(examCreated)
    }

    @PatchMapping("/{id}")
    fun updateExam(@Valid @PathVariable id: Long): ResponseEntity<Any> {
        return try {
            val exam = examService.update(id)
            ResponseEntity.ok(exam)
        } catch (ex: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        } catch (ex: ExamAlreadyAnalisedException) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteExamById(@PathVariable(value = "id") id: Long): ResponseEntity<Any> = ResponseEntity.noContent().build()
}