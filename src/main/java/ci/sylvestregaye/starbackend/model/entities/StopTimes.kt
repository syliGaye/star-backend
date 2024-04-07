package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "stop_time")
class StopTimes: BaseEntity() {
    /**
     * Arrival time at the stop (defined by stop_times.stop_id) for a specific trip (defined by stop_times.trip_id) in the time zone specified by agency.agency_timezone, not stops.stop_timezone.
     */
    @Column(name = "arrival_time", nullable = false)
    @Temporal(TemporalType.TIME)
    var arrivalTime: Date? = null

    /**
     * Departure time from the stop (defined by stop_times.stop_id) for a specific trip (defined by stop_times.trip_id) in the time zone specified by agency.agency_timezone, not stops.stop_timezone.
     */
    @Column(name = "departure_time", nullable = false)
    @Temporal(TemporalType.TIME)
    var departureTime: Date? = null

    /**
     * Identifies the serviced stop.
     */
    @ManyToOne
    @JoinColumn(name = "stop_id", nullable = false, foreignKey = ForeignKey(name = "fk_stop_time_stop"))
    var stops: Stops? = null

    /**
     * Order of stops, location groups, or GeoJSON locations for a particular trip.
     */
    @Column(name = "stop_sequence", nullable = false)
    var sequence: String = ""

    /**
     * Text that appears on signage identifying the trip's destination to riders.
     */
    @Column(name = "stop_headsign")
    var headsign: String = ""

    /**
     * Indicates pickup method. Valid options are:
     *
     * 0 or empty - Regularly scheduled pickup.
     * 1 - No pickup available.
     * 2 - Must phone agency to arrange pickup.
     * 3 - Must coordinate with driver to arrange pickup.
     */
    @Column(name = "pickup_type", nullable = false)
    var pickupType: String = ""

    /**
     * Indicates drop off method. Valid options are:
     *
     * 0 or empty - Regularly scheduled drop off.
     * 1 - No drop off available.
     * 2 - Must phone agency to arrange drop off.
     * 3 - Must coordinate with driver to arrange drop off.
     */
    @Column(name = "drop_off_type", nullable = false)
    var dropOffType: String = ""

    /**
     * Actual distance traveled along the associated shape, from the first stop to the stop specified in this record.
     */
    @Column(name = "shape_dist_traveled")
    var shapeDistTraveled: String = ""

    /**
     * Identifies a trip.
     */
    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false, foreignKey = ForeignKey(name = "fk_stop_time_trip"))
    var trips: Trips? = null
}
