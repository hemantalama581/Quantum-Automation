package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class Face_from_site {

    public static void main(String []args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://quantumuat.billboardplanet.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Scanner scanner = new Scanner(System.in);


        Login_generic.performLogin(driver);
        // Above code is for the login purpose

        // Now I am creating a site

        WebElement inventory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-menu-content\"]/div/div/div[1]/ul/li[13]/menu-toggle/button/span[1]")));
        inventory.click();

        WebElement sites = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"docs-menu-Inventory\"]/li[1]/menu-link/a/span")));
        sites.click();

        WebElement addNewSite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/div/md-content/div[2]/button[1]/span[3]/span")));
        addNewSite.click();

        System.out.println("Enter Vendor Site ID: ");
        String vendorSiteIdValue = scanner.nextLine();
        WebElement vendorSiteId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vendorSiteID")));
        vendorSiteId.sendKeys(vendorSiteIdValue);


        //StateCode

        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-form\"]/md-content/div[2]/div[1]/div[1]/div[7]/md-input-container/div[2]")));
        state.click();


        Thread.sleep(3000);

        WebElement selectState = driver.findElement(By.xpath("//md-option/div[text()='Alabama']"));
        selectState.click();

        WebElement saveNewSite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-form\"]/div/div/ul[1]/li/button/span/span")));
        saveNewSite.click();

        //From the above code site has been created.

        WebElement addNewFaceButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-form\"]/div[1]/div/ul[2]/li[3]/button")));
        addNewFaceButton.click();

        System.out.println("Enter the value of Vendor Face ID: ");
        String vendorFaceIdValue = scanner.nextLine();
        WebElement vendorFaceId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"vendorFaceID\"]")));
        vendorFaceId.sendKeys(vendorFaceIdValue);


        WebElement signCategoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Addface\"]/div/form/md-content/div[1]/div[1]/div/div[1]/div[5]/md-input-container/div[2]")));
        signCategoryElement.click();

        WebElement selectSignCategoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option/div[text()='1 m W x 2 m H']")));
        selectSignCategoryElement.click();

        WebElement faceHeight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Addface\"]/div/form/md-content/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div/input[1]")));
        faceHeight.sendKeys("5");

        WebElement  faceWidth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Addface\"]/div/form/md-content/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div/input[1]")));
        faceWidth.sendKeys("2");

        WebElement submitFaceFormButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Addface\"]/div/form/div/div/ul[1]/li/button")));
        submitFaceFormButton.click();


    }
}
