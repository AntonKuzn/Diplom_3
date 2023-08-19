package org.example.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.example.constants.RestConfig.WAIT_TIME;

public class BrowsConst {
    protected static WebDriver driver;

    public BrowsConst(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibility(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME))
                .until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }}
