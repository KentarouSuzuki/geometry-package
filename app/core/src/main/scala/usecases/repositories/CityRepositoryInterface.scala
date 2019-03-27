package usecases.repositories

import entities.AbstractCity
import utils.WKBFormatterInterface

trait CityRepositoryInterface[A <: AbstractCity, Geometry, B] {
  val wkbFormatter: WKBFormatterInterface[Geometry, B]

  def findByCityCode(code: Seq[String]): Seq[A]
  def partitionByPrefecture: Map[String, Seq[A]]
}