package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	PrintStream log;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		
	if(req==null)
	{
			log = new PrintStream(new FileOutputStream("logging.txt"));
		
		 req =new  RequestSpecBuilder().setBaseUri(getGlobalValue("BaseURL")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
	}
	return req;
	}
	
	public String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("F:\\eclipse\\Rishabh_Rana\\APIautomationFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String jsonParse(Response response, String Key)
	{
		String Resp=   response.asString();
		JsonPath js = new JsonPath(Resp);
		return js.get(Key).toString();
	}
}



