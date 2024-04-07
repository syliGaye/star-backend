package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import ci.sylvestregaye.starbackend.model.enums.RouteType
import jakarta.persistence.*

@Entity
@Table(name="route")
class Routes: BaseEntity() {
    /**
     * Identifies a route.
     */
    @Column(name = "route_id", unique = true, nullable = false)
    var routeId: String = ""

    /**
     * Agency for the specified route.
     */
    @ManyToOne
    @JoinColumn(name = "agency_id", nullable = false, foreignKey = ForeignKey(name = "fk_route_agency"))
    var agency: Agency? = null

    /**
     * Short name of a route.
     */
    @Column(name = "short_name", length = 12)
    var shortName: String = ""

    /**
     * Full name of a route.
     */
    @Column(name = "long_name")
    var longName: String = ""

    /**
     * Description of a route that provides useful, quality information.
     */
    @Column(name = "description")
    var description: String = ""

    /**
     * Indicates the type of transportation used on a route.
     */
    @Column(name = "type", nullable = false)
    var type: RouteType = RouteType.ANY

    /**
     * URL of a web page about the particular route.
     */
    @Column(name = "url")
    var url: String = ""

    /**
     * Route color designation that matches public facing material.
     */
    @Column(name = "color")
    var color: String = "FFFFFF"

    /**
     * Legible color to use for text drawn against a background of color.
     */
    @Column(name = "text_color")
    var textColor: String = "000000"

    /**
     * Orders the routes in a way which is ideal for presentation to customers.
     */
    @Column(name = "sort_order")
    var sortOrder: String = ""

    override fun onPrePersist() {
        super.onPrePersist()

        if (this.longName == "" || this.longName == null){
            if (this.shortName == "" || this.shortName == null){
                throw IllegalStateException("Property 'shortName' must not be null.");
            }
        }
        if (this.shortName == "" || this.shortName == null){
            if (this.longName == "" || this.longName == null){
                throw IllegalStateException("Property 'longName' must not be null.");
            }
        }
    }
}
