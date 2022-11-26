package API.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.rest.SerenityRest.*;

public class BaseMethods {

    private EnvironmentVariables environmentVariables;

    @Step
    public void setEndpoint() {
        String propertyName = "baseURL.endpoint";
        RestAssured.baseURI = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(propertyName);
    }

    @Step
    public Response getResponse() {
        return then().extract().response();
    }

    @Step
    public String getResponseBody() {
        return then().extract().response().asString();
    }

    @Step
    public int getResponseStatusCode() {
        return then().extract().statusCode();
    }
}
