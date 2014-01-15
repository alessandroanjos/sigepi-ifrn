import sbt._
import Keys._
import PlayProject._
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

    val appName         = "SIGEPI"
    val appVersion      = "1.0.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "mysql" % "mysql-connector-java" % "5.1.18",
      "com.typesafe" %% "play-plugins-mailer" % "2.0.2",
	  "com.github.play2war.ext" %% "jboss7-reflections-vfs-integration-play2" % "1.0.0",
	  "com.github.play2war.ext" %% "redirect-playlogger" % "1.0.1"
	  
	  //
	  
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA)
    	.settings(Play2WarPlugin.play2WarSettings: _*)
    	.settings(
      // Add your own project settings here    
        Play2WarKeys.servletVersion := "3.0"
    )

}
