package com.thecheckler.sburrestdemo.classs;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
interface Cofferepository extends CrudRepository<Coffee,String>{};
@Entity
public class Coffee {
    @Id
    private String id;
    private String name;
    public  Coffee (){};
    public Coffee(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    public Coffee(String name){
        this(UUID.randomUUID().toString(),name);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
