package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle)
	{
	    RestAssured.baseURI = "https://rahulshettyacademy.com";

	    Response resp =
	        given()
	            .header("Content-Type", "application/json")
	            .body(Payload.Addbook(isbn, aisle))
	        .when()
	            .post("/Library/Addbook.php")
	        .then()
	            .assertThat()
	            .statusCode(200)
	            .extract()
	            .response();

	    JsonPath js = ReuseableMethods.rawToJson(resp);

	    String id = js.getString("Msg");

	    System.out.println(id);
	}

	@DataProvider(name = "BooksData")
	public Object[][] getData()
	{
	    return new Object[][] {
	        {"asu", "8493"},
	        {"siani", "8694"},
	        {"yiss", "2321"}
	    };
	}
	
	
	
}
