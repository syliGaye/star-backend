package ci.sylvestregaye.starbackend.model.enums

enum class LocationType {
    /**
     * A location where passengers board or disembark from a transit vehicle. Is called a platform when defined within a parent_station.
     */
    STOP_PLATFORM,

    /**
     * A physical structure or area that contains one or more platform.
     */
    STATION,

    /**
     * A location where passengers can enter or exit a station from the street. If an entrance/exit belongs to multiple stations, it may be linked by pathways to both, but the data provider must pick one of them as parent.
     */
    ENTRANCE_EXIT,

    /**
     * A location within a station, not matching any other location_type, that may be used to link together pathways define in pathways.txt.
     */
    GENERIC_NODE,

    /**
     * A specific location on a platform, where passengers can board and/or alight vehicles.
     */
    BOARDING_AREA
}