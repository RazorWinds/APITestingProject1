package StepDefs;


import Utilities.FeatureSharedEnv;
import Utilities.RestAssuredUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static org.junit.Assume.assumeFalse;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeTrue;

public class ListCoursesStepDef {



    @When("I request all courses")
    public void iRequestAllCourses() {
        FeatureSharedEnv.setResponse(RestAssured.given(RestAssuredUtil.getCoursesSpec(FeatureSharedEnv.getToken()))
                .get()
                .thenReturn());
    }

    @Then("The response should include a JSON array containing multiple courses")
    public void theResponseShouldIncludeAJSONArrayContainingMultipleCourses() {
        ArrayList<String> courses = FeatureSharedEnv.getResponse().jsonPath().get("");
        assertThat(courses.size(), greaterThan(1));
    }


}
