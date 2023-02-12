package com.pinsoft.gym.service;

import java.util.List;


import com.pinsoft.gym.model.NutritionType;

public interface NutritionTypeService {
	void save(NutritionType nutritionType);
	List<NutritionType> getAll();
}
