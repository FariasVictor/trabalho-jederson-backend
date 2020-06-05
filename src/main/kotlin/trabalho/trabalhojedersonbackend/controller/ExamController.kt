package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import trabalho.trabalhojedersonbackend.model.Exam
import trabalho.trabalhojedersonbackend.services.ExamService
import javax.validation.Valid

@RestController
@RequestMapping("/exam")
class ExamController(private val examService: ExamService) {

    @GetMapping()
    fun findAllExams() = examService.findAll()

    @GetMapping("/{id}")
    fun findExameById(@Valid @PathVariable(value = "id") id: Long): ResponseEntity<Exam> {
        return examService.findById(id)?.let {
            ResponseEntity.ok(it)
        }?: ResponseEntity.notFound().build()
    }

    @PatchMapping
    fun updateExam(@Valid @RequestBody exam: Exam): ResponseEntity<Exam> {
        return examService.save(exam).let {
            ResponseEntity.ok(it)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteExamById(@PathVariable(value = "id") id: Long) {
        ResponseEntity.ok()
    }
}