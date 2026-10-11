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

        String token = "5ec3273bc1f7f4f";
        String id = "2206";
        request = RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/"+id);
        request.contentType(ContentType.JSON);
        request.cookies("token" , token);

        response = request.when().log().all().put();

        validatableResponse = response.then().log().all().statusCode(404);
    }
}
