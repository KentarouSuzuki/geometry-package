import usecases.interactor.{PrefService, StationService}

object ApplicationMain extends App{
//  PrefService.uniteFromCity()
  Seq("13101", "13113").foreach(StationService.stationIn)
}
