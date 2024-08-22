package StepDefs;

import Pojos.Course;
import Pojos.Spartan;
import Utilities.FeatureSharedEnv;
import Utilities.JSONSerialise;
import Utilities.RestAssuredUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpartanByIDStepDef {


   @When("I request a Spartan")
    public void iRequestASpartan(){
       FeatureSharedEnv.setResponse(
               RestAssured.given(
                               RestAssuredUtil.getSpartanByIDSpec(FeatureSharedEnv.getToken(), FeatureSharedEnv.getIdInUse())
                       )
                       .get()
                       .thenReturn()
       );
   }

    @Then("The response should include the correct Spartan details")
    public void theResponseShouldIncludeTheCorrectSpartanDetails() {
        Spartan spartan = JSONSerialise.deserialize(FeatureSharedEnv.getResponse().getBody().asString(), Spartan.class);
        assertThat(spartan.getId(), is(1));
    }
}
