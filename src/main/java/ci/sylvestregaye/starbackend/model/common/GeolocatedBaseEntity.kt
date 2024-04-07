package ci.sylvestregaye.starbackend.model.common

import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class GeolocatedBaseEntity: BaseEntity() {
    open var longitude: Double = 0.toDouble()
    open var latitude: Double = 0.toDouble()
}