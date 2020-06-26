package trabalho.trabalhojedersonbackend.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import trabalho.trabalhojedersonbackend.enums.OrderStatusEnum
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "exam_order")
class Order(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,

        var examType: String?,

        @Enumerated(EnumType.STRING)
        var status: OrderStatusEnum?,

        @ManyToOne
        var patient: Patient?,

        @ManyToOne
        var doctor: Doctor?,

        @ManyToOne
        var clinic: Clinic?,

        @CreationTimestamp
        val creationDate: LocalDateTime?,

        @UpdateTimestamp
        var statusChanged: LocalDateTime?

) {
    constructor() : this(null, null, null, null, null, null, null, null)
}