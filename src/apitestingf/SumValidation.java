package apitestingf;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumval()
	{
		int sum = 0;
		JsonPath js = new JsonPath(Payload.Courseprice());
		int count = js.getInt("courses.size()");
		
		System.out.println("6. Verify if Sum of all Course prices matches with Purchase Amount");
		
		for(int i=0;i<count;i++)
		{
			int p = js.getInt("courses["+i+"].price");
			int c =js.getInt("courses["+i+"].copies");
//			
			int t = p*c;
			System.out.println(t);
			sum = sum+t;
			
			
		}
		
		System.out.println(sum);
		int pa =  js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, pa);
		System.out.println("passed");
		
	}

}
