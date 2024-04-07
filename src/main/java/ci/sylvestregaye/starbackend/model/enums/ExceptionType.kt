package ci.sylvestregaye.starbackend.model.enums

enum class ExceptionType {
    /**
     * (non Java-doc)
     */
    NONE,

    /**
     * Service has been added for the specified date.
     */
    ADD,

    /**
     * Service has been removed for the specified date.
     */
    REMOVE
}