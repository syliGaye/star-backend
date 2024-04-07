package ci.sylvestregaye.starbackend.dao.repositories

import ci.sylvestregaye.starbackend.model.entities.StopTimes
import ci.sylvestregaye.starbackend.model.entities.Trips
import org.springframework.data.jpa.repository.JpaRepository

interface StopTimesRepository: JpaRepository<StopTimes, Long> {
    fun findAllByTrips(trips: Trips): List<StopTimes>
}