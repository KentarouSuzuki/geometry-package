package usecases.interactor

import usecases.repositories.{CityRepository, StationRepository}

object StationService {
  val city = CityRepository
  val station = StationService

  def stationIn(cityCode: String) = city.findByCityCode(cityCode::Nil).foreach{target =>
    StationRepository.within(target.geom).foreach{s =>
      println(s"${s.railwayName}${s.name}(${s.companyName})")
    }
  }

}
