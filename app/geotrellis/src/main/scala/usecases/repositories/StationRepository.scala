package usecases.repositories

import entities.Station
import geotrellis.vector.Geometry
import infrastructures.db.PostGIS
import scalikejdbc.WrappedResultSet
import skinny.orm.SkinnyMapper
import utils.GeometryFormatter
import scalikejdbc._
import utils.Enums.GeometryFileTypes.WKB

object StationRepository extends StationRepositoryInterface[Station, Geometry, Array[Byte]] with SkinnyMapper[Station] {
  override val connectionPoolName = PostGIS.DB_NAME
  override lazy val defaultAlias = createAlias("s")
  override val columnNames = Seq("id", "name", "company_name", "railway_name", "company_type", "start_year", "end_year", "lat", "lng", "geom")
  override val wkbFormatter = GeometryFormatter(WKB)

  override def tableName = "station"
  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[Station]): Station = Station(
    id = rs.int(n.id),
    name = rs.string(n.name),
    companyName = rs.string(n.companyName),
    railwayName = rs.string(n.railwayName),
    companyType = rs.int(n.companyType),
    startYear = rs.int(n.startYear),
    endYear = rs.int(n.endYear),
    lat = rs.float(n.lat),
    lng = rs.float(n.lng),
    geom = wkbFormatter.read(rs.bytes(n.geom))
  )

  def within(polygon: Geometry): List[Station] = findAll().filter(_.geom.withinDistance(polygon, 0))
}
