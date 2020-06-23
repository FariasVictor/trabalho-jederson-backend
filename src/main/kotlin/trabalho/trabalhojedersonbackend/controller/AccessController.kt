package trabalho.trabalhojedersonbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import trabalho.trabalhojedersonbackend.exceptions.InvalidAccessDataException
import trabalho.trabalhojedersonbackend.model.request.AccessRequest
import trabalho.trabalhojedersonbackend.model.response.AccessResponse
import trabalho.trabalhojedersonbackend.services.AccessService
import javax.validation.Valid

@RestController
@RequestMapping("/accesses")
class AccessController(val accessService: AccessService) {

    @GetMapping
    fun login(@RequestBody @Valid accessRequest: AccessRequest): ResponseEntity<AccessResponse>{
        return try {
            accessService.login(accessRequest.username, accessRequest.password).let {
                ResponseEntity.ok(it)
            }
        }catch (ex: InvalidAccessDataException){
            ResponseEntity.status(401).build()
        }
    }
}