package com.pinsoft.gym.service;

import java.util.List;

import com.pinsoft.gym.dto.UserMealInfoDto;
import com.pinsoft.gym.model.MealList;

public interface MealListService {
	void save(MealList mealList);
	List<MealList> getAll();
	List<MealList> getUsersMealList(int mealId,int userId);
	UserMealInfoDto getUsersMealListDetails(int mealId,int userId);
}
