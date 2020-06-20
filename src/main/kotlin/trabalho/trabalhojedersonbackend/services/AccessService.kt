package trabalho.trabalhojedersonbackend.services

import org.eclipse.jgit.transport.CredentialItem
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import trabalho.trabalhojedersonbackend.model.response.AccessResponse

interface AccessService {
    fun login(username: String, password: String): AccessResponse;
    fun patientRegister();
    fun doctorRegister();
    fun clinicRegister();
}