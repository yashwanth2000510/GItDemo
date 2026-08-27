package pojo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class EcommerceAPItest {
	
	public static void main(String[] args)
	{
		
		 RequestSpecification  req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.setContentType(ContentType.JSON).build();
		 
		 LoginReq loginrequest = new LoginReq();
		 loginrequest.setUserEmail("yashwanth2000510@gmail.com");
		 loginrequest.setUserPassword("2000Yash@510");
		 
		 RequestSpecification reqLogin =  given().log().all().spec(req).body(loginrequest);
		 
		 LoginRes reslogin =    reqLogin.when().post("/api/ecom/auth/login")
		 .then().log().all().extract().response().as(LoginRes.class);
		 
		System.out.println(reslogin.getToken());
		String token = reslogin.getToken();
		System.out.println(reslogin.getUserId());
		String userId = reslogin.getUserId();
		
		
		//ADD product
		RequestSpecification  addproductbasereq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization",token ).build();
		
		RequestSpecification addproductreq =   given().log().all().spec(addproductbasereq)
		.param("productName", "Boxing Gloves")
		.param("productAddedBy", userId )
		.param("productCategory", "fashion")
		.param("productSubCategory","shirts")
		.param("productPrice","1150000")
		.param("productDescription", "EverLast")
		.param("productFor", "men")
		.multiPart("productImage", new File("C:\\Users\\ASUS\\Downloads\\fotor-20250617171334.jpg"));
		
		 String addProductresponse =   addproductreq.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().response().asString();
		
		 JsonPath js = new JsonPath(addProductresponse);
		 String productId = js.getString("productId");
		 System.out.println(productId);
		
		 
		 // CReate order
		
		 RequestSpecification  createOrderbaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.addHeader("Authorization",token ).setContentType(ContentType.JSON).build();
		 
		 	OrderDetails orddtls = new OrderDetails();
		 	orddtls.setCountry("British Indian Ocean Territory");
		 	orddtls.setProductOrderedId(productId);
		 	
		 	List<OrderDetails> orddtlsList = new ArrayList<OrderDetails>();
		 	orddtlsList.add(orddtls);
		 	
		 	Orders ord = new Orders();
		 	ord.setOrders(orddtlsList);
		 
		 
		    RequestSpecification createOrderREQ =  given().log().all().spec(createOrderbaseReq).body(ord);
		    
		    String responseADdOrder =   createOrderREQ.when().post("/api/ecom/order/create-order")
		    								.then().log().all().extract().response().asString();  
		  
		    System.out.println(responseADdOrder);
		    
		    // Delete product
		    RequestSpecification  delteOrderbaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.addHeader("Authorization",token ).setContentType(ContentType.JSON).build();
		    
		    RequestSpecification dltord =   given().log().all().spec(delteOrderbaseReq).pathParam("productId", productId);
		
		    String dltresponse =  dltord.when().delete("/api/ecom/product/delete-product/{productId}")
		    .then().log().all().extract().response().asString();
		    
		    JsonPath dltjs = new JsonPath(dltresponse);
		    
		    Assert.assertEquals("Product Deleted Successfully", dltjs.get("message"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
