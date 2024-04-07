package ci.sylvestregaye.starbackend.model.embeddable

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.io.Serializable
import java.util.*

@Embeddable
class CalendarDatesPK: Serializable {
    /**
     * Date when service exception occurs.
     */
    @Column(name="date", nullable = false)
    @Temporal(TemporalType.DATE)
    var date: Date? = null

    @Column(name = "service_id", nullable = false)
    var serviceId: Long = -1L
}