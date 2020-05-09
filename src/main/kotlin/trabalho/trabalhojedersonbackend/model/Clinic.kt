package trabalho.trabalhojedersonbackend.model

class Clinic(
        id: Long,
        name: String,
        phone: String,
        address: Address,
        cnpj: String
) :Identifiable(id, name, phone, address) {

}