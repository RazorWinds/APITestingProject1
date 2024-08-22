package StepDefs;

import Utilities.FeatureSharedEnv;
import Utilities.RestAssuredUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class ListAllSpartansStepDef {
    @When("I request all Spartans")
    public void iRequestAllSpartans() {
        FeatureSharedEnv.setResponse(RestAssured.given(
                                RestAssuredUtil.getAllSpartansSpec(FeatureSharedEnv.getToken())
                        )
                        .get()
                        .thenReturn()
        );
    }

    @Then("The response should include a JSON array containing multiple Spartans")
    public void theResponseShouldIncludeAJSONArrayContainingMultipleSpartans() {
        System.out.println(FeatureSharedEnv.getResponse().getStatusCode());
        ArrayList<String> spartans = FeatureSharedEnv.getResponse().jsonPath().get("");
        assertThat(spartans.size(), greaterThan(1));
    }
}
