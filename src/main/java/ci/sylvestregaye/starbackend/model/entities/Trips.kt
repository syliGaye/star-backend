package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "trip")
class Trips: BaseEntity() {
    /**
     * Identifies a trip.
     */
    @Column(name = "trip_id")
    var tripId: String = ""

    /**
     * Text that appears on signage identifying the trip's destination to riders.
     */
    @Column(name = "headsign")
    var headsign: String = ""

    /**
     * Public facing text used to identify the trip to riders, for instance, to identify train numbers for commuter rail trips.
     */
    @Column(name = "short_name")
    var shortName: String = ""

    /**
     * Indicates wheelchair accessibility. Valid options are:
     *
     * 0 or empty - No accessibility information for the trip.
     * 1 - Vehicle being used on this particular trip can accommodate at least one rider in a wheelchair.
     * 2 - No riders in wheelchairs can be accommodated on this trip.
     */
    @Column(name = "wheelchair_accessible")
    var wheelchairAccessible: String = ""

    /**
     * Indicates whether bikes are allowed. Valid options are:
     *
     * 0 or empty - No bike information for the trip.
     * 1 - Vehicle being used on this particular trip can accommodate at least one bicycle.
     * 2 - No bicycles are allowed on this trip.
     */
    @Column(name = "bikes_allowed")
    var bikesAllowed: String = ""

    /**
     * Indicates the direction of travel for a trip. This field should not be used in routing; it provides a way to separate trips by direction when publishing time tables. Valid options are:
     *
     * 0 - Travel in one direction (e.g. outbound travel).
     * 1 - Travel in the opposite direction (e.g. inbound travel).
     */
    @Column(name = "direction", nullable = false)
    var directions: String? = ""

    /**
     * Identifies the block to which the trip belongs.
     */
    @ManyToOne
    @JoinColumn(name = "block_id", foreignKey = ForeignKey(name = "fk_trip_block"))
    var blocks: Blocks? = null

    /**
     * Identifies a geospatial shape describing the vehicle travel path for a trip.
     */
    @ManyToOne
    @JoinColumn(name = "shape_id", nullable = false, foreignKey = ForeignKey(name = "fk_trip_shape"))
    var shapes: Shapes? = null

    /**
     * Identifies a set of dates when service is available for one or more routes.
     */
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false, foreignKey = ForeignKey(name = "fk_trip_service"))
    var service: Service? = null

    /**
     * Identifies a route.
     */
    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false, foreignKey = ForeignKey(name = "fk_trip_route"))
    var routes: Routes? = null
}
