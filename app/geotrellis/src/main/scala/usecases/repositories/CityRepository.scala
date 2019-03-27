package usecases.repositories

import entities.City
import infrastructures.db.PostGIS
import geotrellis.vector.Geometry
import scalikejdbc._
import skinny.orm.SkinnyMapper
import utils.Enums.GeometryFileTypes.WKB
import utils.GeometryFormatter

object CityRepository extends CityRepositoryInterface[City, Geometry, Array[Byte]] with SkinnyMapper[City]{
  override val connectionPoolName = PostGIS.DB_NAME
  override lazy val defaultAlias = createAlias("c")
  override val columnNames = Seq("id", "name", "city_code", "prefecture", "population", "geom")
  override val wkbFormatter = GeometryFormatter(WKB)

  override def tableName = "city"
  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[City]): City = {
    City(
      id = rs.int(n.id),
      name = rs.string(n.name),
      cityCode = rs.string(n.cityCode),
      prefecture = rs.string(n.prefecture),
      population = rs.int(n.population),
      geom = wkbFormatter.read(rs.bytes(n.geom))
    )}

  override def findByCityCode(code: Seq[String]): Seq[City] =
    findAllBy(where = sqls"city_code in ($code)", orderings = defaultOrdering::Nil)

  override def partitionByPrefecture: Map[String, Seq[City]] = findAllBy(sqls"city_code is not null").groupBy[String](_.prefecture)
}

