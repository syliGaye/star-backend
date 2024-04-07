package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.embeddable.CalendarDatesPK
import ci.sylvestregaye.starbackend.model.enums.ExceptionType
import jakarta.persistence.*
import java.util.*

/**
 * The calendar_dates.txt table explicitly activates or disables service by date. It may be used in two ways.
 *
 * Recommended: Use calendar_dates.txt in conjunction with calendar.txt to define exceptions to the default service patterns defined in calendar.txt. If service is generally regular, with a few changes on explicit dates (for instance, to accommodate special event services, or a school schedule), this is a good approach. In this case calendar_dates.service_id is a foreign ID referencing calendar.service_id.
 * Alternate: Omit calendar.txt, and specify each date of service in calendar_dates.txt. This allows for considerable service variation and accommodates service without normal weekly schedules. In this case service_id is an ID.
 */
@Entity
@Table(name="calendar_dates")
class CalendarDates {
    /**
     * Identifies a set of dates when a service exception occurs for one or more routes. Each (service_id, date) pair may only appear once in calendar_dates.txt if using calendar.txt and calendar_dates.txt in conjunction. If a service_id value appears in both calendar.txt and calendar_dates.txt, the information in calendar_dates.txt modifies the service information specified in calendar.txt.
     */
    @EmbeddedId
    var id: CalendarDatesPK? = null

    /**
     * Indicates whether service is available on the date specified in the date field.
     */
    @Column(name="exception_type", nullable = false)
    var exceptionType: ExceptionType = ExceptionType.NONE

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id", nullable = false, foreignKey = ForeignKey(name = "fk_calendar_dates_service"))
    var service: Service? = null
}