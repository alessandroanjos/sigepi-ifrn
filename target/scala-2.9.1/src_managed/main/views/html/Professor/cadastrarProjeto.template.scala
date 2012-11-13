
package views.html.Professor

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
object cadastrarProjeto extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("SIGEPI - Cadastrar Projetos")/*1.37*/{_display_(Seq[Any](format.raw/*1.38*/("""

<html>

<body>

<div class="topbar">
	        <div class="fill">
	              <div id="headerCSS">
	                    <a class="brand" href=""""),_display_(Seq[Any](/*10.46*/routes/*10.52*/.Professores.index())),format.raw/*10.72*/("""">Home</a>
	                    <ul class="">
	                        <li class="">
	                            <a href=""""),_display_(Seq[Any](/*13.40*/routes/*13.46*/.Professores.cadastrarProjeto())),format.raw/*13.77*/("""">Cadastrar Projeto</a>
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
	<center>
		 <div id="container" style="width:500px">
		<!--  <div id="header" style="background-color:#FFA500;"> -->
		 <!-- <h1 style="margin-bottom:0;">SIGEPI</h1></div> -->
		 <div id="content" style="background-color:#EEEEEE;height:200px;width:500px;float:left;">
Content goes here</div>

<div id="footer" style="background-color:#99FF99;clear:both;text-align:center;">
www.sigepi.edu.ifrn.br</div>
		  
	</center>
	
	 <a href=""""),_display_(Seq[Any](/*43.13*/routes/*43.19*/.Professores.index())),format.raw/*43.39*/("""" class="btn">Voltar</a>
</body> 
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
                    SOURCE: /Users/tarsolatorraca/Desktop/sigepi-ifrn/app/views/Professor/cadastrarProjeto.scala.html
                    HASH: 7817a7f6179906df4f047abaf8a6346267ab6544
                    MATRIX: 849->1|892->36|930->37|1123->194|1138->200|1180->220|1343->347|1358->353|1411->384|1521->649|1783->875|1798->881|1845->906|2473->1498|2488->1504|2530->1524
                    LINES: 30->1|30->1|30->1|39->10|39->10|39->10|42->13|42->13|42->13|44->19|49->24|49->24|49->24|68->43|68->43|68->43
                    -- GENERATED --
                */
            