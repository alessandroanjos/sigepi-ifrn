// @SOURCE:C:/Users/Denilde/workspace/sigepi-ifrn/conf/routes
// @HASH:c7d5e886f611b9e522bb512777eca87c07863626
// @DATE:Tue Nov 13 12:58:59 BRST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:10
val controllers_Sessions_login1 = Route("GET", PathPattern(List(StaticPart("/acesso"))))
                    

// @LINE:11
val controllers_Sessions_esqueciSenha2 = Route("GET", PathPattern(List(StaticPart("/esqueci-senha"))))
                    

// @LINE:12
val controllers_Sessions_efetuarLogin3 = Route("POST", PathPattern(List(StaticPart("/acessar-minha-conta"))))
                    

// @LINE:13
val controllers_Sessions_efetuarlogout4 = Route("GET", PathPattern(List(StaticPart("/sair-do-sistema"))))
                    

// @LINE:17
val controllers_Administracao_index5 = Route("GET", PathPattern(List(StaticPart("/administracao/admin"))))
                    

// @LINE:18
val controllers_Administracao_cadastrarEdital6 = Route("GET", PathPattern(List(StaticPart("/administracao/admin/cadastrar-edital"))))
                    

// @LINE:21
val controllers_Avaliadores_index7 = Route("GET", PathPattern(List(StaticPart("/administracao/avaliador"))))
                    

// @LINE:22
val controllers_Avaliadores_avaliarProjeto8 = Route("GET", PathPattern(List(StaticPart("/administracao/avaliador/avaliar-projetos"))))
                    

// @LINE:23
val controllers_Avaliadores_acessarDadosProjeto9 = Route("GET", PathPattern(List(StaticPart("/administracao/avaliador/acessar-dados-projeto"))))
                    

// @LINE:24
val controllers_Avaliadores_acessarFormulario10 = Route("GET", PathPattern(List(StaticPart("/administracao/avaliador/acessar-formulario"))))
                    

// @LINE:28
val controllers_Professores_index11 = Route("GET", PathPattern(List(StaticPart("/administracao/professor"))))
                    

// @LINE:29
val controllers_Professores_cadastrarProjeto12 = Route("GET", PathPattern(List(StaticPart("/administracao/professor/cadastrar-projeto"))))
                    

// @LINE:30
val controllers_Professores_adicionarMembrosProjeto13 = Route("GET", PathPattern(List(StaticPart("/administracao/professor/addMembros"))))
                    

// @LINE:36
val controllers_Assets_at14 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/acesso""","""controllers.Sessions.login()"""),("""GET""","""/esqueci-senha""","""controllers.Sessions.esqueciSenha()"""),("""POST""","""/acessar-minha-conta""","""controllers.Sessions.efetuarLogin()"""),("""GET""","""/sair-do-sistema""","""controllers.Sessions.efetuarlogout()"""),("""GET""","""/administracao/admin""","""controllers.Administracao.index()"""),("""GET""","""/administracao/admin/cadastrar-edital""","""controllers.Administracao.cadastrarEdital()"""),("""GET""","""/administracao/avaliador""","""controllers.Avaliadores.index()"""),("""GET""","""/administracao/avaliador/avaliar-projetos""","""controllers.Avaliadores.avaliarProjeto()"""),("""GET""","""/administracao/avaliador/acessar-dados-projeto""","""controllers.Avaliadores.acessarDadosProjeto()"""),("""GET""","""/administracao/avaliador/acessar-formulario""","""controllers.Avaliadores.acessarFormulario()"""),("""GET""","""/administracao/professor""","""controllers.Professores.index()"""),("""GET""","""/administracao/professor/cadastrar-projeto""","""controllers.Professores.cadastrarProjeto()"""),("""GET""","""/administracao/professor/addMembros""","""controllers.Professores.adicionarMembrosProjeto()"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:10
case controllers_Sessions_login1(params) => {
   call { 
        invokeHandler(_root_.controllers.Sessions.login(), HandlerDef(this, "controllers.Sessions", "login", Nil))
   }
}
                    

// @LINE:11
case controllers_Sessions_esqueciSenha2(params) => {
   call { 
        invokeHandler(_root_.controllers.Sessions.esqueciSenha(), HandlerDef(this, "controllers.Sessions", "esqueciSenha", Nil))
   }
}
                    

// @LINE:12
case controllers_Sessions_efetuarLogin3(params) => {
   call { 
        invokeHandler(_root_.controllers.Sessions.efetuarLogin(), HandlerDef(this, "controllers.Sessions", "efetuarLogin", Nil))
   }
}
                    

// @LINE:13
case controllers_Sessions_efetuarlogout4(params) => {
   call { 
        invokeHandler(_root_.controllers.Sessions.efetuarlogout(), HandlerDef(this, "controllers.Sessions", "efetuarlogout", Nil))
   }
}
                    

// @LINE:17
case controllers_Administracao_index5(params) => {
   call { 
        invokeHandler(_root_.controllers.Administracao.index(), HandlerDef(this, "controllers.Administracao", "index", Nil))
   }
}
                    

// @LINE:18
case controllers_Administracao_cadastrarEdital6(params) => {
   call { 
        invokeHandler(_root_.controllers.Administracao.cadastrarEdital(), HandlerDef(this, "controllers.Administracao", "cadastrarEdital", Nil))
   }
}
                    

// @LINE:21
case controllers_Avaliadores_index7(params) => {
   call { 
        invokeHandler(_root_.controllers.Avaliadores.index(), HandlerDef(this, "controllers.Avaliadores", "index", Nil))
   }
}
                    

// @LINE:22
case controllers_Avaliadores_avaliarProjeto8(params) => {
   call { 
        invokeHandler(_root_.controllers.Avaliadores.avaliarProjeto(), HandlerDef(this, "controllers.Avaliadores", "avaliarProjeto", Nil))
   }
}
                    

// @LINE:23
case controllers_Avaliadores_acessarDadosProjeto9(params) => {
   call { 
        invokeHandler(_root_.controllers.Avaliadores.acessarDadosProjeto(), HandlerDef(this, "controllers.Avaliadores", "acessarDadosProjeto", Nil))
   }
}
                    

// @LINE:24
case controllers_Avaliadores_acessarFormulario10(params) => {
   call { 
        invokeHandler(_root_.controllers.Avaliadores.acessarFormulario(), HandlerDef(this, "controllers.Avaliadores", "acessarFormulario", Nil))
   }
}
                    

// @LINE:28
case controllers_Professores_index11(params) => {
   call { 
        invokeHandler(_root_.controllers.Professores.index(), HandlerDef(this, "controllers.Professores", "index", Nil))
   }
}
                    

// @LINE:29
case controllers_Professores_cadastrarProjeto12(params) => {
   call { 
        invokeHandler(_root_.controllers.Professores.cadastrarProjeto(), HandlerDef(this, "controllers.Professores", "cadastrarProjeto", Nil))
   }
}
                    

// @LINE:30
case controllers_Professores_adicionarMembrosProjeto13(params) => {
   call { 
        invokeHandler(_root_.controllers.Professores.adicionarMembrosProjeto(), HandlerDef(this, "controllers.Professores", "adicionarMembrosProjeto", Nil))
   }
}
                    

// @LINE:36
case controllers_Assets_at14(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                