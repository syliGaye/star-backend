package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import java.util.*

@Entity
@Table(name="agency")
class Agency: BaseEntity() {
    /**
     * Identifies a transit brand which is often synonymous with a transit agency. Note that in some cases, such as when a single agency operates multiple separate services, agencies and brands are distinct. This document uses the term "agency" in place of "brand". A dataset may contain data from multiple agencies.
     */
    @Column(name = "agency_id", unique = true, nullable = false)
    var agencyId: String = ""

    /**
     * Full name of the transit agency.
     */
    @Column(name = "name", nullable = false)
    var name: String = ""

    /**
     * URL of the transit agency.
     */
    @Column(name = "url", nullable = false)
    var url: String = ""

    /**
     * Timezone where the transit agency is located. If multiple agencies are specified in the dataset, each must have the same agency_timezone.
     */
    @Column(name = "timezone", nullable = false)
    @Temporal(TemporalType.TIME)
    var timezone: Date? = null

    /**
     * Primary language used by this transit agency.
     * Should be provided to help GTFS consumers choose capitalization rules and other language-specific settings for the dataset.
     */
    @Column(name = "lang")
    var lang: String = ""

    /**
     * A voice telephone number for the specified agency. This field is a string value that presents the telephone number as typical for the agency's service area. It may contain punctuation marks to group the digits of the number. Dialable text (for example, TriMet's "503-238-RIDE") is permitted, but the field must not contain any other descriptive text.
     */
    @Column(name = "phone")
    var phone: String = ""

    /**
     * URL of a web page that allows a rider to purchase tickets or other fare instruments for that agency online.
     */
    @Column(name = "fare_url")
    var fareUrl: String = ""

    /**
     * Email address actively monitored by the agency’s customer service department. This email address should be a direct contact point where transit riders can reach a customer service representative at the agency.
     */
    @Column(name = "email")
    var email: String = ""
}