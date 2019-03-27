package usecases.repositories

import entities.AbstractStation
import utils.WKBFormatterInterface

trait StationRepositoryInterface[A <: AbstractStation, Geometry, B]{
  val wkbFormatter: WKBFormatterInterface[Geometry, B]
  def within(polygon: Geometry): List[A]
}