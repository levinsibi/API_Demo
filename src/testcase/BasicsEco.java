package testcase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;

public class BasicsEco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// validate if Add Place API is workimg as expected 
		//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
		
		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response
		RestAssured.baseURI= "https://edt-api-aps-dev.azurewebsites.net";
		String response=given().log().all().header("Content-Type","application/json")
		.when().get("api/v1/drives/locales")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(response);

		String id = js.getString("name");

		System.out.println(id);
		
		System.out.println(response);
		
	
	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
