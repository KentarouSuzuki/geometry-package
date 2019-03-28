lazy val scala = "2.12.8"

lazy val commonSettings = Seq(
  version := "v0.0.1",
  scalaVersion := "2.12.8",
  mainClass := Some("ApplicationMain")
)

lazy val commonLibrary = Seq(
  "org.scalikejdbc" %% "scalikejdbc" % "3.3.2",
  "org.skinny-framework" %% "skinny-orm" % "3.0.0",
  "com.zaxxer" % "HikariCP" % "2.7.8",
  "com.h2database" % "h2" % "1.4.197",
  "postgresql" % "postgresql" % "9.4.1208-jdbc42-atlassian-hosted",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "io.spray" %%  "spray-json" % "1.3.5"
)

lazy val root = (project in file("."))
  .enablePlugins(JmhPlugin)
  .settings(
    commonSettings,
    name := "geopackage",
    libraryDependencies ++= commonLibrary
  )
  .aggregate(
    core,
    jst,
    gdal,
    geotrellis
  )

lazy val core = (project in file("core"))
  .enablePlugins(JmhPlugin)
  .settings(
    commonSettings,
    name := "core",
    libraryDependencies ++= commonLibrary
  )

lazy val jst = (project in file("jst"))
  .enablePlugins(JmhPlugin)
  .settings(
    commonSettings,
    name := "jst",
    libraryDependencies ++= (commonLibrary ++
      Seq("org.locationtech.jts" % "jts-core" % "1.16.1"))
  )
  .dependsOn(core)

lazy val gdal = (project in file("gdal"))
  .enablePlugins(JmhPlugin)
  .settings(
    commonSettings,
    name := "gdal",
    libraryDependencies ++= (commonLibrary ++
      Seq("org.gdal" % "gdal" % "2.4.0"))
  )
  .dependsOn(core)

lazy val geotrellis = (project in file("geotrellis"))
  .enablePlugins(JmhPlugin)
  .settings(
    commonSettings,
    name := "geotrellis",
    libraryDependencies ++= (commonLibrary ++
      Seq("org.locationtech.geotrellis" %% "geotrellis-vector" % "2.2.0",
        "org.locationtech.jts" % "jts-core" % "1.16.1"))
  )
  .dependsOn(core)