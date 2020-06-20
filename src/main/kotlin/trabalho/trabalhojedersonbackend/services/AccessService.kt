package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.response.AccessResponse

interface AccessService {
    fun login(username: String, password: String): AccessResponse;
}