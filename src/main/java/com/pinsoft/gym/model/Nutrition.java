package com.pinsoft.gym.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","mealList"})
@Table(name="nutrition",schema = "public")
public class Nutrition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
    
	@Column(name="name")
    private String name;
    
	@Column(name="kcal")
    private Double kcal;
    
	@Column(name="protein")
    private Double protein;
    
	@Column(name="carbonhydrate")
    private Double carbonhydrate;
    
	@Column(name="fat")
    private Double fat;
    
	@Column(name="baseweight")
    private Double baseWeight;
	
	@ManyToOne()
	@JoinColumn(name="nutritiontypeid")
	private NutritionType nutritionType;
	
	@OneToMany(mappedBy = "nutrition")
	private List<MealList> mealList;
}








