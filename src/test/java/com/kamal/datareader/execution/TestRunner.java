package com.kamal.datareader.execution;

import com.kamal.datareader.PropertyDataReader;
//import com.kamal.datareader.webelements.FindWebElement;
import com.kamal.datareader.adduser.AdminAddUser;
import com.kamal.datareader.webelements.FindWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestRunner {
    public WebDriver driver = null;

    @Test
    public void execute_script() {

        try {
            String browser_name = PropertyDataReader.read_Data("config.properties", "browser_name");
            driver = BrowserFactory.getDriver(browser_name);// opening browser

            String url = PropertyDataReader.read_Data("config.properties", "url");
            BrowserFactory.openUrl(url);// opening URL
            System.out.println("Driver value after opening URL: "+driver);
          //  BrowserFactory.closeBrowser();
            //Find and locate UserName
            String Username_locator_type_value =
                    PropertyDataReader.read_Data("webelements.properties","user_name");
            String userName_locatorType =
                    Username_locator_type_value.substring(0,Username_locator_type_value.indexOf("_"));
            String userName_locatorValue =
                    Username_locator_type_value.substring(Username_locator_type_value.indexOf("_")+1);
            System.out.println(driver);
           // System.out.println(userName_locatorType +"\t" + userName_locatorValue);
          //  WebElement user_Name = FindWebElement.getElement(driver,userName_locatorType, userName_locatorValue);
            WebElement user_Name = FindWebElement.getElement(driver, userName_locatorType, userName_locatorValue);

            user_Name.sendKeys("Admin");

            //Find and locate Password
            String password_locator_type_value=
                    PropertyDataReader.read_Data("webelements.properties", "password");
            String password_locatorType=
                    password_locator_type_value.substring(0,password_locator_type_value.indexOf("_"));
            String password_locatorValue=
                    password_locator_type_value.substring(password_locator_type_value.indexOf("_")+1);
            WebElement password= FindWebElement.getElement(driver,password_locatorType,password_locatorValue);
            password.sendKeys("admin123");

            //Login functionality
            String login_locator_type_value=
                    PropertyDataReader.read_Data("webelements.properties","LOGIN");
            String login_locatorType=
                    login_locator_type_value.substring(0,login_locator_type_value.indexOf("_"));
            String login_locatorValue=
                    login_locator_type_value.substring(login_locator_type_value.indexOf("_")+1);
            WebElement login =FindWebElement.getElement(driver,login_locatorType,login_locatorValue);
            login.click();

            String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
            String actualURL = driver.getCurrentUrl();

            Assert.assertEquals(expectedURL,actualURL);


            AdminAddUser.add_user(driver);
            BrowserFactory.closeBrowser();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}

