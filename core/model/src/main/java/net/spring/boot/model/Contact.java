package net.spring.boot.model;

import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
 
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contact implements Serializable{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long contactId;

  private Long landline;
  private Long mobile;
  private String email;
 
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "person_id", nullable = false)
  @JsonIgnore
  private Person person;
  
 
}