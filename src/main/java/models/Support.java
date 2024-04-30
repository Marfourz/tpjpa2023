package models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Support
 */
@Entity
@DiscriminatorValue("1")
public class Support extends User { 
    public Support(){
        super();
    }    

}