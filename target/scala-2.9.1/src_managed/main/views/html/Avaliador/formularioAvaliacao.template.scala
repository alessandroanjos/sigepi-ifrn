
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
object formularioAvaliacao extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*3.2*/main("SIGEPI - Formulario de Avaliacao")/*3.42*/ {_display_(Seq[Any](format.raw/*3.44*/("""

<html>

<body>

<div class="topbar">
	        <div class="fill">
	              <div id="headerCSS">
	                    <a class="brand" href=""""),_display_(Seq[Any](/*12.46*/routes/*12.52*/.Avaliadores.index())),format.raw/*12.72*/("""">Home</a>
	                    <ul class="">
	                        <li class="">
	                            <a href=""""),_display_(Seq[Any](/*15.40*/routes/*15.46*/.Avaliadores.avaliarProjeto())),format.raw/*15.75*/("""">Avaliar Projetos</a>
	                        </li>
	                        """),format.raw/*21.28*/("""
	                    </ul>
	                    <dl id="user" class="afastar">
	                       <dt>user.name <span>(user.email)</span></dt>
	                         <dd>
	                              <a href=""""),_display_(Seq[Any](/*26.42*/routes/*26.48*/.Sessions.efetuarlogout())),format.raw/*26.73*/("""">Sair</a>
	                        </dd>
	                   </dl>
	                   
	                </div>
	         </div>
	 </div>
	 
	 
<h1>Formulario de Avaliacao do Projeto de Pesquisa</h1>


 <form name="pergunta01">
<h4>01 - Nononononononononononono </h4>
    


<input type="radio" name=op id="otimo1" >Otimo <br>
<input type="radio" name=op id="bom1" >Bom <br>
<input type="radio" name=op id="regular1" >Regular<br>
<input type="radio" name=op id="ruim1" >Ruim<br>
<input type="radio" name=op id="pessimo1" >Pessimo<br>
 

<br><br><br>
</form>

<h4>02 - Nononononononononononono </h4>
    
<form name="pergunta02">

<input type="radio" name=op id="otimo2" >Otimo <br>
<input type="radio" name=op id="bom2" >Bom <br>
<input type="radio" name=op id="regular2" >Regular<br>
<input type="radio" name=op id="ruim2" >Ruim<br>
<input type="radio" name=op id="pessimo2" >Pessimo<br>
</form>



<br><br><br>
<!--  -->


<form name="pergunta03">
<h4>03 - Nononononononononononono </h4>
    


<input type="radio" name=op id="otimo3" >Otimo <br>
<input type="radio" name=op id="bom3" >Bom <br>
<input type="radio" name=op id="regular3" >Regular<br>
<input type="radio" name=op id="ruim3" >Ruim<br>
<input type="radio" name=op id="pessimo3" >Pessimo<br>
</form>

<br><br><br>

<!--  -->


<form name="pergunta04">
<h4>04 - Nononononononononononono </h4>
    


<input type="radio" name=op id="otimo4" >Otimo <br>
<input type="radio" name=op id="bom4" >Bom <br>
<input type="radio" name=op id="regular4" >Regular<br>
<input type="radio" name=op id="ruim4" >Ruim<br>
<input type="radio" name=op id="pessimo4" >Pessimo<br>

</form>



<br><br><br>
<!--  -->



<form name="pergunta05">
<h4>05 - Nononononononononononono </h4>
    


<input type="radio" name=op id="otimo5" >Otimo <br>
<input type="radio" name=op id="bom5" >Bom <br>
<input type="radio" name=op id="regular5" >Regular<br>
<input type="radio" name=op id="ruim5" >Ruim<br>
<input type="radio" name=op id="pessimo5" >Pessimo<br>

</form>




<br><br><br>

<input type="submit" value="Aceitar Submissao" class="aceitarSubmissao btn success" >  

<input type="submit" value="Aceitar com Restricoes" class="aceitarRestricoes btn primary"  >   

<input type="submit" value="Rejeitar" class="rejeitarSubmissao btn danger pull-right" >
 
<br><br>
<hr>
<a href=""""),_display_(Seq[Any](/*133.11*/routes/*133.17*/.Avaliadores.acessarDadosProjeto())),format.raw/*133.51*/("""" class="btn">Voltar</a>


</body>





</html>

""")))})),format.raw/*144.2*/(""" 
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 11:06:57 BRST 2012
                    SOURCE: C:/Users/Alessandro/workspace/sigepi-ifrn/app/views/Avaliador/formularioAvaliacao.scala.html
                    HASH: a9060324f4173cb7e37afd147ee1aae507826070
                    MATRIX: 852->5|900->45|939->47|1132->204|1147->210|1189->230|1352->357|1367->363|1418->392|1527->656|1789->882|1804->888|1851->913|4314->3339|4330->3345|4387->3379|4480->3440
                    LINES: 30->3|30->3|30->3|39->12|39->12|39->12|42->15|42->15|42->15|44->21|49->26|49->26|49->26|156->133|156->133|156->133|167->144
                    -- GENERATED --
                */
            