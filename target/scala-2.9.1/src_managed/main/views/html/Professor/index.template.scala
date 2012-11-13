
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("SIGEPI - Area do Professor")/*1.36*/{_display_(Seq[Any](format.raw/*1.37*/("""


<html>
<body>
	<div class="topbar">
		<div class="fill">
			<div id="headerCSS">
				<a class="brand" href=""""),_display_(Seq[Any](/*9.29*/routes/*9.35*/.Professores.index())),format.raw/*9.55*/("""">Home</a>
				<ul class="">
					<li class=""><a href=""""),_display_(Seq[Any](/*11.29*/routes/*11.35*/.Professores.cadastrarProjeto())),format.raw/*11.66*/("""">Cadastrar	Projeto</a></li>
							<li class=""><a href=""""),_display_(Seq[Any](/*12.31*/routes/*12.37*/.Professores.adicionarMembrosProjeto())),format.raw/*12.75*/("""">
							Inserir Membros</a></li>
							 """),format.raw/*16.13*/("""
				</ul>
				<dl id="user" class="afastar">
					<dt>user.name<span>(user.mail)</span></dt>
					<dd>
						<a href=""""),_display_(Seq[Any](/*21.17*/routes/*21.23*/.Sessions.efetuarlogout())),format.raw/*21.48*/("""">Sair</a></dd>
				</dl>
			</div>
		</div>
	</div> 
	
	<h1>O que deseja fazer?</h1>
</body> 
<a href=""""),_display_(Seq[Any](/*29.11*/routes/*29.17*/.Professores.cadastrarProjeto())),format.raw/*29.48*/("""" class="btn">Cadastrar Projeto</a>
<a href=""""),_display_(Seq[Any](/*30.11*/routes/*30.17*/.Professores.adicionarMembrosProjeto())),format.raw/*30.55*/("""" class="btn">Adicionar Membros</a>
</html> 
""")))})),format.raw/*32.2*/(""" """))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 11:25:00 BRT 2012
                    SOURCE: /Users/tarsolatorraca/Desktop/sigepi-ifrn/app/views/Professor/index.scala.html
                    HASH: a61f0786dd7727a3f1592825e043e30962e8d5c7
                    MATRIX: 838->1|880->35|918->36|1073->156|1087->162|1128->182|1223->241|1238->247|1291->278|1387->338|1402->344|1462->382|1535->511|1696->636|1711->642|1758->667|1907->780|1922->786|1975->817|2058->864|2073->870|2133->908|2212->956
                    LINES: 30->1|30->1|30->1|38->9|38->9|38->9|40->11|40->11|40->11|41->12|41->12|41->12|43->16|48->21|48->21|48->21|56->29|56->29|56->29|57->30|57->30|57->30|59->32
                    -- GENERATED --
                */
            