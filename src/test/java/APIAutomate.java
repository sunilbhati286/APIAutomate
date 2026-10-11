import io.restassured.RestAssured;

public class APIAutomate {
    public static void main(String[] args) {
        String pincode = "1";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);


       /* pincode = "-1";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);
*/

        pincode = "8";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);





    }
}
