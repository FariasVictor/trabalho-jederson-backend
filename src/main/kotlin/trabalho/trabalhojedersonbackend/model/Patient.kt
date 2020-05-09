package trabalho.trabalhojedersonbackend.model

import java.time.LocalDateTime

class Patient(
        id: Long,
        cpf: String,
        name: String,
        phone: String,
        birthDate: LocalDateTime,
        insuranceNumber: String?,
        address: Address
) : Identifiable(id, name, phone, address) {

}
