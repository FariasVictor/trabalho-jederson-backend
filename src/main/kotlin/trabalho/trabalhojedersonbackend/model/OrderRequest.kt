package trabalho.trabalhojedersonbackend.model

import javax.validation.constraints.NotBlank

class OrderRequest(
        @NotBlank(message = "O tipo do exame deve ser informado")
        val examType:String,
        @NotBlank(message = "O paciente deve ser informado")
        val patientId: Long,
        @NotBlank(message = "O médico deve ser informado")
        val doctorId: Long,
        @NotBlank(message = "A clínica deve ser informado")
        val clinicId: Long
) {
}