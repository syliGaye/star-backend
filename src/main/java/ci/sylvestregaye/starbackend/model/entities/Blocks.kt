package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "block")
class Blocks: BaseEntity() {
    @Column(name = "block_id", unique = true, nullable = false)
    var blockId: String = ""

    @Column(name = "description")
    var description: String = ""
}