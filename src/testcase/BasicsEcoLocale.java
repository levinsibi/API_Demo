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

public class BasicsEcoLocale {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub

		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response
		RestAssured.baseURI= "https://edt-api-aps-dev.azurewebsites.net";
		String response=given().log().all().header("Content-Type","application/json")
		.when().get("api/v1/drives/locales")
		.then().assertThat().statusCode(200).extract().response().asString();
	
		System.out.println(response);
		//Json array response
		JSONArray jsonArray = new JSONArray(response);
	
		JSONObject jsonobject = jsonArray.getJSONObject(0);

		Iterator<String>keys=jsonobject.keys();
		while(keys.hasNext())
		{
			String k=keys.next();
			System.out.print(k+"  ");
			System.out.print(jsonobject.get(k));
			System.out.println();
		}
	

	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
