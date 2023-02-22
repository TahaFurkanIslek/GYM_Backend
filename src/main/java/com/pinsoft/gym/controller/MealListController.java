package com.pinsoft.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinsoft.gym.dto.UserMealInfoDto;
import com.pinsoft.gym.model.MealList;
import com.pinsoft.gym.service.MealListServiceImpl;
import com.pinsoft.gym.shared.GenericResponse;

@RestController
@RequestMapping("/GYM")
public class MealListController {
	@Autowired
	MealListServiceImpl mealListService;
	
	@PostMapping("/meallist/add")
	GenericResponse save(@RequestBody MealList mealList) {
		this.mealListService.save(mealList);
		return new GenericResponse("Öğün Listesi Eklendi");
	}
	
	@GetMapping("/meallist/getall")
	List<MealList> getAll(){
		return this.mealListService.getAll();
	}
	
	@GetMapping("/meallist/getusersmeallist")
	List<MealList> getUsersMealList(int mealId,int userId){
		return this.mealListService.getUsersMealList(mealId, userId);
	}
	
	@GetMapping("/meallist/getusersmeallistdetails")
	UserMealInfoDto getUsersMealListDetails(int mealId, int userId) {
		return this.mealListService.getUsersMealListDetails(mealId, userId);
	}
}
