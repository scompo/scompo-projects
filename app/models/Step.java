package models;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

import javax.persistence.*;
import java.util.List;

/**
 * Step model.
 *
 * @author Mauro Scomparin
 * @version 1.0
 */
@Entity
public class Step extends Model {

    /**
     * The id
     */
    @Id
    public Long id;

    /**
     * The description of the step
     */
    @Required
    public String title;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Material> materials;

    /**
     * The description of the step
     */
    public String description;


}
