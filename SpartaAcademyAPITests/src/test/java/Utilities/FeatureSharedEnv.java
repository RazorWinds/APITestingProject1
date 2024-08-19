package Utilities;

import Pojos.Token;
import io.restassured.response.Response;

public class FeatureSharedEnv {
    private static Response response;
    private static String token = "";
    private static String cachedValidToken = "";

    public static void setResponse(Response response) {
        FeatureSharedEnv.response = response;
    }

    public static Response getResponse() {
        return response;
    }

    public static void setTokenValid() {
        if (cachedValidToken.isEmpty()){
            Token tokenObject = JSONSerialise.deserialize(response.getBody().asString(), Token.class);
            cachedValidToken = tokenObject.getToken();
        }
        token = cachedValidToken;
    }

    public static String getToken() {
        if (token.isEmpty()){
            setTokenValid();
        }
        return token;
    }

    public static void setTokenInvalid() {
        token = "";
    }

    public static void setCachedValidToken(String newToken){
        cachedValidToken = newToken;
    }
}

