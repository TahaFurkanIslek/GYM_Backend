package com.pinsoft.gym.service;

import java.util.List;

import com.pinsoft.gym.model.Nutrition;

public interface NutritionService {
	void save(Nutrition nutrition);
	List<Nutrition> getAll();
	List<Nutrition> getUsersMealList(int mealId,int userId);
}
