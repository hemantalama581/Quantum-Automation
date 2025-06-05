package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class Contract {

    public static void  main(String [] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://quantumuat.billboardplanet.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Scanner scanner = new Scanner(System.in);

        Login_generic.performLogin(driver);

        //above code is for the login purpose

        WebElement salesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-menu-content\"]/div/div/div[1]/ul/li[6]/menu-toggle/button")));
        salesMenu.click();

        WebElement contractMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"docs-menu-Sales\"]/li[5]/menu-link/a")));
        contractMenu.click();

        WebElement newContractButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contractPage\"]/div/div/div/div/md-content/div[2]/button[1]")));
        newContractButton.click();
        Thread.sleep(9000);
        Actions actions = new Actions(driver);

        for (int i = 0; i < 9; i++) {
            actions.sendKeys(org.openqa.selenium.Keys.TAB).perform();        //using for loop to enter tab key 9 times.
            Thread.sleep(500);  // Optionally, add a delay between tab presses (adjust as necessary)
        }

        System.out.println("Enter the Client Contract Number");
        String clientContractNumberValue = scanner.nextLine();
        // Now that we're at the target element, send a value (e.g., entering text into an input field)
        WebElement targetElement = driver.switchTo().activeElement();  // Get the active element
        targetElement.sendKeys(clientContractNumberValue);  //Entering Client contract number


        WebElement advertiserClient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addAdv")));
        advertiserClient.click();

        System.out.println("Enter the Search Advertiser");
        String searchAdvertiserValue =scanner.nextLine();

        WebElement searchAdvertiser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addAdvGridInput")));
        searchAdvertiser.sendKeys(searchAdvertiserValue);
        Thread.sleep(5000);
        searchAdvertiser.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);  // Optional, if you need to give time for the focus change

        // Once the row is focused, press ENTER to select it
        actions.sendKeys(Keys.ENTER).perform();

        WebElement saveContract = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addNewSave\"]")));
        saveContract.click();





    }
}


