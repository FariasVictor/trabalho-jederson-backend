package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import trabalho.trabalhojedersonbackend.exceptions.InvalidAccessDataException
import trabalho.trabalhojedersonbackend.model.Access
import trabalho.trabalhojedersonbackend.model.response.AccessResponse
import trabalho.trabalhojedersonbackend.repositories.AccessRepository
import trabalho.trabalhojedersonbackend.services.AccessService
import javax.persistence.EntityNotFoundException

@Service
class AccessServiceImpl(val accessRepository: AccessRepository) : AccessService {

    override fun login(username: String, password: String): AccessResponse {
        val access: Access = accessRepository.findByUsernameAndPassword(username, password)
                ?: throw InvalidAccessDataException()
        return AccessResponse(access.userType,access.userId)
    }

    override fun patientRegister() {
        TODO("Not yet implemented")
    }

    override fun doctorRegister() {
        TODO("Not yet implemented")
    }

    override fun clinicRegister() {
        TODO("Not yet implemented")
    }
}