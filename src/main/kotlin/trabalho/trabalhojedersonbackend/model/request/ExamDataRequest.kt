package trabalho.trabalhojedersonbackend.model.request

data class ExamDataRequest(
        val key: String,
        val value: String,
        val examId: Long
) {
}