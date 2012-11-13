
package views.html.Administrador

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*2.2*/main("SIGEPI - Area do Administrador")/*2.40*/ {_display_(Seq[Any](format.raw/*2.42*/("""
<html>

<body>

	<div class="topbar">
	        <div class="fill">
	              <div id="headerCSS">
	                    <a class="brand" href=""""),_display_(Seq[Any](/*10.46*/routes/*10.52*/.Administracao.index())),format.raw/*10.74*/("""">Home</a>
	                    <ul class="">
	                        <li class="">
	                            <a href=""""),_display_(Seq[Any](/*13.40*/routes/*13.46*/.Administracao.cadastrarEdital())),format.raw/*13.78*/("""">Cadastrar Edital</a>
	                        </li>
	                        """),format.raw/*19.28*/("""
	                    </ul>
	                    <dl id="user" class="afastar">
	                       <dt>user.name <span>(user.email)</span></dt>
	                         <dd>
	                              <a href=""""),_display_(Seq[Any](/*24.42*/routes/*24.48*/.Sessions.efetuarlogout())),format.raw/*24.73*/("""">Sair</a>
	                        </dd>
	                   </dl>
	                   
	                </div>
	         </div>
	 </div>
        
<h1>O que deseja fazer? </h1> 
</body> 

<a href=""""),_display_(Seq[Any](/*35.11*/routes/*35.17*/.Administracao.cadastrarEdital())),format.raw/*35.49*/("""" class="btn">Cadastrar Edital</a>
</html>  

""")))})))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 11:25:00 BRT 2012
                    SOURCE: /Users/tarsolatorraca/Desktop/sigepi-ifrn/app/views/Administrador/index.scala.html
                    HASH: f34ea306254e6aee1e50ebaa58e442c0634e307a
                    MATRIX: 842->3|888->41|927->43|1119->199|1134->205|1178->227|1341->354|1356->360|1410->392|1519->656|1781->882|1796->888|1843->913|2089->1123|2104->1129|2158->1161
                    LINES: 30->2|30->2|30->2|38->10|38->10|38->10|41->13|41->13|41->13|43->19|48->24|48->24|48->24|59->35|59->35|59->35
                    -- GENERATED --
                */
            