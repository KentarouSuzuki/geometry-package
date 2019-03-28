package entities

import geotrellis.vector.Point

case class Station(id: Int,
                   name: String,
                   companyName: String,
                   railwayName: String,
                   companyType: Int,
                   startYear: Int,
                   endYear: Int,
                   lat: Float,
                   lng: Float,
                   geom: Point)
  extends AbstractStation(id, name, companyName, railwayName, companyType, startYear, endYear, lat, lng, geom)
