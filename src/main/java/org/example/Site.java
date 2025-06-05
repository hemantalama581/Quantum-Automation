package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Scanner;

public class Site {
    public static void  main(String []args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://quantumuat.billboardplanet.com/");
        driver.manage().window().maximize();
        Scanner scanner = new Scanner(System.in);

        Login_generic.performLogin(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Above code is for the login purpose

        // Now I am creating a site

        WebElement inventory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-menu-content\"]/div/div/div[1]/ul/li[13]/menu-toggle/button/span[1]")));
        inventory.click();

        WebElement sites = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"docs-menu-Inventory\"]/li[1]/menu-link/a/span")));
        sites.click();

        WebElement addNewSite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/md-content/div[2]/button[1]/span[3]/span")));
        addNewSite.click();

        System.out.println("Enter Vendor Site ID: ");
        String vendorSiteIDValue = scanner.nextLine();
        WebElement vendorSiteId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vendorSiteID")));
        vendorSiteId.sendKeys(vendorSiteIDValue);


        //StateCode

        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-form\"]/md-content/div[2]/div[1]/div[1]/div[7]/md-input-container/div[2]")));
        state.click();


        Thread.sleep(3000);

        WebElement selectState = driver.findElement(By.xpath("//md-option/div[text()='Alabama']"));
        selectState.click();

        WebElement saveNewSite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-form\"]/div/div/ul[1]/li/button/span/span")));
        saveNewSite.click();

        WebElement errorMessageTrial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div/div[1]/button")));
        errorMessageTrial.click();

    }
}
