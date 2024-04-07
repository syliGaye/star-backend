package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import ci.sylvestregaye.starbackend.utils.Utility
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="feed_info")
class FeedInfo: BaseEntity() {
    /**
     * Full name of the organization that publishes the dataset.
     */
    @Column(name="publisher_name", nullable = false)
    var publisherName: String = ""

    /**
     * URL of the dataset publishing organization's website.
     */
    @Column(name="publisher_url", nullable = false)
    var publisherUrl: String = ""

    /**
     * Default language used for the text in this dataset.
     */
    @Column(name="lang", nullable = false)
    var lang: String = ""

    /**
     * Beginning date.
     */
    @Column(name="start_date")
    @Temporal(TemporalType.DATE)
    var startDate: Date? = null

    /**
     * Ending date
     */
    @Column(name="end_date")
    @Temporal(TemporalType.DATE)
    var endDate: Date? = null

    /**
     * String that indicates the current version of their GTFS dataset.
     */
    @Column(name="version")
    var version: String = ""

    override fun onPrePersist() {
        super.onPrePersist()
        Utility.controleDates(this.startDate, this.endDate)
    }
}