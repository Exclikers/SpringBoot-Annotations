package net.spring.boot.model;


import java.util.Set;
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Transient;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;
 

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role  implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String role;
  
  @ManyToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Person> persons;
  
}