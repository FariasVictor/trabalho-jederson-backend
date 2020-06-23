package trabalho.trabalhojedersonbackend.exceptions

class ExamAlreadyAnalisedException(override val message: String? = "Exame já finalizado"): RuntimeException(message){

}