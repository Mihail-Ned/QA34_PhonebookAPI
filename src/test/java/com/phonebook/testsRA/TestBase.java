package com.phonebook.testsRA;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoicXdlcnR5MDA3JEBnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTcxNDYzODgxNSwiaWF0IjoxNzE0MDM4ODE1fQ.Ddkf2WLVgxeWV2s5BiUEh_-CxgBiL5usBcmuJybS2ko";
    public static final String AUTH = "Authorization";

    @BeforeMethod
    public void init() {

        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }

}
