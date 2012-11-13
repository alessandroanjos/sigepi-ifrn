
package views.html.Avaliador

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

Seq[Any](_display_(Seq[Any](/*2.2*/main("SIGEPI - Area do Avaliador")/*2.36*/ {_display_(Seq[Any](format.raw/*2.38*/("""
<html>

<body>

	<div class="topbar">
	        <div class="fill">
	              <div id="headerCSS">
	                    <a class="brand" href=""""),_display_(Seq[Any](/*10.46*/routes/*10.52*/.Avaliadores.index())),format.raw/*10.72*/("""">Home</a>
	                    <ul class="">
	                        <li class="">
	                            <a href=""""),_display_(Seq[Any](/*13.40*/routes/*13.46*/.Avaliadores.avaliarProjeto())),format.raw/*13.75*/("""">Avaliar Projetos</a>
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

<a href=""""),_display_(Seq[Any](/*35.11*/routes/*35.17*/.Avaliadores.avaliarProjeto())),format.raw/*35.46*/("""" class="btn">Avaliar Projetos</a>
</html>  

""")))})))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 12:59:01 BRST 2012
                    SOURCE: C:/Users/Denilde/workspace/sigepi-ifrn/app/views/Avaliador/index.scala.html
                    HASH: 74842bc7618fdf3646dc6540f123969224628657
                    MATRIX: 838->3|880->37|919->39|1111->195|1126->201|1168->221|1331->348|1346->354|1397->383|1506->647|1768->873|1783->879|1830->904|2076->1114|2091->1120|2142->1149
                    LINES: 30->2|30->2|30->2|38->10|38->10|38->10|41->13|41->13|41->13|43->19|48->24|48->24|48->24|59->35|59->35|59->35
                    -- GENERATED --
                */
            