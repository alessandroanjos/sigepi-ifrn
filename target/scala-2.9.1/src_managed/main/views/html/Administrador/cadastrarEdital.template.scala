
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
object cadastrarEdital extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.3*/main("SIGEPI - Area do Administrador")/*1.41*/ {_display_(Seq[Any](format.raw/*1.43*/("""
<html>
<head>
<link rel="stylesheet" type="text/css" href=".../css/bootstrap.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src=".../js/bootstrap.js"></script>

</head>
<body>

	<div class="topbar">
		<div class="fill">
			<div id="headerCSS">
				<a class="brand" href=""""),_display_(Seq[Any](/*14.29*/routes/*14.35*/.Administracao.index())),format.raw/*14.57*/("""">Home</a>
				<ul class="">
					<li class=""><a href=""""),_display_(Seq[Any](/*16.29*/routes/*16.35*/.Administracao.cadastrarEdital())),format.raw/*16.67*/("""">Cadastrar
							Edital</a></li> """),format.raw/*19.14*/("""
				</ul>
				<dl id="user" class="afastar">
					<dt>
						user.name <span>(user.email)</span>
					</dt>
					<dd>
						<a href=""""),_display_(Seq[Any](/*26.17*/routes/*26.23*/.Sessions.efetuarlogout())),format.raw/*26.48*/("""">Sair</a>
					</dd>
				</dl>

			</div>
		</div>
	</div>

	xxxxxxxxxxxxxxxxxxxxxx

	<!-- Button to trigger modal -->
	<a href="#myModal" role="button" class="btn" data-toggle="modal">Cadastrar
		Novo Edital</a>

	<!-- Modal -->
	<div id="myModal" class="modal shown fade" tabindex="-1" style="width:700px" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">X</button>
			<h3 id="myModalLabel">Cadastrar Novo Edital</h3>
		</div>
		<div class="modal-body" >
		
		Nome do Edital: <input type="text"><br> 
		Anexo: <input type="file"><br>
		Per�odo de <input type="date"> a <input type="date"><br><br>
		Descri��o: <textarea rows="3"></textarea><br>
		 
		
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
			<button class="btn primary">Enviar</button>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<center>
		<table border="1">

			<thead>
				<tr>
					<th>Editais</th>
					<th>Data enviada</th>
					<th>Situa��o</th>



				</tr>
			</thead>
			<tbody>

				<tr>
					<td>0839432403</td>
					<td>27-01-00</td>
					<td><a href="" class="btn success">Editar</a> <a href=""
						class="btn danger">Excluir</a></td>
				</tr>
				<tr>
					<td>0839432403</td>
					<td>27-01-00</td>
					<td><a href="" class="btn success">Editar</a> <a href=""
						class="btn danger">Excluir</a></td>
				</tr>
				<tr>
					<td>0839432403</td>
					<td>27-01-00</td>
					<td><a href="" class="btn success">Editar</a> <a href=""
						class="btn danger">Excluir</a></td>
				</tr>
				<tr>
					<td>0839432403</td>
					<td>27-01-00</td>
					<td><a href="" class="btn success">Editar</a> <a href=""
						class="btn danger">Excluir</a></td>
				</tr>
				<tr>
					<td>0839432403</td>
					<td>27-01-00</td>
					<td><a href="" class="btn success">Editar</a> <a href=""
						class="btn danger">Excluir</a></td>
				</tr>
				<tr>
					<td>0839432403</td>
					<td>27-01-00</td>
					<td><a href="" class="btn success">Editar</a> <a href=""
						class="btn danger">Excluir</a></td>
				</tr>




			</tbody>
		</table>

	</center>
</body>

</html>

""")))})),format.raw/*130.2*/("""
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 18:27:57 BRST 2012
                    SOURCE: C:/Users/Denilde/workspace/sigepi-ifrn/app/views/Administrador/cadastrarEdital.scala.html
                    HASH: cc73345ffc95c189f6b2d3dcdcf7a2855c4fca27
                    MATRIX: 852->2|898->40|937->42|1309->378|1324->384|1368->406|1463->465|1478->471|1532->503|1596->625|1774->767|1789->773|1836->798|4210->3140
                    LINES: 30->1|30->1|30->1|43->14|43->14|43->14|45->16|45->16|45->16|46->19|53->26|53->26|53->26|157->130
                    -- GENERATED --
                */
            