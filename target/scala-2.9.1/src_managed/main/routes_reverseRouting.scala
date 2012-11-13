// @SOURCE:/Users/tarsolatorraca/Desktop/sigepi-ifrn/conf/routes
// @HASH:c7d5e886f611b9e522bb512777eca87c07863626
// @DATE:Tue Nov 13 11:24:59 BRT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:36
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers {

// @LINE:36
class ReverseAssets {
    


 
// @LINE:36
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            

// @LINE:18
// @LINE:17
class ReverseAdministracao {
    


 
// @LINE:18
def cadastrarEdital() = {
   Call("GET", "/administracao/admin/cadastrar-edital")
}
                                                        
 
// @LINE:17
def index() = {
   Call("GET", "/administracao/admin")
}
                                                        

                      
    
}
                            

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
class ReverseAvaliadores {
    


 
// @LINE:22
def avaliarProjeto() = {
   Call("GET", "/administracao/avaliador/avaliar-projetos")
}
                                                        
 
// @LINE:24
def acessarFormulario() = {
   Call("GET", "/administracao/avaliador/acessar-formulario")
}
                                                        
 
// @LINE:23
def acessarDadosProjeto() = {
   Call("GET", "/administracao/avaliador/acessar-dados-projeto")
}
                                                        
 
// @LINE:21
def index() = {
   Call("GET", "/administracao/avaliador")
}
                                                        

                      
    
}
                            

// @LINE:30
// @LINE:29
// @LINE:28
class ReverseProfessores {
    


 
// @LINE:29
def cadastrarProjeto() = {
   Call("GET", "/administracao/professor/cadastrar-projeto")
}
                                                        
 
// @LINE:30
def adicionarMembrosProjeto() = {
   Call("GET", "/administracao/professor/addMembros")
}
                                                        
 
// @LINE:28
def index() = {
   Call("GET", "/administracao/professor")
}
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        

                      
    
}
                            

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSessions {
    


 
// @LINE:12
def efetuarLogin() = {
   Call("POST", "/acessar-minha-conta")
}
                                                        
 
// @LINE:11
def esqueciSenha() = {
   Call("GET", "/esqueci-senha")
}
                                                        
 
// @LINE:10
def login() = {
   Call("GET", "/acesso")
}
                                                        
 
// @LINE:13
def efetuarlogout() = {
   Call("GET", "/sair-do-sistema")
}
                                                        

                      
    
}
                            
}
                    


// @LINE:36
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.javascript {

// @LINE:36
class ReverseAssets {
    


 
// @LINE:36
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:18
// @LINE:17
class ReverseAdministracao {
    


 
// @LINE:18
def cadastrarEdital = JavascriptReverseRoute(
   "controllers.Administracao.cadastrarEdital",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/admin/cadastrar-edital"})
      }
   """
)
                                                        
 
// @LINE:17
def index = JavascriptReverseRoute(
   "controllers.Administracao.index",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/admin"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
class ReverseAvaliadores {
    


 
// @LINE:22
def avaliarProjeto = JavascriptReverseRoute(
   "controllers.Avaliadores.avaliarProjeto",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/avaliador/avaliar-projetos"})
      }
   """
)
                                                        
 
// @LINE:24
def acessarFormulario = JavascriptReverseRoute(
   "controllers.Avaliadores.acessarFormulario",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/avaliador/acessar-formulario"})
      }
   """
)
                                                        
 
// @LINE:23
def acessarDadosProjeto = JavascriptReverseRoute(
   "controllers.Avaliadores.acessarDadosProjeto",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/avaliador/acessar-dados-projeto"})
      }
   """
)
                                                        
 
// @LINE:21
def index = JavascriptReverseRoute(
   "controllers.Avaliadores.index",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/avaliador"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:30
// @LINE:29
// @LINE:28
class ReverseProfessores {
    


 
// @LINE:29
def cadastrarProjeto = JavascriptReverseRoute(
   "controllers.Professores.cadastrarProjeto",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/professor/cadastrar-projeto"})
      }
   """
)
                                                        
 
// @LINE:30
def adicionarMembrosProjeto = JavascriptReverseRoute(
   "controllers.Professores.adicionarMembrosProjeto",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/professor/addMembros"})
      }
   """
)
                                                        
 
// @LINE:28
def index = JavascriptReverseRoute(
   "controllers.Professores.index",
   """
      function() {
      return _wA({method:"GET", url:"/administracao/professor"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSessions {
    


 
// @LINE:12
def efetuarLogin = JavascriptReverseRoute(
   "controllers.Sessions.efetuarLogin",
   """
      function() {
      return _wA({method:"POST", url:"/acessar-minha-conta"})
      }
   """
)
                                                        
 
// @LINE:11
def esqueciSenha = JavascriptReverseRoute(
   "controllers.Sessions.esqueciSenha",
   """
      function() {
      return _wA({method:"GET", url:"/esqueci-senha"})
      }
   """
)
                                                        
 
// @LINE:10
def login = JavascriptReverseRoute(
   "controllers.Sessions.login",
   """
      function() {
      return _wA({method:"GET", url:"/acesso"})
      }
   """
)
                                                        
 
// @LINE:13
def efetuarlogout = JavascriptReverseRoute(
   "controllers.Sessions.efetuarlogout",
   """
      function() {
      return _wA({method:"GET", url:"/sair-do-sistema"})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:36
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.ref {

// @LINE:36
class ReverseAssets {
    


 
// @LINE:36
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:18
// @LINE:17
class ReverseAdministracao {
    


 
// @LINE:18
def cadastrarEdital() = new play.api.mvc.HandlerRef(
   controllers.Administracao.cadastrarEdital(), HandlerDef(this, "controllers.Administracao", "cadastrarEdital", Seq())
)
                              
 
// @LINE:17
def index() = new play.api.mvc.HandlerRef(
   controllers.Administracao.index(), HandlerDef(this, "controllers.Administracao", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
class ReverseAvaliadores {
    


 
// @LINE:22
def avaliarProjeto() = new play.api.mvc.HandlerRef(
   controllers.Avaliadores.avaliarProjeto(), HandlerDef(this, "controllers.Avaliadores", "avaliarProjeto", Seq())
)
                              
 
// @LINE:24
def acessarFormulario() = new play.api.mvc.HandlerRef(
   controllers.Avaliadores.acessarFormulario(), HandlerDef(this, "controllers.Avaliadores", "acessarFormulario", Seq())
)
                              
 
// @LINE:23
def acessarDadosProjeto() = new play.api.mvc.HandlerRef(
   controllers.Avaliadores.acessarDadosProjeto(), HandlerDef(this, "controllers.Avaliadores", "acessarDadosProjeto", Seq())
)
                              
 
// @LINE:21
def index() = new play.api.mvc.HandlerRef(
   controllers.Avaliadores.index(), HandlerDef(this, "controllers.Avaliadores", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:30
// @LINE:29
// @LINE:28
class ReverseProfessores {
    


 
// @LINE:29
def cadastrarProjeto() = new play.api.mvc.HandlerRef(
   controllers.Professores.cadastrarProjeto(), HandlerDef(this, "controllers.Professores", "cadastrarProjeto", Seq())
)
                              
 
// @LINE:30
def adicionarMembrosProjeto() = new play.api.mvc.HandlerRef(
   controllers.Professores.adicionarMembrosProjeto(), HandlerDef(this, "controllers.Professores", "adicionarMembrosProjeto", Seq())
)
                              
 
// @LINE:28
def index() = new play.api.mvc.HandlerRef(
   controllers.Professores.index(), HandlerDef(this, "controllers.Professores", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseSessions {
    


 
// @LINE:12
def efetuarLogin() = new play.api.mvc.HandlerRef(
   controllers.Sessions.efetuarLogin(), HandlerDef(this, "controllers.Sessions", "efetuarLogin", Seq())
)
                              
 
// @LINE:11
def esqueciSenha() = new play.api.mvc.HandlerRef(
   controllers.Sessions.esqueciSenha(), HandlerDef(this, "controllers.Sessions", "esqueciSenha", Seq())
)
                              
 
// @LINE:10
def login() = new play.api.mvc.HandlerRef(
   controllers.Sessions.login(), HandlerDef(this, "controllers.Sessions", "login", Seq())
)
                              
 
// @LINE:13
def efetuarlogout() = new play.api.mvc.HandlerRef(
   controllers.Sessions.efetuarlogout(), HandlerDef(this, "controllers.Sessions", "efetuarlogout", Seq())
)
                              

                      
    
}
                            
}
                    
                