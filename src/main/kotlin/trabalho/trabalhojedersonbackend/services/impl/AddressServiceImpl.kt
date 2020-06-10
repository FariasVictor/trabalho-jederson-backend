package trabalho.trabalhojedersonbackend.services.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import trabalho.trabalhojedersonbackend.model.Address
import trabalho.trabalhojedersonbackend.repositories.AddressRepository
import trabalho.trabalhojedersonbackend.services.AddressService

@Service
class AddressServiceImpl(val addressRepository: AddressRepository): AddressService {

    override fun findAll(): List<Address>? = addressRepository.findAll()

    override fun findById(id: Long): Address? = addressRepository.findByIdOrNull(id)

    override fun save(address: Address) = addressRepository.save(address)

    override fun deleteById(id: Long) = addressRepository.deleteById(id)
}