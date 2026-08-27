package apitestingf;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;



public class Bugtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://yashwanth2000510-1787742980501.atlassian.net/";
		
		String createissueresponse = given()
		.header("Content-Type","application/json")
		.header("Authorization","Basic QVRBVFQzeEZmR0YwM1VNY29SZjZUV05jTlVCSWd0TC1kcWdfcnIzOXliVHR0ZXZUOEt0TjBheVNRTzZLa29Bc1VuLWVGY3VKSXJBeFJBWDJ1NmRzOHlvSVJjcWMtd2plSWRod0JNYzZFWVl6TkhrZlo2aHEyN1lxTkV3UE82ejFRdzNuOHlULXozQ3NPQ21samJpYlhkbWRudU5qZjlyVWxwWlVxVi0tNS16M2hoY1VRWl9pcV9FPUI2M0I1MzlD")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Dropdowns are notworking.\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "")
		.log().all()
		.post("rest/api/3/issue").then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
		
		
		JsonPath js = new JsonPath(createissueresponse);
		String issueId = js.getString("id");
		System.out.println(issueId);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------");

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
