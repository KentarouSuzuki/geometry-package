package usecases.repositories

import entities.AbstractStation
import utils.WKBFormatterInterface

trait StationRepositoryInterface[A <: AbstractStation, Geometry]{
  val wkbFormatter: WKBFormatterInterface[Geometry]
  def within(polygon: Geometry): List[A]
}