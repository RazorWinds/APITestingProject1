package Utilities;

import Pojos.Token;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtil {

    public static Response requestToken(String userName, String password) {
        RequestSpecification recSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .setBasePath("Auth/login")
                .setBody("{" +
                        "\"username\":" + "\"" + userName + "\"" + "," +
                        "\"password\":" + "\"" + password + "\"" +
                        "}")
                .setContentType(ContentType.JSON)
                .build();

        Response response = RestAssured.given(recSpec)
                .when()
                .post()
                .thenReturn();

        if (response.getStatusCode() == 200) {
            Token tokenObject = JSONSerialise.deserialize(response.getBody().asString(), Token.class);
            FeatureSharedEnv.setCachedValidToken(tokenObject.getToken());
        }
        return response;
    }

    public static RequestSpecification getCoursesSpec(String token){
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .setBasePath("api/Courses")
                .addHeader("Authorization", token)
                .build();
    }

    public static RequestSpecification getCourseByIDSpec(String token, int ID){
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .setBasePath("api/Courses/"+ID)
                .addHeader("Authorization", token)
                .build();
    }

    public static RequestSpecification getSpartanByIDSpec(String token, int ID){
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .setBasePath("api/Spartans/"+ID)
                .addHeader("Authorization", token)
                .build();
    }

    public static RequestSpecification getAllSpartansSpec(String token){
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .setBasePath("api/spartans")
                .addHeader("Authorization", token)
                .build();
    }

    public static RequestSpecification createSpartanSpec(String token, String JSON){
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .setBasePath("api/spartans")
                .addHeader("Authorization", token)
                .setBody(JSON)
                .build();
    }

    public static RequestSpecification updateSpartanSpec(String token, int ID, String JSON){
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/")
                .setBasePath("api/spartans/"+ID)
                .addHeader("Authorization", token)
                .setBody(JSON)
                .build();
    }
}
