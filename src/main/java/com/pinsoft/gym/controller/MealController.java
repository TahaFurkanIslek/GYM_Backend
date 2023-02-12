package com.pinsoft.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.service.MealServiceImpl;
import com.pinsoft.gym.shared.GenericResponse;

@RestController
@RequestMapping("/GYM")
public class MealController {
	@Autowired
	MealServiceImpl mealService;
	
	@PostMapping("/meal/add")
	GenericResponse save(@RequestBody Meal meal) {
		this.mealService.save(meal);
		return new GenericResponse("Öğün Eklendi");
	}
	
	@GetMapping("/meal/getall")
	List<Meal> getAll(){
		return this.mealService.getAll();
	}
	
}
