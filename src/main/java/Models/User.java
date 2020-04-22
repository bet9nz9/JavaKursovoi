package Models;

import javax.persistence.*;

@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "login")
    private  String login;
    @Column(name = "password")
    private  String pass;
    @Column(name = "username")
    private  String username;
    @Column(name = "description")
    private  String description;

}
