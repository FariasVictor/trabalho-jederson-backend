package trabalho.trabalhojedersonbackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Address(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0L,
        var state: String,
        var city: String,
        var street: String,
        var number: String,
        var complement: String
) {

}