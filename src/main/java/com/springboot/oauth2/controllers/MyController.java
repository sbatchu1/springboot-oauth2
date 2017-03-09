package com.springboot.oauth2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.oauth2.beans.WeatherBean;

@Controller
@RequestMapping("/api")
public class MyController {
	
	@RequestMapping(value = "/{location}/get-weather", method = RequestMethod.GET)
	public ResponseEntity<WeatherBean> getWeather(String location){
		WeatherBean bean = new WeatherBean();
		bean.setRainy(true);
		return new ResponseEntity<WeatherBean>(bean, HttpStatus.OK);
	}
}
