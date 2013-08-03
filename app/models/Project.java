package models;

import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;
import java.util.*;

/**
 * Project model.
 *
 * @author Mauro Scomparin
 * @version 1.0
 */
@Entity
public class Project extends Model{

    /**
     * The id of the project.
     */
    @Id
    public Long id;

    /**
     * The name of the project
     */
    @Required
    public String name;

    /**
     * The description of the project
     */
    public String projectDescription;

    /**
     * The list of steps.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Step> steps;

    /**
     * A finder for the db
     */
    public static Finder<Long,Project> find =new Finder(Long.class,Project.class);

    /**
     * Get all the projects.
     *
     * @return a List of all the projects.
     */
    public static List<Project> all(){
        return find.all();
    }

    /**
     * Create a new project.
     *
     * @param proj the project to create.
     */
    public static void create(Project proj){
        proj.save();
    }

    /**
     * Delete an id.
     *
     * @param id the id of the project to delete.
     */
    public static void delete(long id){
        find.ref(id).delete();
    }
}
