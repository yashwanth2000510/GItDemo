package apitestingf;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.Payload;
import files.ReuseableMethods;

public class basics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Add place-->update place with new address --> get place to validate if new address is present in the response
		
		//validate add place api is working
		//given - all the input details - 
		// when - submit the api - resource, http method
		//then  - validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response =  given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\ASUS\\eclipse-workspace\\apitestingf\\jsonfiles\\booksDta.json"))))
		.when().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		System.out.println("---------------------------hhhhhhh-------------------------------------------");
		System.out.println("----------------------------yyyyyyyyyyyy------------------------------------------");
		JsonPath js = new JsonPath(response);// to parse json
		String placeid = js.getString("place_id");
		
		System.out.println(placeid);
		System.out.println("yashwanthh    -                      -------------------------");
		System.out.println("god help me pass this interview");
		
//		// update place
//		String newAdress = "Summer walk, Africa";
//		
//		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
//		.body("{\r\n"
//				+ "\"place_id\":\""+placeid+"\",\r\n"
//				+ "\"address\":\""+newAdress+"\",\r\n"
//				+ "\"key\":\"qaclick123\"\r\n"
//				+ "}\r\n"
//				+ "")
//		.when().put("maps/api/place/update/json")
//		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
//		
//		
//		//Get place
//		
//		Response getResponse = given().log().all().queryParam("key", "qaclick123")
//		.queryParam("place_id", placeid)
//		.when().get("maps/api/place/get/json")
//		.then().assertThat().log().all().statusCode(200).extract().response();
//		
//		
//		JsonPath js1 =   ReuseableMethods.rawToJson(getResponse);
//		String actualaddress = js1.getString("address");		
//		System.out.println(actualaddress);
//		//Cucumber Junit, TestNG
//		Assert.assertEquals(actualaddress, newAdress);
//		
//		
//		
//		
//		
//		
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
