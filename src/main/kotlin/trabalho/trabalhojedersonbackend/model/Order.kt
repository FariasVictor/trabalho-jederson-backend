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
        val id: Long,

        val examType: String,

        @Enumerated(EnumType.STRING)
        var status: OrderStatusEnum?,

        @ManyToOne
        val patient: Patient,

        @ManyToOne
        val doctor: Doctor,

        @ManyToOne
        val clinic: Clinic,

        @CreationTimestamp
        val creationDate: LocalDateTime?,

        @UpdateTimestamp
        val statusChanged: LocalDateTime?

) {
}