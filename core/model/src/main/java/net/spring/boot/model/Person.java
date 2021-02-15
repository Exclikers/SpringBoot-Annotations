package net.spring.boot.model;

import java.io.Serializable;
import java.util.Set;
import java.util.Date; 
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person implements Serializable{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //name
  private String title;
  private String firstName;
  private String lastName;
  private String middleName;
  private String suffix;

  //address
  private int streetNumber;
  private String barangay;
  private String municipality;
  private int zipcode;

  //additional info
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date birthdate;
  private double gradeWeightedAverage;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date dateHired;
  private String employmentStatus;
  
  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Contact> contact;
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"), 
  inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Set<Role> role;


}