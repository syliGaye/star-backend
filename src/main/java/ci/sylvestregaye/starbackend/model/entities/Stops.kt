package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import ci.sylvestregaye.starbackend.model.enums.LocationType
import jakarta.persistence.*

@Entity
@Table(name = "stop")
class Stops: BaseEntity() {
    /**
     * Identifies a location.
     */
    @Column(name="stop_id",unique = true, nullable = false)
    var stopId: String = ""

    /**
     * Short text or a number that identifies the location for riders.
     */
    @Column(name="code")
    var code: String = ""

    /**
     * Name of the location.
     */
    @Column(name="name")
    var name: String = ""

    /**
     * Description of the location that provides useful, quality information.
     */
    @Column(name="description")
    var description: String = ""

    /**
     * Latitude of the location.
     */
    @Column(name="latitude")
    var latitude: String = ""

    /**
     * Longitude of the location.
     */
    @Column(name="longitude")
    var longitude: String = ""

    /**
     * Identifies the fare zone for a stop. If this record represents a station or station entrance, the zone_id is ignored.
     */
    @Column(name="zone_id")
    var zoneId: String = ""

    /**
     * URL of a web page about the location. This should be different from the agency.agency_url and the routes.route_url field values.
     */
    @Column(name="url")
    var url: String = ""

    /**
     * Location type.
     */
    @Column(name="location_type")
    var locationType: LocationType = LocationType.STOP_PLATFORM

    /**
     * Defines hierarchy between the different locations defined in stops.txt. It contains the ID of the parent location, as followed:
     *
     * - Stop/platform (location_type=0): the parent_station field contains the ID of a station.
     * - Station (location_type=1): this field must be empty.
     * - Entrance/exit (location_type=2) or generic node (location_type=3): the parent_station field contains the ID of a station (location_type=1)
     * - Boarding Area (location_type=4): the parent_station field contains ID of a platform.
     */
    @Column(name = "parent_station")
    var parentStation: String = ""

    /**
     * Timezone of the location. If the location has a parent station, it inherits the parent station’s timezone instead of applying its own. Stations and parentless stops with empty stop_timezone inherit the timezone specified by agency.agency_timezone.
     * The times provided in {@link StopTimes::class} are in the timezone specified by 'agency.timezone', not stop_timezone. This ensures that the time values in a trip always increase over the course of a trip, regardless of which timezones the trip crosses.
     */
    @Column(name = "timezone")
    @Temporal(TemporalType.TIME)
    var timezone: String = ""

    /**
     * Indicates whether wheelchair boardings are possible from the location. Valid options are:
     *
     * For parentless stops:
     * 0 or empty - No accessibility information for the stop.
     * 1 - Some vehicles at this stop can be boarded by a rider in a wheelchair.
     * 2 - Wheelchair boarding is not possible at this stop.
     *
     * For child stops:
     * 0 or empty - Stop will inherit its wheelchair_boarding behavior from the parent station, if specified in the parent.
     * 1 - There exists some accessible path from outside the station to the specific stop/platform.
     * 2 - There exists no accessible path from outside the station to the specific stop/platform.
     *
     * For station entrances/exits:
     * 0 or empty - Station entrance will inherit its wheelchair_boarding behavior from the parent station, if specified for the parent.
     * 1 - Station entrance is wheelchair accessible.
     * 2 - No accessible path from station entrance to stops/platforms.
     */
    @Column(name = "wheelchair_boarding")
    var wheelchairBoarding: String = ""

    override fun onPrePersist() {
        super.onPrePersist()
        if (this.locationType == LocationType.STOP_PLATFORM || this.locationType == LocationType.STATION || this.locationType == LocationType.ENTRANCE_EXIT){
            if (this.name == "" || this.name == null){
                throw IllegalStateException("Property 'name' is required for stops, stations, or entrances/exits.")
            }

            if (this.latitude == "" || this.latitude == null){
                throw IllegalStateException("Property 'latitude' is required for stops, stations, or entrances/exits.")
            }

            if (this.longitude == "" || this.longitude == null){
                throw IllegalStateException("Property 'longitude' is required for stops, stations, or entrances/exits.")
            }
        }

        if (this.locationType == LocationType.GENERIC_NODE || this.locationType == LocationType.BOARDING_AREA || this.locationType == LocationType.ENTRANCE_EXIT){
            if (this.parentStation == "" || this.parentStation == null){
                throw IllegalStateException("Property 'parentStation' is required for entrances/exits, generic node or boarding area.")
            }
        }

        if (this.locationType != LocationType.STATION){
            if (this.zoneId == "" || this.zoneId == null){
                throw IllegalStateException("Property 'zoneId' must not be null.")
            }
        }
    }
}
