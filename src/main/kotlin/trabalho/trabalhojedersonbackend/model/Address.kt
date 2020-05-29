package trabalho.trabalhojedersonbackend.model

import javax.persistence.*

data class Address(
        var id: Long = 0L,
        var state: String,
        var city: String,
        var street: String,
        var number: String,
        var complement: String
) {

}