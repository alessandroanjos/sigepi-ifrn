
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
object avaliarProjeto extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*3.2*/main("SIGEPI - Projetos para avaliar")/*3.40*/ {_display_(Seq[Any](format.raw/*3.42*/("""
<h1>Lista de Projetos a serem avaliados</h1>

<html>

<body>

<div class="topbar">
	        <div class="fill">
	              <div id="headerCSS">
	                    <a class="brand" href=""""),_display_(Seq[Any](/*13.46*/routes/*13.52*/.Avaliadores.index())),format.raw/*13.72*/("""">Home</a>
	                    <ul class="">
	                        <li class="">
	                            <a href=""""),_display_(Seq[Any](/*16.40*/routes/*16.46*/.Avaliadores.avaliarProjeto())),format.raw/*16.75*/("""">Avaliar Projetos</a>
	                        </li>
	                        """),format.raw/*22.28*/("""
	                    </ul>
	                    <dl id="user" class="afastar">
	                       <dt>user.name <span>(user.email)</span></dt>
	                         <dd>
	                              <a href=""""),_display_(Seq[Any](/*27.42*/routes/*27.48*/.Sessions.efetuarlogout())),format.raw/*27.73*/("""">Sair</a>
	                        </dd>
	                   </dl>
	                   
	                </div>
	         </div>
	 </div>
	<center>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome do Projeto</th>
					<th>Data enviada</th>
					

				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td>0839432403</td>
						<td><a href=""""),_display_(Seq[Any](/*49.21*/routes/*49.27*/.Avaliadores.acessarDadosProjeto())),format.raw/*49.61*/("""">Projeto de Pesquisa 01</a></td>
						<td>27-01-00</td>						
					</tr>
					<tr>
						<td>0839432403</td>
						<td>Projeto de Pesquisa 02</td>
						<td>27-01-00</td>						
					</tr>
					<tr>
						<td>0839432403</td>
						<td>Projeto de Pesquisa 03</td>
						<td>27-01-00</td>						
					</tr>
					<tr>
						<td>0839432403</td>
						<td>Projeto de Pesquisa 04</td>
						<td>27-01-00</td>						
					</tr>
					<tr>
						<td>0839432403</td>
						<td>Projeto de Pesquisa 05</td>
						<td>27-01-00</td>						
					</tr>
					<tr>
						<td>0839432403</td>
						<td>Projeto de Pesquisa 06</td>
						<td>27-01-00</td>						
					</tr>
					
				


			</tbody>
		</table>
		  
	</center>
	
	 <a href=""""),_display_(Seq[Any](/*86.13*/routes/*86.19*/.Avaliadores.index())),format.raw/*86.39*/("""" class="btn">Voltar</a>
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
                    DATE: Tue Nov 13 12:59:01 BRST 2012
                    SOURCE: C:/Users/Denilde/workspace/sigepi-ifrn/app/views/Avaliador/avaliarProjeto.scala.html
                    HASH: 49b6950da54f0b75b26f81f4a55f5dc532fff303
                    MATRIX: 847->5|893->43|932->45|1171->248|1186->254|1228->274|1391->401|1406->407|1457->436|1566->700|1828->926|1843->932|1890->957|2313->1344|2328->1350|2384->1384|3173->2137|3188->2143|3230->2163
                    LINES: 30->3|30->3|30->3|40->13|40->13|40->13|43->16|43->16|43->16|45->22|50->27|50->27|50->27|72->49|72->49|72->49|109->86|109->86|109->86
                    -- GENERATED --
                */
            