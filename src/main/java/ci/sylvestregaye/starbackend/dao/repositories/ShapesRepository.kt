package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Shapes
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ShapesRepository: JpaRepository<Shapes, Long> {
    fun findByShapeId(s: String): Optional<Shapes>
}