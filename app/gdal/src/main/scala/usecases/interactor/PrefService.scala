package usecases.interactor

import usecases.repositories.CityRepository

import scala.util.Try

object PrefService {
  val repository = CityRepository
  def uniteFromCity(): Unit = repository.partitionByPrefecture.foreach{case (k, v) =>
      if (v.length == 1){v.head.geom}
      else {
        v.foldLeft(v.head.geom){(a, b) => Try(a.Union(b.geom)).getOrElse{
          println(s"unite ${b.prefecture}${b.name}(${b.cityCode}) is failed")
          a
        }}
      }
      println(s"Unite $k is completed!!")
  }
}
