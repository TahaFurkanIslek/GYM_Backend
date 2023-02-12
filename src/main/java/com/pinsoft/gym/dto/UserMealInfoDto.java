package com.pinsoft.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMealInfoDto {
	private Integer userId;
	private Integer mealId;
	private Double totalKcal;
	private Double totalProtein;
	private Double totalCarbonhydrate;
	private Double totalFat;
}
