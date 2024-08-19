package StepDefs;

import Pojos.Token;
import Utilities.FeatureSharedEnv;
import Utilities.JSONSerialise;
import Utilities.RestAssuredUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDef {
    private String userName;
    private String password;


    @Given("I use the correct login details")
    public void iUseTheCorrectLoginDetails() {
        userName = "sparta";
        password = "global";
    }

    @When("I send a login request")
    public void iSendALoginRequest() {
        FeatureSharedEnv.setResponse(RestAssuredUtil.requestToken(userName, password));
    }

    @Then("I should receive a auth token")
    public void iShouldReceiveAAuthToken() {
        JSONSerialise.deserialize(FeatureSharedEnv.getResponse().getBody().asString(), Token.class);
    }

    @Given("I use a valid username but invalid password")
    public void iUseAValidUsernameButInvalidPassword() {
        userName = "sparta";
        password = "Global";
    }

    @Given("I use invalid login details")
    public void iUseInvalidLoginDetails() {
        userName = "notAUser";
        password = "abc";
    }
}
