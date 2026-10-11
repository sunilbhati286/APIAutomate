package com.bhati.sunil;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.net.ResponseCache;

public class NONBDDPrograme {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Description("This is for the non BDD Style")
    @Test
    public void validAPI(){
        String bookingID = "8";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        response = requestSpecification.when().log().all().get();
        validatableResponse = response.then().log().all().statusCode(200);

    }

}
