package org.example.constants;
import io.restassured.RestAssured;


public class RestConfig {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    public static final String USER_AUTH = "api/auth/login";
    public static final String USER_DELETE = "api/auth/user";
    public static final String USER_CREATE = "api/auth/register";
    public static final int WAIT_TIME = 30;
    protected static void setUp() {
        RestAssured.baseURI = URL;
    }

}
