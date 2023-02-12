package com.pinsoft.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pinsoft.gym.model.NutritionType;
import com.pinsoft.gym.repository.NutritionTypeRepository;

@Service
public class NutritionTypeServiceImpl implements NutritionTypeService{

	@Autowired
	NutritionTypeRepository nutritionTypeRepository;
	
	@Override
	public void save(NutritionType nutritionType) {
		this.nutritionTypeRepository.save(nutritionType);
		
	}

	@Override
	public List<NutritionType> getAll() {
		return this.nutritionTypeRepository.findAll();
	}

}
