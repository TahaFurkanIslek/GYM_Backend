package com.pinsoft.gym.service;

import java.util.List;

import com.pinsoft.gym.model.Meal;

public interface MealService {
	void save(Meal meal);
	List<Meal> getAll();
}
