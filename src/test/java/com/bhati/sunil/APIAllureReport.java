package com.bhati.sunil;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APIAllureReport {
    @Test
    public void validAPI(){
        String pincode = "1";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void invalidAPI(){
        String pincode = "-1";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}
