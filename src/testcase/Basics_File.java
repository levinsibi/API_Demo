package testcase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;

public class Basics_File {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
// validate if Add Place API is workimg as expected 
		//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
		
		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response

		
		RestAssured.baseURI = "http://216.10.245.166";

		String resp = given().

				header("Content-Type", "application/json").

				body(new String(Files.readAllBytes(Paths.get(".//json//payload.json")))).

				when().

				post("/Library/Addbook.php").

				then().assertThat().statusCode(200).

				extract().response().asString();

		JsonPath js = ReUsableMethods.rawToJson(resp);

		String id = js.getString("ID");

		System.out.println(id);
		
	}

}
