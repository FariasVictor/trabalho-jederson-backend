package trabalho.trabalhojedersonbackend.model

import org.hibernate.validator.constraints.Length
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import javax.persistence.*

@Entity
class Access(
        @Enumerated(EnumType.STRING)
        val userType: UserTypeEnum,

        @Column(nullable = false)
        val userId: Long,

        @Id
        @Column(length = 50)
        val username: String,

        @Length(min = 6, max = 12)
        @Column(length = 12)
        val password: String
) {

}