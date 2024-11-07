package com.jordiribellas.udemy.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user_details") // Nombre de la tabla corregido
public class User {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    
    @Past(message = "Birth Date should be in the past")
    private LocalDate birthDate;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;
    
    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
