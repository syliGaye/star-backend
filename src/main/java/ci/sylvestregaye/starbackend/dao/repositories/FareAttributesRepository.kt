package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Agency
import ci.sylvestregaye.starbackend.model.entities.FareAttributes
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface FareAttributesRepository: JpaRepository<FareAttributes, Long> {
    fun findByFareId(s: String): Optional<FareAttributes>
    fun findAllByAgency(agency: Agency): List<FareAttributes>
}