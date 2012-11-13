
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
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[form.LoginForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(loginForm: Form[form.LoginForm]):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.35*/("""


"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("SIGEPI entrar")/*7.23*/ {_display_(Seq[Any](format.raw/*7.25*/("""
<html>
<head>
  
</head>

<div class="well" style="width:400px; margin:0 auto;">
   		"""),_display_(Seq[Any](/*14.7*/helper/*14.13*/.form(action = routes.Sessions.efetuarLogin(), 'style -> "margin:0;")/*14.82*/ {_display_(Seq[Any](format.raw/*14.84*/("""
   			<fieldset>
   				<legend>Acessar minha Conta</legend>
   				"""),_display_(Seq[Any](/*17.9*/helper/*17.15*/.inputText(loginForm("login"), 'class -> "span3", '_label -> "Login: "))),format.raw/*17.86*/("""
   				"""),_display_(Seq[Any](/*18.9*/helper/*18.15*/.inputPassword(loginForm("senha"), 'class -> "span3", '_label -> "Senha: "))),format.raw/*18.90*/("""
   				<center>
   				   <input type="submit" value="Acessar!" class="btn primary">
   				   <a href=""""),_display_(Seq[Any](/*21.21*/routes/*21.27*/.Sessions.esqueciSenha)),format.raw/*21.49*/("""" class="btn">Esqueci minha Senha!</a>
   			    </center> 
   			</fieldset>
   		""")))})),format.raw/*24.7*/(""" 
  	</div> 
  	
  	
</html> 
""")))})))}
    }
    
    def render(loginForm:Form[form.LoginForm]) = apply(loginForm)
    
    def f:((Form[form.LoginForm]) => play.api.templates.Html) = (loginForm) => apply(loginForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 13 12:59:01 BRST 2012
                    SOURCE: C:/Users/Denilde/workspace/sigepi-ifrn/app/views/Sessions/login.scala.html
                    HASH: 6ae9b04673d76269ca56e1863cabbef5795b6682
                    MATRIX: 778->1|940->34|972->93|1009->96|1038->117|1077->119|1207->214|1222->220|1300->289|1340->291|1448->364|1463->370|1556->441|1601->451|1616->457|1713->532|1858->641|1873->647|1917->669|2035->756
                    LINES: 27->1|33->1|36->6|37->7|37->7|37->7|44->14|44->14|44->14|44->14|47->17|47->17|47->17|48->18|48->18|48->18|51->21|51->21|51->21|54->24
                    -- GENERATED --
                */
            