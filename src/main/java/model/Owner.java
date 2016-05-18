package model;

/**
 * Model owner class.
 * Contains constructors, setters and getters.
 * @author Anastasiia Rybakova
 * @since 04.2016
 */

public class Owner {

    private int ownerId;
    private String firstName;
    private String lastName;
    private String parkName;
    private String email;
    private String password;

    public Owner(int ownerId, String firstName, String lastName, String parkName, String email, String password) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parkName = parkName;
        this.email = email;
        this.password = password;
    }

    public Owner(String firstName, String lastName, String parkName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.parkName = parkName;
        this.email = email;
        this.password = password;
    }

    public Owner(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Owner(int ownerId, String firstName, String lastName) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Owner() {
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
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
