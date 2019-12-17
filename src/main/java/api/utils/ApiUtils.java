package api.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    public static Response doGetResponseFromApi(String uri) {
        return RestAssured.get(uri);
    }
}