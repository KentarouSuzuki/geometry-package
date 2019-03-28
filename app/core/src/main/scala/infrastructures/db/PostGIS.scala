package infrastructures.db

import com.zaxxer.hikari.HikariDataSource
import scalikejdbc._

object PostGIS {
  var isInitialized = false

  val driver = "org.postgresql.Driver"
  val host = "localhost"
  val port = 5432
  val dbname = "gis"
  val user = "postgres"
  val password = "postgres"

  println("add connection")
  ConnectionPool.singleton(s"jdbc:postgresql://$host:$port/$dbname", user, password)

  val DB_NAME: Symbol = {
    if (!isInitialized) { initialize() }
    'postGIS
  }

  def apply(implicit context: ConnectionPoolContext = NoConnectionPoolContext): NamedDB = NamedDB(DB_NAME)(context)

  def unapply(arg: String): Option[NamedDB] = Option(arg).collect {
    case "postGIS" => PostGIS()
  }

  def initialize(): Unit = {
    val dataSource = new HikariDataSource()
    dataSource.setDriverClassName(driver)
    dataSource.setJdbcUrl(s"jdbc:postgresql://$host:$port/$dbname")
    dataSource.setUsername(user)
    dataSource.setPassword(password)
    ConnectionPool.add('postGIS, new DataSourceConnectionPool(dataSource))
    isInitialized = true
  }
}
