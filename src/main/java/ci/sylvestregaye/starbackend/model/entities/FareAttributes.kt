package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import ci.sylvestregaye.starbackend.model.enums.PaymentMethod
import ci.sylvestregaye.starbackend.model.objects.CurrencyType
import jakarta.persistence.*

@Entity
@Table(name="fare_attributes")
class FareAttributes: BaseEntity() {
    /**
     * Identifies a fare class.
     */
    @Column(name="fare_id", unique = true, nullable = false)
    var FareId: String = ""

    /**
     * Fare price, in the unit specified by currency_type.
     */
    @Column(name="price", nullable = false)
    var price: Double = 0.0

    /**
     * Currency used to pay the fare.
     */
    @Column(name="currency_type", nullable = false)
    var currencyType: String = CurrencyType.EURO

    /**
     * Indicates when the fare must be paid.
     */
    @Column(name="payment_method")
    var paymentMethod: PaymentMethod = PaymentMethod.PAID

    /**
     * Indicates the number of transfers permitted on this fare. Valid options are:
     *
     * 0 - No transfers permitted on this fare.
     * 1 - Riders may transfer once.
     * 2 - Riders may transfer twice.
     * empty - Unlimited transfers are permitted.
     */
    @Column(name="transfers")
    var transfers: String = ""

    /**
     * Length of time in seconds before a transfer expires.
     * When transfers=0 this field may be used to indicate how long a ticket is valid for or it may be left empty.
     */
    @Column(name="transfer_duration")
    var transferDuration: String = ""

    /**
     * Identifies the relevant agency for a fare.
     */
    @ManyToOne
    @JoinColumn(name = "agency_id", nullable = false, foreignKey = ForeignKey(name = "fk_fare_attributes_agency"))
    var agency: Agency? = null
}