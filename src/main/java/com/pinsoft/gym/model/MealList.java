package com.pinsoft.gym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="meallist",schema = "public")
public class MealList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
    
    @Column(name="weight")
    private Double weight;
    
    @Column(name="createddate")
    private LocalDateTime createdDate;
    
    @ManyToOne()
    @JoinColumn(name="mealid")
    private Meal meal;
    
    @ManyToOne()
    @JoinColumn(name="nutritionid")
    private Nutrition nutrition;
}
