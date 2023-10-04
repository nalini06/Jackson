package com.jacksontutorial;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacksontutorial.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		String jsonString = "{\"user_id\":1234,\"first_name\":\"Robert\",\"last_name\":\"Downey\"," +
				"\"phone_number\":\"123466589\"}";

		deserilize(jsonString);
        serilize();
	}

	public static void serilize(){
		User user = new User(1234, "Robert", "Downey", "123466589");

		// Create an ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Serialize the User object to a JSON string
			String jsonString = objectMapper.writeValueAsString(user);

			// Print the JSON string
			System.out.println("serilizer output: " +jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void deserilize(String jsonString){
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Deserialize the JSON string into a User object
			User user = objectMapper.readValue(jsonString, User.class);

			// Access and print user information
			System.out.println("User ID: " + user.getUserId());
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Phone Number: " + user.getPhoneNumber());
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
