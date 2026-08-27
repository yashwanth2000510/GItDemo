package pojo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SpecBuilderTest {
	
	public static void main(String[] args)
	{
		
		
		
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
		
		 ResponseSpecification resspec =  new ResponseSpecBuilder().expectStatusCode(200)
		.expectContentType(ContentType.JSON).build();
		
		 RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		RequestSpecification res =  given().spec(req)
		.body(p);
		
		Response rsponse =    res.when().post("/maps/api/place/add/json")
		.then().spec(resspec).extract().response();
		
		String responseString = rsponse.asString();
		System.out.println(responseString);
	
	
	
	
	
	
	
	}

}



























