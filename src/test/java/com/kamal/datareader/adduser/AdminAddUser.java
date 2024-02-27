package com.kamal.datareader.adduser;

import com.kamal.datareader.PropertyDataReader;
import com.kamal.datareader.execution.BrowserFactory;
import com.kamal.datareader.webelements.FindWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.time.Duration;

public class AdminAddUser {
  // WebDriver driver = null;
    public static void  add_user(WebDriver driver) {
        WebElement user_role_locator;
        try {

            String admin = PropertyDataReader.read_Data("webelements.properties", "Admin");
            String admin_locator_Type = admin.substring(0, admin.indexOf("_"));
            String admin_locator_value = admin.substring(admin.indexOf("_") + 1);
            WebElement admin_locator = FindWebElement.getElement(driver, admin_locator_Type, admin_locator_value);
            admin_locator.click();
            // click on ADD button
            String add = PropertyDataReader.read_Data("webelements.properties", "Add");
            String add_locator_Type = add.substring(0, admin.indexOf("_"));
            String add_locator_value = add.substring(admin.indexOf("_") + 1);
            WebElement add_locator = FindWebElement.getElement(driver, add_locator_Type, add_locator_value);
            add_locator.click();
            //Choose User role
            String userRole = PropertyDataReader.read_Data("webelements.properties", "user_role");
            String user_role_locator_type = userRole.substring(0, userRole.indexOf("_"));
            String user_role_locator_value = userRole.substring(userRole.indexOf("_") + 1);
            user_role_locator = FindWebElement.getElement(driver, user_role_locator_type, user_role_locator_value);
            user_role_locator.click();
            //mouse actions to select from user role
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            //enter employee name
            String employeeName = PropertyDataReader.read_Data("webelements.properties", "Employee_name");
            String employee_name_locator_type = employeeName.substring(0, employeeName.indexOf("_"));
            String employee_name_locator_value = employeeName.substring(employeeName.indexOf("_") + 1);
            WebElement employee_name_locator = FindWebElement.getElement(driver, employee_name_locator_type, employee_name_locator_value);
            employee_name_locator.sendKeys("Virat Kohli");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Robot rbt = new Robot();
                rbt.keyPress(KeyEvent.VK_DOWN);
                rbt.keyRelease(KeyEvent.VK_DOWN);
                rbt.keyPress(KeyEvent.VK_ENTER);
                rbt.keyRelease(KeyEvent.VK_ENTER);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // for status
        By status_locator =  By.xpath("//div[@tabindex=0]");
        FluentWait<WebDriver> fw = new WebDriverWait(driver, Duration.ofSeconds(120));
        fw.pollingEvery(Duration.ofSeconds(5));
        fw.until(ExpectedConditions.numberOfElementsToBe(status_locator,2));
        WebElement status_element_locator = driver.findElement(status_locator);
        status_element_locator.click();

        try {
            Robot rb = new Robot();
            rb.keyPress(KeyEvent.VK_DOWN);
            rb.keyRelease(KeyEvent.VK_DOWN);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


    }
}
