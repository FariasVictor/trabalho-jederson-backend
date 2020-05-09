package trabalho.trabalhojedersonbackend.model

class Doctor(
        id: Long,
        name: String,
        phone: String,
        address: Address,
        crm: String
) : Identifiable(id, name, phone, address) {
}