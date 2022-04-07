package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			// read json file & convert to pojo
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			// print form pojo
			System.out.println(theStudent.getFirstName());
			System.out.println(theStudent.getLastName());
			Address address = theStudent.getAddress();
			System.out.println(address.getStreet());
			System.out.println(address.getCity());
			for (String s : theStudent.getLanguages()) {
				System.out.println(s);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
