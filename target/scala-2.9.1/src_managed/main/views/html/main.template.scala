
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
         
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("stylesheets/main.css"))),format.raw/*10.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.59*/routes/*11.65*/.Assets.at("images/favicon.png"))),format.raw/*11.97*/("""">
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*12.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/bootstrap.js"))),format.raw/*13.67*/("""" type="text/javascript"></script>
        """),format.raw/*14.137*/("""
    </head>
    <body>
    
    
    <div class="container">

            <div class="content">
                
                <div class="page-header">
                    <h1>"""),_display_(Seq[Any](/*24.26*/title)),format.raw/*24.31*/("""</h1>
                </div>

                <div class="row">
                    <div class="span14">
                        """),_display_(Seq[Any](/*29.26*/content)),format.raw/*29.33*/("""
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
                    DATE: Tue Nov 13 17:35:31 BRST 2012
                    SOURCE: C:/Users/Denilde/workspace/sigepi-ifrn/app/views/main.scala.html
                    HASH: bf81a7e02beeec7090c050ce6c7707ce77593e51
                    MATRIX: 759->1|866->31|954->84|980->89|1078->152|1092->158|1153->197|1255->263|1270->269|1326->303|1423->364|1438->370|1492->402|1553->427|1568->433|1635->478|1728->535|1743->541|1803->579|1875->750|2092->931|2119->936|2285->1066|2314->1073
                    LINES: 27->1|30->1|36->7|36->7|37->8|37->8|37->8|39->10|39->10|39->10|40->11|40->11|40->11|41->12|41->12|41->12|42->13|42->13|42->13|43->14|53->24|53->24|58->29|58->29
                    -- GENERATED --
                */
            