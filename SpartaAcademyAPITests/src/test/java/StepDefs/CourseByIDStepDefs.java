package StepDefs;

import Utilities.FeatureSharedEnv;
import Utilities.JSONSerialise;
import Utilities.RestAssuredUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import Pojos.Course;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CourseByIDStepDefs {
    private int currentID = 0;

    @And("I use a valid ID")
    public void iUseAValidID() {
        currentID = 1;
    }

    @When("I request a course")
    public void iRequestACourse() {
        FeatureSharedEnv.setResponse(
                RestAssured.given(
                        RestAssuredUtil.getCourseByIDSpec(FeatureSharedEnv.getToken(), currentID)
                )
                        .get()
                        .thenReturn()
        );
    }

    @Then("The response should include the correct course details")
    public void theResponseShouldIncludeTheCorrectCourseDetails() {
        System.out.println(FeatureSharedEnv.getResponse().getBody().asString());
        Course course = JSONSerialise.deserialize(FeatureSharedEnv.getResponse().getBody().asString(), Course.class);
        assertThat(course.getId(), is(1));
    }



    @And("I use an invalid ID")
    public void iUseAnInvalidID() {
        currentID = 10000;
    }

}
