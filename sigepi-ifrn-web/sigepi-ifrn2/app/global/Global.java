package global;

import play.*;
import play.api.mvc.RequestHeader;
import play.mvc.*;
import static play.mvc.Results.*;


public class Global extends GlobalSettings{
	
	@Override
	public void onStart(Application app) {
		Logger.info("Aplication Iniciada!!!");
	}
	
	@Override
	public void onStop(Application app) {
	   Logger.info("Application shutdown...");
	}
	
	// 500 - internal server error
	/*
	public Result onError(Throwable throwable ) {
		
		
      //return redirect(routes.Global.error());
	  //  return InternalServerError(views.html.errorPage.error(throwable)); 
	    
	  }   
 */
	public Result onError(RequestHeader request, Throwable t) {
		  return internalServerError(views.html.global.error.render(t));
	}
	/*
	public Result onError(RequestHeader request, Throwable t){
		//Logger.info("ERROR");
        //return Controller.ok("200");
		return null;
	}
	*/
	/*	
	public Result onHandlerNotFound(RequestHeader request) {
	    return notFound((uri));
	   return notFound(views.html.global.notFound()errors.onHandlerNotFound(request))
	}
	*/
}
