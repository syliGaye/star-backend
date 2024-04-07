package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "shapes")
class Shapes: BaseEntity() {
    /**
     * Identifies a shape.
     */
    @Column(name = "shape_id", unique = true, nullable = false)
    var shapeId: String = ""

    /**
     * Latitude of a shape point.
     */
    @Column(name = "pt_latitude", nullable = false)
    var latitude: String = ""

    /**
     * Longitude of a shape point.
     */
    @Column(name = "pt_longitude", nullable = false)
    var longitude: String = ""

    /**
     * Sequence in which the shape points connect to form the shape.
     */
    @Column(name = "pt_sequence", nullable = false)
    var sequence: String = ""

    /**
     * Actual distance traveled along the shape from the first shape point to the point specified in this record.
     */
    @Column(name = "dist_traveled")
    var distTraveled: String = ""
}