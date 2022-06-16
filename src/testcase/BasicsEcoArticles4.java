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

public class BasicsEcoArticles4 {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub

		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response
		RestAssured.baseURI= "https://edt-api-aps-dev.azurewebsites.net";
		String response=given().log().all().header("Content-Type","application/json")
		.when().get("api/v1/drives/articles?locale=en-US")
		.then().assertThat().statusCode(200).extract().response().asString();
	
		//Json array response
		JSONArray jsonArray = new JSONArray(response);
	
		System.out.println(jsonArray.length());
		JSONObject jsonobject = null;
		for (int i = 0; i < jsonArray.length(); i++) {
		     jsonobject = jsonArray.getJSONObject(i);
		   // System.out.println(jsonobject.getJSONArray("ecodesignArticle"));
		}
		jsonArray =jsonobject.getJSONArray("ecodesignArticle");
		System.out.println("ecodesignArticle length is "+jsonArray.length());
		for (int i = 0; i < jsonArray.length(); i++) {
		     jsonobject = jsonArray.getJSONObject(i);
		     
		    System.out.println(jsonobject);
		}
		Iterator<String>keys=jsonobject.keys();
		while(keys.hasNext())
		{
			String k=keys.next();
			
			System.out.print(k+"  ");
			System.out.print(jsonobject.get(k));
			if(jsonobject.get(k) instanceof JSONObject)
			{
				System.out.println("");
				System.out.println("---Start of child object----");
				System.out.println(k+" is json object");
				JSONObject jsonchild=(JSONObject) jsonobject.get(k);
				Iterator<String>childKeys=jsonchild.keys();
				while(childKeys.hasNext()) {
					String k1=childKeys.next();
					System.out.print(k1+"  ");
					System.out.print(jsonchild.get(k1));
					System.out.println("");
				}
				
				
				
				System.out.println("---End of child object----");
				
				
			}
			
			System.out.println();
		}
	

	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
