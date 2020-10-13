package com.encoding.ui.Model;

import org.openqa.selenium.WebDriver;

public class Navigation extends FieldWorkerPage{

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public MainPage openMainPage() {
        driver.get("https://api.encoding.com/");
        return new MainPage(driver);
    }
}
