package com.encoding.ui;

import com.encoding.ui.Model.*;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class testUi extends TestBase {

    Navigation navigation;
    MainPage mainPage;
    SearchForm searchForm;
    GetStatusExtendedPage getStatusExtendedPage;

    @Test(description = "Ui test")
    public void test() {
        step1();
        step2();
        step3();
        step4();
        step5();
    }

    @Step("Step 1. Go to link https://api.encoding.com/")
    private void step1() {
        navigation = new Navigation(driver);
        mainPage = navigation.openMainPage();
    }

    @Step("Step 2. In the search enter 'getStatus'")
    private void step2() {
        searchForm = mainPage.openSearch();
        searchForm.setFieldSearch("getStatus");
    }

    @Step("Step 3. Follow the link 'getStatus'")
    private void step3() {
        searchForm.clickLinkInSearch("GetStatus (extended)");
        getStatusExtendedPage = new GetStatusExtendedPage(driver);
    }

    @Step("Step 4. Check url")
    private void step4() {
        getStatusExtendedPage.checkUrlPage();
    }

    @Step("Step 5. Check data in JSON tab")
    private void step5() {
        String body = getStatusExtendedPage.getBodyResponse();
        List<String> bodyFull = Arrays.asList(body.split("\n"));
        for (String s : bodyFull) {
            if (s.contains("processor")) {
                Assert.assertTrue(s.contains("AMAZON"), "Parameter 'processor' does not contain a value - AMAZON");
                Assert.assertTrue(s.contains("RACKSPACE"), "Parameter 'processor' does not contain a value - RACKSPACE");
            }
        }

        List<String> formatBlock = Arrays.asList(body.split("<format>"));
        for (String s : formatBlock.get(1).split("\n")) {
            if (s.contains("<status>")) {
                Assert.assertTrue(s.contains("Status"),"Parameter 'status' is not equal to 'Status'");
            }
        }
    }
}
