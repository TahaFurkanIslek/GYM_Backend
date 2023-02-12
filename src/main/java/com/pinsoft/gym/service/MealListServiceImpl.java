package com.pinsoft.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinsoft.gym.dto.UserMealInfoDto;
import com.pinsoft.gym.model.MealList;
import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.repository.MealListRepository;

@Service
public class MealListServiceImpl implements MealListService{

	@Autowired
	MealListRepository mealListRepository;
	
	@Override
	public void save(MealList mealList) {
		this.mealListRepository.save(mealList);
	}

	@Override
	public List<MealList> getAll() {
		return this.mealListRepository.findAll();
	}

	@Override
	public List<MealList> getUsersMealList(int mealId, int userId) {		
		return this.mealListRepository.findByMealIdAndMealUserId(mealId, userId);
	}

	@Override
	public UserMealInfoDto getUsersMealListDetails(int mealId, int userId) {
		List<MealList> mealListInDB=this.mealListRepository.findByMealIdAndMealUserId(mealId, userId);
		Double totalKcal=0.0;
		Double totalProtein=0.0;
		Double totalCarbonhydrate=0.0;
		Double totalFat=0.0;
		for (MealList mealList : mealListInDB) {
			Nutrition nutrition=mealList.getNutrition();
			totalKcal+=((nutrition.getKcal())/100)*(mealList.getWeight());
			totalProtein+=((nutrition.getProtein())/100)*(mealList.getWeight());
			totalCarbonhydrate+=((nutrition.getCarbonhydrate())/100)*(mealList.getWeight());
			totalFat+=((nutrition.getFat())/100)*(mealList.getWeight());
		}
		return new UserMealInfoDto(userId,mealId,totalKcal,totalProtein,totalCarbonhydrate,totalFat);
	}

}
