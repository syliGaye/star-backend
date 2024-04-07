package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.embeddable.CalendarDatesPK
import ci.sylvestregaye.starbackend.model.entities.CalendarDates
import ci.sylvestregaye.starbackend.model.entities.Service
import org.springframework.data.jpa.repository.JpaRepository

interface CalendarDatesRepository: JpaRepository<CalendarDates, CalendarDatesPK> {
    fun findAllByService(service: Service): List<CalendarDates>
}