package com.encoding.api;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class testAPI {

    String url = "https://status.encoding.com/status.php?format=";

    @Test(description = "Get JSON")
    public void testApi() {
        Response response = get(url+"json");
        JsonPath jsonPath = new JsonPath(response.asString());
        Assert.assertEquals(jsonPath.getString("status"), "Ok", "Status does not match");
        Assert.assertTrue(jsonPath.getInt("incident_count.lastMonth") < 10, "LastYear is not a valid value");
        Assert.assertTrue(jsonPath.getInt("uptime") > 86400, "Uptime must be more than a day");
    }

    @Test(description = "XML")
    public void testApi2() {
        Response response = get(url+"xml");
        XmlPath xmlPath = new XmlPath(response.andReturn().asString()).setRoot("xml");
        Assert.assertEquals(xmlPath.get("status"), "Ok", "Status does not match");
        Assert.assertTrue(xmlPath.getInt("incident_count.lastMonth") < 10, "LastYear is not a valid value");
        Assert.assertTrue(xmlPath.getInt("uptime") > 86400, "Uptime must be more than a day");
    }

}
