package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Routes
import ci.sylvestregaye.starbackend.model.entities.Service
import ci.sylvestregaye.starbackend.model.entities.Shapes
import ci.sylvestregaye.starbackend.model.entities.Trips
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface TripsRepository: JpaRepository<Trips, Long> {
    fun findByTripId(s: String): Optional<Trips>
    fun findAllByShapes(shapes: Shapes): List<Trips>
    fun findAllByService(service: Service): List<Trips>
    fun findAllByRoutes(routes: Routes): List<Trips>
}