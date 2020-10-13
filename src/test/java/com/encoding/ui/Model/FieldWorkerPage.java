package com.encoding.ui.Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class FieldWorkerPage extends Page{

    public FieldWorkerPage(WebDriver driver) {
        super(driver);
    }

    public void clickElement(WebElement element) {
        wait.until(elementToBeClickable(element));
        element.click();
    }

    public void setFieldData(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void checkUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url, "Url does not match");
    }

    public String getText(WebElement element) {
        return element.getText();
    }
}
