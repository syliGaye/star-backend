package ci.sylvestregaye.starbackend.model.enums

enum class ServiceType {
    /**
     * Service is not available for all the days in the date range.
     */
    NOT_AVAILABLE,

    /**
     * Service is available for all the days in the date range.
     */
    AVAILABLE
}