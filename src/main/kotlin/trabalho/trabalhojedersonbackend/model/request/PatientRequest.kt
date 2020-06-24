package trabalho.trabalhojedersonbackend.model.request

import trabalho.trabalhojedersonbackend.model.Address
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class PatientRequest(
        @NotBlank
        val cpf: String,

        @NotBlank
        val name: String,

        @NotBlank
        val phone: String,

        @NotNull
        val birthDate: LocalDate,

        @NotBlank
        val insuranceNumber: String,

        @NotNull
        val address: Address
) {

}