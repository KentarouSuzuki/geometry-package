package usecases.repositories

import entities.AbstractCity
import utils.WKBFormatterInterface

trait CityRepositoryInterface[A <: AbstractCity, Geometry] {
  val wkbFormatter: WKBFormatterInterface[Geometry]

  def findByCityCode(code: Seq[String]): Seq[A]
  def partitionByPrefecture: Map[String, Seq[A]]

  def partitionByGeometryType: Map[String, Seq[A]]
}