package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Agency
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface AgencyRepository: JpaRepository<Agency, Long> {
    fun findByAgencyId(s: String): Optional<Agency>
}