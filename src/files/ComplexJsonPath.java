package files;

import io.restassured.path.json.JsonPath;

public class ComplexJsonPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(Payload.Courseprice());
		
		//1. Print No of courses returned by API
		
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//2.Print Purchase Amount
		int ttlamt  = js.getInt("dashboard.purchaseAmount");
		System.out.println(ttlamt);
		
		
		//3. Print Title of the first course
		String titlefirstcourse = js.get("courses[0].title");
		System.out.println(titlefirstcourse);
		
//		4. Print All course titles and their respective Prices
		for(int i=0;i<count;i++)
		{
			String cttl = js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			System.out.println(cttl);
		}
		
		System.out.println("Print no of copies sold by RPA Course"); 
		for(int i=0;i<count;i++)
		{
			String cttl = js.get("courses["+i+"].title");
		    if(cttl.equalsIgnoreCase("RPA"))
		    {
		    	//cpoies sold
		    	int cpoycount = js.get("courses["+i+"].copies");
		    	System.out.println(cpoycount);
		    	break;
		    
		    }
		}
		
		
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
	}

}
