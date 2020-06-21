package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
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

    @GetMapping("{userType}/{userId}")
    fun findUserAllExams(@PathVariable userType: UserTypeEnum, @PathVariable userId: Long): ResponseEntity<List<Exam>?> {
        return try {
            ResponseEntity.ok(examService.findUserAllExams(userType, userId))
        } catch (ex: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("{userType}/{userId}/{status}")
    fun findExamsByStatus(@PathVariable userType: UserTypeEnum,
                          @PathVariable userId: Long,
                          @PathVariable status: ExamStatusEnum
    ): ResponseEntity<List<Exam>> {
        return try {
            ResponseEntity.ok(examService.findUserExamsByStatus(userType, userId, status))
        } catch (ex: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    //Permite a clínica logada buscar os exames por usuário(seja médico ou paciente)
    @GetMapping("byUser/{clinicId}/{userToBeFoundType}/{userId}")
    fun findExamByUser(@PathVariable clinicId: Long,
                       @PathVariable userToBeFoundType: UserTypeEnum,
                       @PathVariable userId: Long): ResponseEntity<Any> {
        return try {
            examService.clinicFindByUser(clinicId, userToBeFoundType, userId).let {
                ResponseEntity.ok(it)
            }
        } catch (ex: EntityNotFoundException) {
            ResponseEntity.notFound().build()
        } catch (ex: BadRequestException) {
            ResponseEntity.badRequest().body(ex.message)
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