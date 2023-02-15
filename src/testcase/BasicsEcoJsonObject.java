package testcase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;

public class BasicsEcoJsonObject {

	public static void main(String[] args) throws JSONException {
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
		System.out.println(response);
		JSONArray ar=new JSONArray(response);
		JSONObject ob = ar.getJSONObject(0);
		System.out.println(ob.length());
		Iterator<String>keys=ob.keys();
		while(keys.hasNext())
		{
			String key=keys.next();
			System.out.println(key+" "+ob.get(key));
		}
		
	
	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
