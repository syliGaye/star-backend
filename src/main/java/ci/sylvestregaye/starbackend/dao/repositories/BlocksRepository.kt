package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Blocks
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface BlocksRepository: JpaRepository<Blocks, Long> {
    fun findByBlockId(s: String): Optional<Blocks>
}