package com.phonebook.testsRA;

import com.phonbook.dto.AuthRequestDto;
import com.phonbook.dto.AuthResponseDto;
import com.phonbook.dto.ErrorDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends TestBase {

    AuthRequestDto auth = AuthRequestDto.builder()
            .username("qwerty007$@gmail.com")
            .password("Qwerty007$")
            .build();

    //
    @Test
    public void loginSuccessTest() {

        AuthResponseDto dto = given()
                .body(auth)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println(dto.getToken());

    }

    //
    @Test
    public void loginSuccessTest2() {

        String responseToken = given()
                .body(auth)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("token"))
                .extract().path("token");
        System.out.println(responseToken);
    }


/*    @Test
    public void loginWithWrongEmail() {
        ErrorDto errorDto = given().body(AuthRequestDto.builder()
                        .username("qwerty007$gmail.com")
                        .password("Qwerty007$")
                        .build())
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
        System.out.println(errorDto.getError());
        }*/

    @Test
    public void loginWithWrongEmail() {
        given().body(AuthRequestDto.builder()
                        .username("qwerty007$gmail.com")
                        .password("Qwerty007$")
                        .build())
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("message", equalTo("Login or Password incorrect"));
//              .extract().response().as(ErrorDto.class);
    }



}//class
