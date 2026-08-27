package clientCrendentialsOAuth;

import static  io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import pojo.GetCourse;
import pojo.WebAutomation;
import pojo.api;

public class oAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ctlt = {"Selenium Webdriver Java","Cypress","Protractor"};
		
		String response = given()
		.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParams("grant_type","client_credentials")
		.formParams("scope","trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		
		System.out.println(response);
		
		
		JsonPath js = new JsonPath(response);
		String acesstoken = js.getString("access_token");
		
		
		 GetCourse gc = given().queryParams("access_token", acesstoken)
		.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
		 
		 System.out.println(gc.toString());
		 
		  System.out.println(gc.getLinkedIn()); 
		  System.out.println(gc.getInstructor());
		  System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		  
		  
		  List<api> apicourses = gc.getCourses().getApi();
		  for (int i=0;i<apicourses.size();i++)
		  {
			  if(apicourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					  {
				  			System.out.println(apicourses.get(i).getPrice()); 
					  }
		  }
		  
		   System.out.println(gc.getCourses().getWebAutomation().get(0).getCourseTitle()); 
		  
		   
		   ArrayList<String> a = new ArrayList<String>();
		   
		   List<WebAutomation> wcs = gc.getCourses().getWebAutomation();
		   
		   
		   
		   for(int j=0;j<wcs.size();j++)
		   {
			   a.add(wcs.get(j).getCourseTitle());
			  
		   }
		  
		   List<String> exptttl = Arrays.asList(ctlt);
		   
		  Assert.assertTrue(a.equals(exptttl));  
		  
		    
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

		
		
	}

}
