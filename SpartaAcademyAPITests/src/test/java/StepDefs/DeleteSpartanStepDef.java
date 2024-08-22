package StepDefs;

import Utilities.FeatureSharedEnv;
import Utilities.RestAssuredUtil;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class DeleteSpartanStepDef {
    @When("I make a delete request to the Spartan endpoint")
    public void iMakeADeleteRequestToTheSpartanEndpoint() {
        FeatureSharedEnv.setResponse(
                RestAssured
                        .given(
                        RestAssuredUtil.getSpartanByIDSpec(FeatureSharedEnv.getToken(), FeatureSharedEnv.getIdInUse())
                )
                        .delete()
                        .thenReturn()
        );
    }
}
