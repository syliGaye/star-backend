package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Stops
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface StopsRepository: JpaRepository<Stops, Long> {
    fun findByStopId(s: String): Optional<Stops>
}