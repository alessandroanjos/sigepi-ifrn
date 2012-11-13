
package views.html.Sessions

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
object esqueciSenha extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Avaliador],play.api.templates.Html] {

    /**/
    def apply/*1.5*/(loginForm: Form[Avaliador]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.33*/(""" 
    
    
    
 """),_display_(Seq[Any](/*5.3*/main("SIGEPI esqueceu sua senha")/*5.36*/ {_display_(Seq[Any](format.raw/*5.38*/("""
    <h1>Esqueceu seu Senha!</h1>
    
    <a href=""""),_display_(Seq[Any](/*8.15*/routes/*8.21*/.Sessions.login)),format.raw/*8.36*/("""" class="btn">Cancelar</a>
  """),format.raw/*31.3*/("""


""")))})))}
    }
    
    def render(loginForm:Form[Avaliador]) = apply(loginForm)
    
    def f:((Form[Avaliador]) => play.api.templates.Html) = (loginForm) => apply(loginForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 11:25:00 BRT 2012
                    SOURCE: /Users/tarsolatorraca/Desktop/sigepi-ifrn/app/views/Sessions/esqueciSenha.scala.html
                    HASH: 1d511e0a7096f518b74df15ea899370b8b088248
                    MATRIX: 780->4|885->32|942->55|983->88|1022->90|1113->146|1127->152|1163->167|1220->929
                    LINES: 27->1|30->1|34->5|34->5|34->5|37->8|37->8|37->8|38->31
                    -- GENERATED --
                */
            