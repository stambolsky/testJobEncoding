package com.encoding.ui.Model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GetStatusExtendedPage extends FieldWorkerPage{

    private WebElement titlePage = driver.findElement(By.xpath("//h2[.='GetStatus (extended)']"));
    private WebElement bodyResponse = driver.findElement(By.xpath("//div[@class='hub-reference-left']//span[.='response']/.."));


    public GetStatusExtendedPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(titlePage));
    }

    @Step("Check URL page GetStatus (extended)")
    public GetStatusExtendedPage checkUrlPage() {
        checkUrl("https://api.encoding.com/reference/responses-getstatus-extended");
        return this;
    }

    @Step("Check URL page GetStatus (extended)")
    public String getBodyResponse() {
        return bodyResponse.getText();
    }

}
