package com.pinsoft.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.service.NutritionServiceImpl;
import com.pinsoft.gym.shared.GenericResponse;

@RestController
@RequestMapping("/GYM")
public class NutritionController {
	
	@Autowired
	NutritionServiceImpl nutritionService;
	
	@PostMapping("/nutrition/add")
	GenericResponse save(@RequestBody Nutrition nutrition) {
		this.nutritionService.save(nutrition);
		return new GenericResponse("Besin Eklendi");
	}
	
	@GetMapping("/nutrition/getall")
	List<Nutrition> getAll(){
		return this.nutritionService.getAll();
	}
	
	@GetMapping("/nutrition/getusersmeallist")
	List<Nutrition> getUsersMealList(int mealId,int userId){
		return this.nutritionService.getUsersMealList(mealId, userId);
	}
	
}
