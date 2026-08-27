package pojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class serializeTest {
	
	public static void main(String[] args)
	{
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Addplace p = new Addplace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName("yashwanth");
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("beach");
		
		p.setTypes(mylist);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		Response res =  given().log().all().queryParam("key", "qaclick123")
		.body(p)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		String responseString = res.asString();
		System.out.println(responseString);
	
	
	
	
	
	
	
	}

}



























