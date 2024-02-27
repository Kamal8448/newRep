package com.kamal.datareader.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindWebElement {

    public static WebElement getElement(WebDriver driver, String locatorType, String locatorValue){
        System.out.println(driver + locatorValue + locatorType);
        WebElement element = null;
        if(locatorType.equalsIgnoreCase("id")){
            element = driver.findElement(By.id("id"));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            element = driver.findElement(By.xpath(locatorValue));

        }
        return element;
    }

}
