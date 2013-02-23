import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "Sigepi"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      
      "mysql" % "mysql-connector-java" % "5.1.18",
      "com.typesafe" %% "play-plugins-mailer" % "2.0.2"
    
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
 