package trabalho.trabalhojedersonbackend.model.request

data class OrderRequest(
        val examType: String,

        val patientId: Long,

        val doctorId: Long,

        val clinicId: Long
) {

}