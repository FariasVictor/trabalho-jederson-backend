package trabalho.trabalhojedersonbackend.model

import javax.persistence.*

@Entity
class Doctor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val name: String,
        val phone: String,

        @OneToOne(cascade = [CascadeType.ALL])
        val address: Address,

        val crm: String
) : Identifiable(id, name, phone, address) {
}