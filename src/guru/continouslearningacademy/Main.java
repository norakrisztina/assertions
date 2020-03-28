/**
 * @author Claudiu Gura ( http://ContinuousLearningAcademy.guru )
 *
 * @source code specific for Selenium: Easy Guide to Automated Functional Testing Dev  course
 * @date 2017-2018
 */


package guru.continouslearningacademy;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class Main {

    public static void main(String[] args) {

        //webdriver setup
        System.setProperty("webdriver.ie.driver", "C:\\automation\\drivers\\IEDriverServer.exe");
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setVersion("11"); // For Internet Explorer 11
        WebDriver driverie = new InternetExplorerDriver(ieCapabilities);
        driverie.manage().window().maximize();
        //URL of the web page
        driverie.get("http://www.continuouslearningacademy.guru/resources/2/website/");

        //wait 1.5s for the web page to load
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //check if the web page title is OK
        try {
            Assert.assertEquals("[DEMO website] Real Functional Testing Automation Project with Selenium", driverie.getTitle());
        }
        catch (AssertionError ase)
        {
            System.out.println("[Test FAIL]. Page title is different than the expected one!");

        }

        try {
            WebElement registerButton = driverie.findElement(By.linkText("Register"));
            registerButton.click();
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No Register button!");
        }

        //wait 1.5s for the next web page to load
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //check if the next web page title is OK
        try {
            Assert.assertEquals("Register to our services", driverie.getTitle());
        }
        catch (AssertionError ase)
        {
            System.out.println("[Test FAIL]. Page title is different than the expected one!");

        }

        // enter fullname
        try {
            WebElement fullname = driverie.findElement(By.name("fullname"));
            fullname.sendKeys("Maggie Tom");
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No input field with the name \"fullname\"!");
        }

        // choose language
        try {
            Select sel = new Select(driverie.findElement(By.name("language")));
            sel.selectByVisibleText("German");
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No dropdown with the name \"language\"!");
        }

        // choose sex
        try {
            WebElement radio = driverie.findElement(By.xpath("//label[text()='Female']"));
            radio.click();
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No radio with the text \"Female\"!");
        }

        // enter username
        try {
            WebElement uname = driverie.findElement(By.name("uname"));
            uname.sendKeys("clauser2468");
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No input field with the name \"uname\"!");
        }

        // enter email
        try {
            WebElement email = driverie.findElement(By.name("email"));
            email.sendKeys("test@test.org");
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No input field with the name \"email\"!");
        }

        // enter password
        try {
            WebElement pass = driverie.findElement(By.name("pass"));
            pass.sendKeys("Pwd123456");
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No input field with the name \"pass\"!");
        }

        // check terms of service
        try {
            WebElement check = driverie.findElement(By.id("TOS1"));
            if (!check.isSelected())
            {
                check.click();
            }
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No input field with the name \"pass\"!");
        }

        // press Register button
        try {
            WebElement register = driverie.findElement(By.id("reg"));
            register.click();
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No Register button!");
        }

        //wait 1.5s for the third web page to load
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //check if the web page title is OK
        try {
            Assert.assertEquals("Register to our services: Result", driverie.getTitle());
        }
        catch (AssertionError ase)
        {
            System.out.println("[Test FAIL]. Page title is different than the expected one!");

        }

        //check the h2 text with the email
        try {
            String h2String = new String ("Thank you " + "Maggie Tom" + "! You have registered with the email " + "test@test.org" + " .");
            System.out.println (h2String);
            System.out.println ("//h2[text()='" + h2String + "']");
            WebElement h2 =  driverie.findElement(By.xpath("//h2[text()='" + h2String + "']"));

            //WebElement h2 =  driverie.findElement(By.xpath("//h2[text()='Thank you ! You have registered with the email test@test.org .']"));
            //h2[text()='Thank you ! You have registered with the email test@test.org .']
            System.out.println("[Test PASS].");
        }
        catch (NoSuchElementException ase)
        {
            System.out.println("[Test FAIL]. No h2 with the expected text!");

        }
        driverie.close();
    }
}


