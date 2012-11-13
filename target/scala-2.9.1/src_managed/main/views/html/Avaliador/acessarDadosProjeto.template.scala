
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
object acessarDadosProjeto extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*3.2*/main("SIGEPI dados do projeto")/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""

<html>
<body>

<div class="topbar">
	        <div class="fill">
	              <div id="headerCSS">
	                    <a class="brand" href=""""),_display_(Seq[Any](/*11.46*/routes/*11.52*/.Avaliadores.index())),format.raw/*11.72*/("""">Home</a>
	                    <ul class="">
	                        <li class="">
	                            <a href=""""),_display_(Seq[Any](/*14.40*/routes/*14.46*/.Avaliadores.avaliarProjeto())),format.raw/*14.75*/("""">Avaliar Projetos</a>
	                        </li>
	                        """),format.raw/*20.28*/("""
	                    </ul>
	                    <dl id="user" class="afastar">
	                       <dt>user.name <span>(user.email)</span></dt>
	                         <dd>
	                              <a href=""""),_display_(Seq[Any](/*25.42*/routes/*25.48*/.Sessions.efetuarlogout())),format.raw/*25.73*/("""">Logout</a>
	                        </dd>
	                   </dl>
	                   
	                </div>
	         </div> 
	 </div>
	 
</body>

<h1>Dados do Projeto:</h1>

<br/><br/>
 
 <p>
	<strong>Nome do Projeto:</strong> Projeto Nome 
</p>


 <p>
	<strong>Data do cadastro:</strong> 01-11-2032 
 </p>

<br/><br/>

<hr>

<br/><br/>

<p>
	<strong>Download do Projeto:</strong> <a href=""> Projeto nome  </a>
</p>

<br/><br/>

<hr>

<br/><br/>

<p>
	<strong>Formul�rio de Avalia��o</strong> <a href=""""),_display_(Seq[Any](/*65.53*/routes/*65.59*/.Avaliadores.acessarFormulario())),format.raw/*65.91*/("""" class="btn"> Abrir Formul�rio </a>
</p>


<br><br><br><br>
 <a href=""""),_display_(Seq[Any](/*70.12*/routes/*70.18*/.Avaliadores.avaliarProjeto())),format.raw/*70.47*/("""" class="btn">Voltar</a>
</html>

""")))})),format.raw/*73.2*/("""
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 09:47:13 GMT-03:00 2012
                    SOURCE: C:/Users/Hellen Lemos/Desktop/sigepi-ifrn/app/views/Avaliador/acessarDadosProjeto.scala.html
                    HASH: 4a92723125c97ecdbb52c702170525d2a8b26696
                    MATRIX: 852->5|891->36|930->38|1121->193|1136->199|1178->219|1341->346|1356->352|1407->381|1516->645|1778->871|1793->877|1840->902|2428->1454|2443->1460|2497->1492|2610->1569|2625->1575|2676->1604|2745->1642
                    LINES: 30->3|30->3|30->3|38->11|38->11|38->11|41->14|41->14|41->14|43->20|48->25|48->25|48->25|88->65|88->65|88->65|93->70|93->70|93->70|96->73
                    -- GENERATED --
                */
            