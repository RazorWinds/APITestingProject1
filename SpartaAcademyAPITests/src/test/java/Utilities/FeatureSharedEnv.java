package Utilities;

import io.restassured.response.Response;

public class FeatureSharedEnv {
    private static Response response;
    private static String token = "";
    private static String cachedValidToken = "";
    private static int idInUse = 1;



    public static void setResponse(Response response) {
        FeatureSharedEnv.response = response;
    }

    public static Response getResponse() {
        return response;
    }

    public static void setTokenValid() {
        if (cachedValidToken.isEmpty()){
            RestAssuredUtil.requestToken("sparta", "global");
        }
        token = cachedValidToken;
    }

    public static String getToken() {
        return token;

    }

    public static void setTokenInvalid() {
        token = "abc";
    }

    public static void setCachedValidToken(String newToken){
        cachedValidToken = "Bearer "+newToken;
    }

    public static int getIdInUse() {
        return idInUse;
    }

    public static void setIdInUse(int idInUse) {
        FeatureSharedEnv.idInUse = idInUse;
    }
}

