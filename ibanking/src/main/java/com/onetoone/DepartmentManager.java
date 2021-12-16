package com.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table( name ="department_manager_details" , uniqueConstraints={
	       @UniqueConstraint(name="myconst", columnNames={"DEPT_ID"})
	   })

public class DepartmentManager {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
   
  private String name;
  @OneToOne
  @JoinColumn(name="DEPT_ID") 
  private Department department;
  
  public DepartmentManager() {}

  public DepartmentManager(String name) {
    this.name = name;
  }


  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + "]";
  }

}