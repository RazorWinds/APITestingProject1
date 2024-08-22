package StepDefs;


import Utilities.FeatureSharedEnv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeTrue;

public class SharedStepDefs {
    @Then("I should receive a {int} response code")
    public void iShouldReceiveAResponseCode(int code) {
        assertThat(FeatureSharedEnv.getResponse().getStatusCode(), is(code));
    }

    @Given("I have a valid bearer token")
    public void iHaveAValidBearerToken() {
        FeatureSharedEnv.setTokenValid();
    }

    @Given("I have no bearer token")
    public void iHaveNoBearerToken() {
        FeatureSharedEnv.setTokenInvalid();
    }

    @And("Disabled {int}")
    public void diablledTest(int issueNum){
        String strIssueNum = Integer.toString(issueNum);
        if (issueNum < 10) {
            strIssueNum = "00"+strIssueNum;
        }else if (issueNum < 100) {
            strIssueNum = "0"+strIssueNum;
        }
        assumeTrue("TEST DISABLED - ISSUE ID: "+strIssueNum, false);
    }


    @And("I use the ID {int}")
    public void iUseAValidID(int ID) {
        FeatureSharedEnv.setIdInUse(ID);
    }
}
