package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import ci.sylvestregaye.starbackend.model.enums.ServiceType
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "calendar")
class Calendar: BaseEntity(){
    /**
     * Indicates whether the service operates on all Mondays in the date range specified
     * by the start_date and end_date fields.
     */
    @Column(name="monday", nullable = false)
    var monday: ServiceType = ServiceType.NOT_AVAILABLE

    /**
     * Indicates whether the service operates on all Tuesdays in the date range specified
     * by the start_date and end_date fields.
     */
    @Column(name="tuesday", nullable = false)
    var tuesday: ServiceType = ServiceType.NOT_AVAILABLE

    /**
     * Indicates whether the service operates on all Wednesdays in the date range specified
     * by the start_date and end_date fields.
     */
    @Column(name="wednesday", nullable = false)
    var wednesday: ServiceType = ServiceType.NOT_AVAILABLE

    /**
     * Indicates whether the service operates on all Thursdays in the date range specified
     * by the start_date and end_date fields.
     */
    @Column(name="thursday", nullable = false)
    var thursday: ServiceType = ServiceType.NOT_AVAILABLE

    /**
     * Indicates whether the service operates on all Fridays in the date range specified
     * by the start_date and end_date fields.
     */
    @Column(name="friday", nullable = false)
    var friday: ServiceType = ServiceType.NOT_AVAILABLE

    /**
     * Indicates whether the service operates on all Saturdays in the date range specified
     * by the start_date and end_date fields.
     */
    @Column(name="saturday", nullable = false)
    var saturday: ServiceType = ServiceType.NOT_AVAILABLE

    /**
     * Indicates whether the service operates on all Sundays in the date range specified
     * by the start_date and end_date fields.
     */
    @Column(name="sunday", nullable = false)
    var sunday: ServiceType = ServiceType.NOT_AVAILABLE

    /**
     * Start service day for the service interval.
     */
    @Column(name="start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    var startDate: Date? = null

    /**
     * End service day for the service interval.
     * This service day is included in the interval.
     */
    @Column(name="end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    var endDate: Date? = null

    /**
     * Identifies a set of dates when service is available for one or more routes.
     */
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false, foreignKey = ForeignKey(name = "fk_calendar_service"))
    var service: Service? = null
}
