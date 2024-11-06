package com.jordiribellas.udemy.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "post")
public class Post {

    @Id
    private Integer id;
    
    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;
    
    @ManyToOne
    @JsonIgnore
    private User user;
    
    public Post(Integer id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }
}
