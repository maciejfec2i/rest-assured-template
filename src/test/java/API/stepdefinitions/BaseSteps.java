package API.stepdefinitions;

import API.requests.BaseMethods;
import io.cucumber.java.Before;
import net.thucydides.core.annotations.Steps;

public class BaseSteps {

    @Steps
    private BaseMethods baseMethods;

    @Before
    public void setUp() {
        baseMethods.setEndpoint();
    }
}
