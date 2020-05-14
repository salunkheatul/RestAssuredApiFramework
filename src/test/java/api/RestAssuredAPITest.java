package test.java.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredAPITest {

    @Test(description = "RestAssuredApi Test", groups = {"api.p1", "positive"})
    public void getTest() {
        RestAssured.baseURI = "https://covidapi.info/api/v1/global/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/latest");
        JsonPath jsonPath = new JsonPath(response.body().asString());
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        System.out.println("jsonPath is =>  " + jsonPath.getJsonObject(""));
        Assert.assertTrue(jsonPath.getJsonObject("").toString().contains("IND"),"india not present");
    }
}
