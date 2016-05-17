package model;

/**
 * Created by rybatsky
 */

public class Forester {

    private int foresterId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Forester(int foresterId, String firstName, String lastName, String email, String password) {
        this.foresterId = foresterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Forester(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Forester(int foresterId, String firstName, String lastName) {
        this.foresterId = foresterId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Forester() {
    }

    public int getForesterId() {
        return foresterId;
    }

    public void setForesterId(int foresterId) {
        this.foresterId = foresterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
