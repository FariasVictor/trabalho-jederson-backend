package trabalho.trabalhojedersonbackend.exceptions

class InvalidAccessDataException(override val message: String? = "Usuário ou senha inválidos"): RuntimeException() {

}