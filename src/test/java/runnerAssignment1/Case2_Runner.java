package runnerAssignment1;

import baseInit.TestNgHooks;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.AlertsPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Case2_Runner {

    TestNgHooks testNgHooks = null;
    AlertsPage alertsPage = null;

    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Alerts");
        params.put("reportTestName", "Alerts");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", "http://demo.automationtesting.in/Alerts.html");
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.alertsPage = testNgHooks.alertsPage;
    }

    @Test
    public void caseTest1() throws IOException {
        alertsPage.perfromAlerts();
    }

    @AfterMethod
    public void after(ITestResult result) {

        testNgHooks.after(result);
    }
}
