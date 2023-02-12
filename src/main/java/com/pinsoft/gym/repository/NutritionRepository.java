package com.pinsoft.gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.Nutrition;

public interface NutritionRepository extends JpaRepository<Nutrition, Integer>{
	List<Nutrition> findByMealListMealIdAndMealListMealUserId(int mealId,int userId);
}
