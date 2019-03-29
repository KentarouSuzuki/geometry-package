package usecases.interactor

import org.openjdk.jmh.annotations._
import usecases.repositories._

@State(Scope.Thread)
class StationService {
  val city = CityRepository
  val station = StationRepository

  @Benchmark
  def stationInChiyoda() = city.findByCityCode(Seq("13101")).foreach{target =>
    StationRepository.within(target.geom).foreach{s =>
      println(s"${s.railwayName}${s.name}(${s.companyName})")
    }
  }

}
