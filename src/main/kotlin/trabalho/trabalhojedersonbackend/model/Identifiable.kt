package trabalho.trabalhojedersonbackend.model

import javax.persistence.MappedSuperclass

@MappedSuperclass
open class Identifiable(
        id: Long,
        name: String,
        phone: String,
        address: Address?
) {
}
