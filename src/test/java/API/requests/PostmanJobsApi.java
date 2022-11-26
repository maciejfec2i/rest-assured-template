package API.requests;

import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.*;

public class PostmanJobsApi extends BaseMethods {

    private final String contentType;
    private final String endpoint;

    public PostmanJobsApi() {
        this.contentType = "application/json";
        this.endpoint = "jobs";
    }

    @Step
    public void get() {
        given()
                .contentType(this.contentType)
                .get("/" + endpoint);
    }

    @Step
    public void get(String jobId) {
        given()
                .contentType(this.contentType)
                .get("/" + endpoint + "/" + jobId);
    }
}
