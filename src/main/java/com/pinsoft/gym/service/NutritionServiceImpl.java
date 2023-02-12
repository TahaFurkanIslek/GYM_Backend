package com.pinsoft.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.repository.NutritionRepository;

@Service
public class NutritionServiceImpl implements NutritionService{
	
	@Autowired
	NutritionRepository nutritionRepository;
	
	@Override
	public void save(Nutrition nutrition) {
		this.nutritionRepository.save(nutrition);		
	}

	@Override
	public List<Nutrition> getAll() {
		return this.nutritionRepository.findAll();
	}

	@Override
	public List<Nutrition> getUsersMealList(int mealId, int userId) {
		return this.nutritionRepository.findByMealListMealIdAndMealListMealUserId(mealId, userId);
	}

}
