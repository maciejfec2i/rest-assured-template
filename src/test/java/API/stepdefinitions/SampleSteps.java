package API.stepdefinitions;

import API.models.Job;
import API.requests.PostmanJobsApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.mapper.ObjectMapperType;
import net.thucydides.core.annotations.Steps;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SampleSteps {

    @Steps
    private PostmanJobsApi postmanJobsApi;

    @Given("I send a GET request")
    public void i_send_a_get_request() {
        postmanJobsApi.get();
    }

    @And("I should get {int} status code back")
    public void i_should_get_status_code_back(Integer statusCode) {
        int responseStatusCode = postmanJobsApi.getResponseStatusCode();
        assertThat("Invalid status code. Expected " + statusCode + " but received " + responseStatusCode + ".", responseStatusCode == statusCode);
    }

    @Then("I should see more than {int} job")
    public void i_should_see_more_than_job(Integer numOfJobs) {
        List<Job> response = Arrays.asList(postmanJobsApi.getResponse().as(Job[].class, ObjectMapperType.GSON));
        assertThat("Expected more than " + numOfJobs + " but only got " + response.size(), response.size() > numOfJobs);
    }

    @Given("I send a GET request for a single job")
    public void i_send_a_get_request_for_a_single_job() {
        postmanJobsApi.get();
        List<Job> response = Arrays.asList(postmanJobsApi.getResponse().as(Job[].class, ObjectMapperType.GSON));
        String jobId = response.get(0).getId();
        postmanJobsApi.get(jobId);
    }
    @Then("I should see the job details")
    public void i_should_see_the_job_details() {
        Job job = postmanJobsApi.getResponse().as(Job.class, ObjectMapperType.GSON);
        assertThat("Couldn't get job", job.toString(), containsString("title"));
    }
}
