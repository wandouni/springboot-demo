package com.example.demo.beans;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Taco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private Date createAt;
  @ManyToMany(targetEntity = Ingredient.class)
  // Spring Data JPA这个框架会把实体类的属性当做是MySQL数据库中的字段，但是MySQL数据库中又没得List属性，所以才会提示这个错误。
  private List<Ingredient> ingredientList;
  void createAt(){
    this.createAt=new Date();
  }
}
