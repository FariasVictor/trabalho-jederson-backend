package trabalho.trabalhojedersonbackend.model

import io.kotlintest.matchers.string.haveMaxLength
import io.kotlintest.matchers.string.haveMinLength
import org.eclipse.jgit.transport.CredentialItem
import org.hibernate.validator.constraints.Length
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import javax.persistence.*
import kotlin.math.min

@Entity
class Accesses(
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