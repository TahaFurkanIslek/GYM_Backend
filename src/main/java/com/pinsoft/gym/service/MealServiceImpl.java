package com.pinsoft.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.repository.MealRepository;

@Service
public class MealServiceImpl implements MealService{
	
	@Autowired
	MealRepository mealRepository;
	
	@Override
	public void save(Meal meal) {
		this.mealRepository.save(meal);
		
	}

	@Override
	public List<Meal> getAll() {
		return this.mealRepository.findAll();
	}

}
