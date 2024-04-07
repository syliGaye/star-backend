package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.Calendar
import ci.sylvestregaye.starbackend.model.entities.Service
import org.springframework.data.jpa.repository.JpaRepository

interface CalendarRepository: JpaRepository<Calendar, Long> {
    fun findAllByService(service: Service): List<Calendar>
}