package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.ExtentReporterInit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import specs.AlertsPageXpath;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AlertsPage implements AlertsPageXpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;
    public ExtentReporterInit reporter = null;


    public AlertsPage(BaseSession session) {
        this.baseSession = session;
        this.driver = session.driver;
        reporter = TestNgHooks.extentReporterInit;
    }

    public void performAlerts() throws Exception {
        // handling Alerts with OK//
        driver.findElement(okButton).click();
        Thread.sleep(2000);
        //Handling Ok button Alert popup//
        Alert alerts = driver.switchTo().alert();
        Thread.sleep(2000);
        alerts.accept(); // clicking on Ok button in Alert popup with accept();//
        LOGGER.log(Level.INFO, "clicked on OK Button : ");
        reporter.test.pass("clicked on OK Button : ",
               MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());


        //Handling OK and cancel Alerts//
        driver.findElement(okAndCancel).click();
        driver.findElement(By.id("CancelTab")).click();
        alerts = driver.switchTo().alert();
        Thread.sleep(5000);
        alerts.accept();
        LOGGER.log(Level.INFO, "Click OK button: ");
        reporter.test.pass("Click OK button : ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        String text1 = driver.findElement(By.id("demo")).getText();
        System.out.println("Verify the text after clicking OK button: " + text1);
        driver.findElement(By.id("CancelTab")).click();
        alerts = driver.switchTo().alert();
        Thread.sleep(5000);
        alerts.dismiss();
        LOGGER.log(Level.INFO, "Click on Cancel Button : ");
        reporter.test.pass("Click on Cancel Button  : ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        String text2 = driver.findElement(By.id("demo")).getText();
        System.out.println("Verify the text after clicking Cancel button: " + text2);

        //Handling Alerts with Text//
        driver.findElement(alertWithText).click();
        driver.findElement(By.id("Textbox")).click();
        alerts = driver.switchTo().alert();
        Thread.sleep(5000);
        String text3 = alerts.getText();
        System.out.println("The Alerts with Text Tab clicked" + text3);
        alerts.sendKeys("Selenium Automation Testing");
        alerts.accept();
        LOGGER.log(Level.INFO, "Click on Ok Button : ");
        reporter.test.pass("Click on Ok Button  : ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        String text4 = driver.findElement(By.id("demo1")).getText();
        System.out.println("Verify the text after clicking Ok : " + text4);
        driver.findElement(By.id("Textbox")).click();
        alerts = driver.switchTo().alert();
        Thread.sleep(5000);
        alerts.dismiss();
        LOGGER.log(Level.INFO, "Click on Cancel Button : ");
        reporter.test.pass("Click on Cancel Button  : ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        String text5 = driver.findElement(By.id("demo1")).getText();
        System.out.println("Verify the text after clicking Cancel button: " + text5);




    }
}


