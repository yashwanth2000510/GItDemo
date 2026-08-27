package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReuseableMethods {

	public static JsonPath rawToJson(Response response)
	{
		JsonPath js1 = new JsonPath(response.asString());
		return js1;
	}

	

	
	
	
}

