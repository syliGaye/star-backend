package ci.sylvestregaye.starbackend.model.entities

import ci.sylvestregaye.starbackend.model.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name="service")
class Service: BaseEntity() {
    /**
     *
     */
    @Column(name="code", unique = true, nullable = false)
    var code: String = ""

    /**
     *
     */
    @Column(name="description")
    var description: String = ""
}