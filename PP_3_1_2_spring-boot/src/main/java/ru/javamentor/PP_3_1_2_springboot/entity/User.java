package ru.javamentor.PP_3_1_2_springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @Size(min = 2, max = 30, message = "Lastname must be between 2 and 30 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "The field must not be empty")
    @Column(name = "email")
    @Email(message = "Email must be valid")
    private String email;

    @Size(min = 2, max = 30, message = "Sity must be between 2 and 30 characters")
    @Column(name = "sity")
    private String sity;

    @Min(value = 0, message = "Age must be between 0 and 100 years old")
    @Max(value = 100, message = "Age must be between 0 and 100 years old")
    @Column(name = "age")
    private byte age;

    public User() {
    }

    public User(String name, String lastName, byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = (byte) age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }
}

