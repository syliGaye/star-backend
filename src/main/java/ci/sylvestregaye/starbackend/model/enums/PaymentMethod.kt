package ci.sylvestregaye.starbackend.model.enums

enum class PaymentMethod {
    /**
     * Fare is paid on board.
     */
    PAID,

    /**
     * Fare must be paid before boarding.
     */
    MUST_BE_PAID
}