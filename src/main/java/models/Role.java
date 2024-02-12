package models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    private Long id;
    private String libelle;
    private String code;

    @OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST)
    public List<User> getUsers() {
        return users;
    }

    private List<User> users = new ArrayList<User>();

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}