import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "SIGEPI - Sistema de Gestao de Pesquisa e Inovacao"
    val appVersion      = "1.0.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "mysql" % "mysql-connector-java" % "5.1.18",
      "com.typesafe" %% "play-plugins-mailer" % "2.0.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
