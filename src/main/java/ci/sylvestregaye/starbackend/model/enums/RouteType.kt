package ci.sylvestregaye.starbackend.model.enums

enum class RouteType {
    /**
     * Any light rail or street level system within a metropolitan area.
     * (Tram, Streetcar, Light rail)
     */
    ANY,

    /**
     * Any underground rail system within a metropolitan area.
     */
    SUBWAY_METRO,

    /**
     * Used for intercity or long-distance travel.
     */
    RAIL,

    /**
     * Used for short- and long-distance bus routes.
     */
    BUS,

    /**
     * Used for short- and long-distance boat service.
     */
    FERRY,

    /**
     * Used for street-level rail cars where the cable runs beneath the vehicle (e.g., cable car in San Francisco).
     */
    CABLE_TRAM,

    /**
     * Cable transport where cabins, cars, gondolas or open chairs are suspended by means of one or more cables.
     */
    AERIAL_LIFT_SUSPENDED_CABLE_CAR,

    /**
     * Any rail system designed for steep inclines.
     */
    FUNICULAR,

    /**
     * Electric buses that draw power from overhead wires using poles.
     */
    TROLLEYBUS,

    /**
     * Railway in which the track consists of a single rail or a beam.
     */
    MONORAIL
}