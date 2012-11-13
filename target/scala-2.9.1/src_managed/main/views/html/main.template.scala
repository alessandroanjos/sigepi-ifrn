
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
         <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.55*/routes/*8.61*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*8.100*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css"))),format.raw/*9.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png"))),format.raw/*10.97*/("""">
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
    </head>
    <body>
    
    
    <div class="container">

            <div class="content">
                
                <div class="page-header">
                    <h1>"""),_display_(Seq[Any](/*21.26*/title)),format.raw/*21.31*/("""</h1>
                </div>

                <div class="row">
                    <div class="span14">
                        """),_display_(Seq[Any](/*26.26*/content)),format.raw/*26.33*/("""
                    </div>
                </div>
                
            </div>
<hr />
            <footer>
                
        	
        		<br/>
	        	<p> SIGEPI - Sistema de Gestão de Pesquisa e Inovação - beta 1.0 <br /> 
	        	Instituto Federal de Educação, Ciência e Tecnologia do Rio Grande do Norte <br/></br>
	        	
	        	</p>
	     
            </footer>

        </div>
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html) = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 09:47:13 GMT-03:00 2012
                    SOURCE: C:/Users/Hellen Lemos/Desktop/sigepi-ifrn/app/views/main.scala.html
                    HASH: 14b68f725ba6745f7e71e1efe98f252ecc669bda
                    MATRIX: 759->1|866->31|954->84|980->89|1078->152|1092->158|1153->197|1244->253|1258->259|1313->293|1410->354|1425->360|1479->392|1540->417|1555->423|1622->468|1873->683|1900->688|2066->818|2095->825
                    LINES: 27->1|30->1|36->7|36->7|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|39->10|40->11|40->11|40->11|50->21|50->21|55->26|55->26
                    -- GENERATED --
                */
            