package com.encoding.ui.Model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchForm extends FieldWorkerPage{

    private WebElement titleStartToSearch = driver.findElement(By.xpath("//h6[.='Start typing to search…']"));
    private WebElement searchField = driver.findElement(By.cssSelector(".Input.Input_md"));
    private String linkInSearch = "//div/span[.='%s']";


    public SearchForm(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(titleStartToSearch));
    }

    @Step("Fill in the search field - [{0}]")
    public SearchForm setFieldSearch(String value) {
        setFieldData(searchField, value);
        return this;
    }

    @Step("Follow the found link")
    public SearchForm clickLinkInSearch(String value) {
        clickElement(driver.findElement(By.xpath(String.format(linkInSearch,value))));
        return this;
    }

}
