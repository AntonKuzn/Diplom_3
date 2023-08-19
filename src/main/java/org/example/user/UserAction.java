package org.example.user;

import io.qameta.allure.Step;
import org.example.constants.RestConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserAction extends RestConfig {

    @Step("Удаление пользователя (DELETE /api/auth/user)")
    public static Response deleteUser(String accessToken) {
        setUp();
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(RestConfig.USER_DELETE);
    }

    @Step("Авторизация пользователя (POST /api/auth/login)")
    public static Response loginUser(User user) {
        setUp();
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(RestConfig.USER_AUTH);
    }

    @Step("Создание пользователя POST /api/auth/register")
    public static Response createUser(User user) {
        setUp();
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(RestConfig.USER_CREATE);
    }
}
