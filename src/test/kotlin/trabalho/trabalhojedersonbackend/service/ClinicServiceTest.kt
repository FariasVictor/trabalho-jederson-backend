package trabalho.trabalhojedersonbackend.service

import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import trabalho.trabalhojedersonbackend.model.Address
import trabalho.trabalhojedersonbackend.model.Clinic
import trabalho.trabalhojedersonbackend.repositories.ClinicRepository
import trabalho.trabalhojedersonbackend.services.ClinicService

@SpringBootTest
class ClinicServiceTest  {

//    @Autowired
//    private val clinicService: ClinicService? = null
//
//    @MockBean
//    private val clinicRepository: ClinicRepository? = null
//
//    private val id = 1L
//
//    @Before
//    @Throws(Exception::class)
//    fun setUp() {
//        BDDMockito.given(clinicRepository?.findById(id)).willReturn(clinic())
//        BDDMockito.given(clinicRepository?.save(clinic())).willReturn(clinic())
//    }
//
//    @Test
//    fun testFindClinicById() {
//        val clinic: Clinic? = clinicService?.findById(id)
//        org.springframework.util.Assert.assertNotNull(clinic)
//    }
//
//    private fun clinic(): Clinic = Clinic(id,
//            "Farias MasNumFez",
//            "16966666666",
//            address = Address(1L,
//                "SP",
//                "AQA",
//                "Sem RUA",
//                "510",
//                "Bloco 2"),
//            cnpj = "12345678901234")
}