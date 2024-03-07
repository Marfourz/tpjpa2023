package models;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class User {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private Role role;
    private List<Ticket> ticketsCreated;
    private List<Ticket> ticketsAffected;
    private List<Message> messages;

   


    public User() {}

    public User(Long id, String username, String firstname, String lastname, Role role, List<Ticket> ticketsCreated, List<Ticket> ticketsAffected) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.ticketsCreated = ticketsCreated;
        this.ticketsAffected = ticketsAffected;
    }



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "creator", cascade = CascadeType.PERSIST)
    public List<Ticket> getTicketsCreated() {
        return this.ticketsCreated;
    }

    @ManyToMany(mappedBy = "assignedUsers", cascade = CascadeType.PERSIST)
    public List<Ticket> getTicketsAffected() {
        return this.ticketsAffected;
    }

    @OneToMany(mappedBy = "user")
    public List<Message> getMessages() {
        return this.messages;
    }


    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


    @ManyToOne()
    public Role getRole() {
        return role;
    }


    public void setUsername(String username) {
        this.username = username;
    }

   

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

   

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketsCreated(List<Ticket> tickets) {
        this.ticketsCreated= tickets;
    }

    public void setTicketsAffected(List<Ticket> tickets) {
        this.ticketsCreated= tickets;
    }

    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


    @Override
    public String toString() {
        return "User : " + this.username;
    }
}
