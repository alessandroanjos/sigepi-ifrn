
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

Seq[Any](_display_(Seq[Any](/*2.2*/main("SIGEPI - Area do Administrador")/*2.40*/ {_display_(Seq[Any](format.raw/*2.42*/("""
<html>
<head>
<link rel= "stylesheet" type="text/css" href=".../css/bootstrap.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src=".../js/bootstrap.js"></script>

</head>
<body>

	<div class="topbar">
	        <div class="fill">
	              <div id="headerCSS">
	                    <a class="brand" href=""""),_display_(Seq[Any](/*15.46*/routes/*15.52*/.Administracao.index())),format.raw/*15.74*/("""">Home</a>
	                    <ul class="">
	                        <li class="">
	                            <a href=""""),_display_(Seq[Any](/*18.40*/routes/*18.46*/.Administracao.cadastrarEdital())),format.raw/*18.78*/("""">Cadastrar Edital</a>
	                        </li>
	                        """),format.raw/*24.28*/("""
	                    </ul> 
	                    <dl id="user" class="afastar">
	                       <dt>user.name <span>(user.email)</span></dt>
	                         <dd>
	                              <a href=""""),_display_(Seq[Any](/*29.42*/routes/*29.48*/.Sessions.efetuarlogout())),format.raw/*29.73*/("""">Sair</a>
	                        </dd>
	                   </dl>
	                   
	                </div>
	         </div>
	 </div>
        
xxxxxxxxxxxxxxxxxxxxxx

<!-- Button to trigger modal -->
<a href="#myModal" role="button" class="btn" data-toggle="modal">Cadastrar Novo Edital</a>
 
<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
    <h3 id="myModalLabel">Modal header</h3>
  </div>
  <div class="modal-body">
    <p>One fine body�</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
    <button class="btn btn-primary">Save changes</button>
  </div>
</div>

<br><br><br><br>
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
						<td><a href="" class="btn success">Editar</a> <a href="" class="btn danger">Excluir</a></td>						
					</tr>
					<tr>
						<td>0839432403</td>
						<td>27-01-00</td>
						<td><a href="" class="btn success">Editar</a> <a href="" class="btn danger">Excluir</a></td>					
					</tr>
					<tr>
						<td>0839432403</td>
						<td>27-01-00</td>
						<td><a href="" class="btn success">Editar</a> <a href="" class="btn danger">Excluir</a></td>						
					</tr>
					<tr>
						<td>0839432403</td>
						<td>27-01-00</td>
						<td><a href="" class="btn success">Editar</a> <a href="" class="btn danger">Excluir</a></td>				
					</tr>
					<tr>
						<td>0839432403</td>
						<td>27-01-00</td>
						<td><a href="" class="btn success">Editar</a> <a href="" class="btn danger">Excluir</a></td>						
					</tr>
					<tr>
						<td>0839432403</td>
						<td>27-01-00</td>
						<td><a href="" class="btn success">Editar</a> <a href="" class="btn danger">Excluir</a></td>				
					</tr>
					
				


			</tbody>
		</table>
		  
	</center>
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
                    DATE: Tue Nov 13 09:47:13 GMT-03:00 2012
                    SOURCE: C:/Users/Hellen Lemos/Desktop/sigepi-ifrn/app/views/Administrador/cadastrarEdital.scala.html
                    HASH: b17de5c30b8c2e47cab509d0e937cbd3b290ccfa
                    MATRIX: 852->3|898->41|937->43|1346->416|1361->422|1405->444|1568->571|1583->577|1637->609|1746->873|2009->1100|2024->1106|2071->1131
                    LINES: 30->2|30->2|30->2|43->15|43->15|43->15|46->18|46->18|46->18|48->24|53->29|53->29|53->29
                    -- GENERATED --
                */
            