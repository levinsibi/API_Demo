package testcase;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider = "BooksData")

	public void addBook(String isbn, String aisle)

	{

		RestAssured.baseURI = "http://216.10.245.166";

		String resp = given().

				header("Content-Type", "application/json").

				body(payload.Addbook(isbn, aisle)).

				when().

				post("/Library/Addbook.php").

				then().assertThat().statusCode(200).

				extract().response().asString();

		JsonPath js = ReUsableMethods.rawToJson(resp);

		String id = js.getString("ID");

		System.out.println(id);

		// deleteBOok

	}

	@DataProvider(name = "BooksData")
	public Object[][] getdata() {

		return new Object[][] { { "asdfza", "4467" }, { "asdfzb", "4469" }, { "asdfzc", "4468" } };
	}

}