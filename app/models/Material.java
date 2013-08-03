package models;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

import javax.persistence.*;

/**
 * Material model.
 *
 * @author Mauro Scomparin
 * @version 1.0
 */
@Entity
public class Material extends Model{

    /**
     * The id of the material
     */
    @Id
    public Long id;

    /**
     * The material name
     */
    @Required
    public String name;

    public String description;
}
