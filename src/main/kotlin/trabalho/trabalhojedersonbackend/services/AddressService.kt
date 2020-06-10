package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Address

interface AddressService {

    fun findAll(): List<Address>?

    fun findById(id: Long): Address?

    fun save(address: Address): Address

    fun deleteById(id: Long)
}