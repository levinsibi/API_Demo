package testcase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;

public class BasicsEcoArticles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// validate if Add Place API is workimg as expected 
		//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
		
		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response
		RestAssured.baseURI= "https://edt-api-aps-dev.azurewebsites.net";
		String response=given().log().all().header("Content-Type","application/json")
		.when().get("api/v1/drives/articles?locale=en-US")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(response);
		

		String id = js.getString("ecodesignEfficiencyArticle[0].entryTitle[1]");
//
		System.out.println(id);
		
		System.out.println(response);
		
		int count=	js.getInt("ecodesignEfficiencyArticle[0].size()");
		System.out.println(count);
		count=	js.getInt("ecodesignArticle[0].size()");
		System.out.println(count);
		for(int i=0;i<4;i++) {
			System.out.println(js.getString("ecodesignArticle[0].entryTitle["+i+"]"));
		}
	
	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
