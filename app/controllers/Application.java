package controllers;

import models.*;
import play.data.*;
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
        //return ok(index.render());
        return redirect(routes.Application.tasks());
    }

    // Routes for Projects

    /**
     * Get a list of projects
     * @return a list of projects
     */
    public static Result getProjects(){
        return TODO;
    }

    /**
     * Creates a new project
     * @return nothing
     */
    public static Result newProject(){
        return TODO;
    }

    /**
     * Delete a project
     * @param id
     * @return
     */
    public static Result deleteProject(Long id){
        return TODO;
    }

    // Routes for Materials

    public static Result getMaterials(){
        return TODO;
    }

    public static Result newMaterial(){
        return TODO;
    }

    public static Result deleteMaterial(Long id){
        return TODO;
    }

    // Routes for steps

    public static Result getSteps(){
        return TODO;
    }

    public static Result newStep(){
        return TODO;
    }

    public static Result deleteStep(Long id){
        return TODO;
    }

    //Tasks

    static Form<Task> taskForm = Form.form(Task.class);

    public static Result tasks() {
        return ok(views.html.tasks.render(Task.all(), taskForm));
    }

    public static Result newTask() {
        Form<Task> filledForm = taskForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(
                    views.html.tasks.render(Task.all(), filledForm)
            );
        } else {
            Task.create(filledForm.get());
            return redirect(routes.Application.tasks());
        }
    }

    public static Result deleteTask(Long id) {
        Task.delete(id);
        return redirect(routes.Application.tasks());
    }
  
}
