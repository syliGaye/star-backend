package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Agency
import ci.sylvestregaye.starbackend.model.entities.Routes
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RoutesRepository: JpaRepository<Routes, Long> {
    fun findByRouteId(s: String): Optional<Routes>
    fun findAllByAgency(agency: Agency): List<Routes>
}