package entities

import org.gdal.ogr.Geometry

case class Station(id: Int,
                   name: String,
                   companyName: String,
                   railwayName: String,
                   companyType: Int,
                   startYear: Int,
                   endYear: Int,
                   lat: Float,
                   lng: Float,
                   geom: Geometry)
  extends AbstractStation(id, name, companyName, railwayName, companyType, startYear, endYear, lat, lng, geom)

