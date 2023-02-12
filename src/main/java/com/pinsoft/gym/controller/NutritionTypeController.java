package com.pinsoft.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pinsoft.gym.model.NutritionType;
import com.pinsoft.gym.service.NutritionTypeService;
import com.pinsoft.gym.shared.GenericResponse;

@RestController
@RequestMapping("/GYM")
public class NutritionTypeController {
	@Autowired
	NutritionTypeService nutritionTypeService;
	
	@PostMapping("/nutritiontype/add")
	GenericResponse save(@RequestBody NutritionType nutritionType) {
		this.nutritionTypeService.save(nutritionType);
		return new GenericResponse("Besin Tipi Eklendi");
	}
	
	@GetMapping("/nutritiontype/getall")
	List<NutritionType> getAll(){
		return this.nutritionTypeService.getAll();
	}
}
