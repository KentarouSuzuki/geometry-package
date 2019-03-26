package entities

import org.locationtech.jts.geom.Geometry

case class City(id: Int,
                name: String,
                cityCode: String,
                prefecture: String,
                population: Int,
                geom: Geometry)
    extends AbstractCity(id, name, cityCode, prefecture, population, geom)
