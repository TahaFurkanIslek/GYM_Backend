package com.pinsoft.gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.gym.model.MealList;

public interface MealListRepository extends JpaRepository<MealList, Integer>{
	List<MealList> findByMealIdAndMealUserId(int mealId,int userId);
}
