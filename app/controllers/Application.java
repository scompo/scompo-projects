package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    /**
     * Index method.
     *
     * @return the index page
     */
    public static Result index() {
        return ok(index.render());
    }
  
}
