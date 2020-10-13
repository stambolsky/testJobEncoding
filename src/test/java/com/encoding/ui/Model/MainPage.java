package com.encoding.ui.Model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends FieldWorkerPage{

    private WebElement searchButton = driver.findElement(By.cssSelector("#hub-header .search-box"));


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the search bar")
    public SearchForm openSearch() {
        clickElement(searchButton);
        return new SearchForm(driver);
    }



}
