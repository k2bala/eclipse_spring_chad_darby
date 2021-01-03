package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private List<String> operatingSystems;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("US", "US");
		countryOptions.put("UK", "UK");
		countryOptions.put("IN", "IN");
		countryOptions.put("BR", "BR");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public List<String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
}
