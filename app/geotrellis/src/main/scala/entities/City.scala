package entities

import geotrellis.vector.{Geometry, MultiPolygon}

case class City(id: Int,
                name: String,
                cityCode: String,
                prefecture: String,
                population: Int,
                geom: MultiPolygon)
  extends AbstractCity(id, name, cityCode, prefecture, population, geom)
