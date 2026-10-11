package com.bhati.sunil;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.devtools.latest.fetch.model.AuthChallengeResponse;
import org.testng.annotations.Test;

public class NONBDDPost {
    RequestSpecification request;
    Response response;
    ValidatableResponse validatableResponse;
    @Description("Programe for the Post Request")
    @Test
    public void postAPI(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/auth");
        request.contentType(ContentType.JSON);
        request.body(payload).log().all();

        System.out.println("----------------------------");

        response = request.when().log().all().post();

        System.out.println("-----------------------------");

        validatableResponse = response.then().log().all().statusCode(200);
    }

}
