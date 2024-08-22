package StepDefs;

import Utilities.FeatureSharedEnv;
import Utilities.JSONSerialise;
import Utilities.RestAssuredUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class UpdateSpartanStepDef {
    private String spartanJSON = "";

    @And("I have a valid JSON object with all the updated Spartans details")
    public void iHaveAValidJSONObjectWithAllTheUpdatedSpartansDetails() {
        spartanJSON = JSONSerialise.getRawJSON("SpartanSerialiseTest");
    }

    @When("I make a put request to Spartan")
    public void iMakeAPutRequestToSpartan() {
        FeatureSharedEnv.setResponse(
                RestAssured.given(
                        RestAssuredUtil.updateSpartanSpec(FeatureSharedEnv.getToken(), FeatureSharedEnv.getIdInUse(), spartanJSON)
                )
                        .put()
                        .thenReturn()
        );
    }
}
