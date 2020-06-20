package trabalho.trabalhojedersonbackend.model.response

import trabalho.trabalhojedersonbackend.enums.UserTypeEnum

class AccessResponse(
        val userTypeEnum: UserTypeEnum,
        val userId: Long
) {

}