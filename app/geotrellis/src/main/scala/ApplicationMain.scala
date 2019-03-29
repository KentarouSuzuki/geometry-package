import usecases.interactor.{PrefService, StationService}

object ApplicationMain extends App{
  new PrefService().uniteFromCity()
  new StationService().stationInChiyoda()
}
