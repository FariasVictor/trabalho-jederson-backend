package trabalho.trabalhojedersonbackend.exceptions

import java.lang.RuntimeException

class BadRequestException(override val message: String?): RuntimeException(message) {
}