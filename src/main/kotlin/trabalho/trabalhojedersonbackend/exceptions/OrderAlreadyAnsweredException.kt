package trabalho.trabalhojedersonbackend.exceptions

class OrderAlreadyAnsweredException(message: String = "A solicitação já foi encerrada") : RuntimeException(message) {
}