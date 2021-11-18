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

public class BasicsEcoArticles3 {

	public static void main(String[] args) throws JSONException {
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
	//	System.out.println(response);
		JSONArray jsonArray = new JSONArray(response);
	//	System.out.println(jsonArray);
		JSONObject jsonobject = null;
		for (int i = 0; i < jsonArray.length(); i++) {
		     jsonobject = jsonArray.getJSONObject(i);
		   // System.out.println(jsonobject.getJSONArray("ecodesignArticle"));
		}
		jsonArray =jsonobject.getJSONArray("ecodesignArticle");
		for (int i = 0; i < jsonArray.length(); i++) {
		     jsonobject = jsonArray.getJSONObject(i);
		     
		    System.out.println(jsonobject);
		}
		Iterator<String>keys=jsonobject.keys();
		while(keys.hasNext())
		{
			System.out.println(keys.next());
		}
//		
//		JSONObject jsonObject = new JSONObject(response);
//		System.out.println(jsonObject);
//	//	System.out.println(js.getString("ecodesignEfficiencyArticle[0]"));
//		String id = js.getString("ecodesignEfficiencyArticle[0].entryTitle[1]");
////		
//		JSONObject jsonObject = new JSONObject();
//        Iterator<String> keys = jsonObject.keys();
//        System.out.println(keys);
//	
	
//		String ss = js.getString("ecodesignEfficiencyArticle[0][0]");
//		JSONArray jsonArray = new JSONArray(ss);
//		System.out.println(jsonArray);
//		JSONArray jsonArray = new JSONArray(response);
//		System.out.println(jsonArray);
//		for (int i = 0; i < jsonArray.length(); i++) {
//		    JSONObject jsonobject = jsonArray.getJSONObject(i);
//		    System.out.println(jsonobject);
//		    Iterator<String> keys = jsonobject.keys();
//	        System.out.println(keys);
//		}
	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
