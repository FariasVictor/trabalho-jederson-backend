package trabalho.trabalhojedersonbackend.model.request

import javax.validation.constraints.NotBlank

class AccessRequest(
        @NotBlank(message = "Informe o usuário")
        val username: String,

        @NotBlank(message = "Informe a senha")
        val password: String
) {

}