package StepDefs;

import Utilities.FeatureSharedEnv;
import Utilities.JSONSerialise;
import Utilities.RestAssuredUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;


public class CreateSpartanStepDef {
    private String spartanJSON = "";

    @And("I have a valid JSON object with all the Spartans details")
    public void iHaveAValidJSONObjectWithAllTheSpartansDetails() {
        spartanJSON = JSONSerialise.getRawJSON("SpartanSerialiseTest");
    }

    @When("I make a post request to Spartan")
    public void iMakeAPostRequestToSpartan() {
        FeatureSharedEnv.setResponse(
                RestAssured.given(
                        RestAssuredUtil.createSpartanSpec(FeatureSharedEnv.getToken(), spartanJSON)
                        )
                .post()
                .thenReturn()
        );
    }


}
