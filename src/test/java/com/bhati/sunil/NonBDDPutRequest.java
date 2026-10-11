package com.bhati.sunil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDPutRequest {
    RequestSpecification request;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void putRequestAPI(){

        String token = "b18f73837f7b354"; // Adding the Static token
        String id = "2206";
        String payLoad = "{\n" +
                "    \"firstname\" : \"Hinal\",\n" +
                "    \"lastname\" : \"Bhati\",\n" +
                "    \"totalprice\" : 115,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        request = RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/"+id);
        request.contentType(ContentType.JSON);
        request.cookies("token" , token);
        request.body(payLoad);

        response = request.when().log().all().put();

        validatableResponse = response.then().log().all().statusCode(200);
    }
}
