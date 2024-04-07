package ci.sylvestregaye.starbackend.model.common

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditableEntity<U> {
  @Column(name = "created_by")
  @CreatedBy
  protected var createdBy: U? = null

  @Column(name = "updated_by")
  @LastModifiedBy
  protected var updatedBy: U? = null

  @Column(name = "created_date", nullable = false, updatable = false)
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected var createdDate: Date? = null

  @Column(name = "updated_date")
  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected var updatedDate: Date? = null
}