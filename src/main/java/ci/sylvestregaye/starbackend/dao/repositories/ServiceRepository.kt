package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Service
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ServiceRepository: JpaRepository<Service, Long> {
    fun findByCode(s: String): Optional<Service>
}