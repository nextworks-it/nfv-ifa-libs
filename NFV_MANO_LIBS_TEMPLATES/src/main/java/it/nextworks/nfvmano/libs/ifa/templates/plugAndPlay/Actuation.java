package it.nextworks.nfvmano.libs.ifa.templates.plugAndPlay;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Actuation {
    @Id
    private String name;
    private String description;

    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch= FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Map<String,String> parameters;


    public Actuation(){ }

    public Actuation(String name, String description, Map<String, String> parameters){
        this.name = name;
        this.description=description;
        this.parameters=parameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

}