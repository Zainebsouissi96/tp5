package com.example.esb_2025;

public class User {

    private int id;
    private String username;
    private String pwd;
    private String cin;
    private String firstname;
    private String lastname;

    // Constructeur vide
    public User() {}

    // Constructeur avec ID
    public User(int id, String username, String pwd, String cin, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.cin = cin;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Constructeur sans ID (pour insertion)
    public User(String username, String pwd, String cin, String firstname, String lastname) {
        this.username = username;
        this.pwd = pwd;
        this.cin = cin;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Getters / Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }

    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
}


