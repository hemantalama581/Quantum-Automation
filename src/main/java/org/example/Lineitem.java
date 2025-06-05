package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.IOError;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

public class Lineitem {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://quantumuat.billboardplanet.com/");

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Login_generic.performLogin(driver);
        Scanner scanner = new Scanner(System.in);


        WebElement salesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-menu-content\"]/div/div/div[1]/ul/li[6]/menu-toggle/button")));
        salesMenu.click();

        WebElement contractMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"docs-menu-Sales\"]/li[5]/menu-link/a")));
        contractMenu.click();


        WebElement contractCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-search-form1\"]/div[1]/div[1]/div[4]/div[1]/div/md-checkbox/div[1]")));
        contractCheckBox.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();

        System.out.println("Enter the Contract number: ");
        String contractNumber = scanner.nextLine();
        WebElement targetElement = driver.switchTo().activeElement();  // Get the active element
        targetElement.sendKeys(contractNumber);



        WebElement searchButtonContract = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-search-form1\"]/div[2]/div/div[2]/button[1]")));
        searchButtonContract.click();

        WebElement editContractButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tab-content-234\"]/div/div/div/div/div[2]/div/div/div[3]/table/tbody/tr/td[1]/button")));
        editContractButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");



        WebElement lineItemButton  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-form\"]/md-content/div[3]/div/div[2]/div/div[1]/div[3]/button[1]")));
        lineItemButton.click();

        Thread.sleep(3000);

        for (int i = 0; i < 3; i++)
        {
            actions.sendKeys(org.openqa.selenium.Keys.TAB).perform();
            Thread.sleep(1000);
        }

        // Now that we're at the target element, send a value (e.g., entering text into an input field)

        System.out.println("Enter the Line Item Description: ");
        String lineItemDescriptionValue = scanner.nextLine();
        WebElement targetElements = driver.switchTo().activeElement();  // Get the active element
        targetElements.sendKeys(lineItemDescriptionValue);




        System.out.println("Enter the Campaign Name: ");
        String campaignNameValue = scanner.nextLine();
        WebElement campaignName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CLICampaign")));
        campaignName.sendKeys(campaignNameValue);

        WebElement popFrequency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-form\"]/fieldset/div/md-content/div/div[1]/div/div[2]/div[3]/div[2]")));
        popFrequency.click();

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();

        WebElement saveLineItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fliSave\"]")));
        saveLineItem.click();


        //From the above code we have successfully added the face line item .Now we need to add the face.

        WebElement faceSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-form\"]/fieldset/div/md-content/div[2]/div[2]/div[2]/div/ul[2]/li[5]/button")));
        faceSelector.click();

        WebElement faceIDCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-search-form\"]/div[1]/div[1]/div[5]/div[1]/div/md-checkbox/div[1]")));
        faceIDCheckbox.click();

        Thread.sleep(3000);

        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);

        System.out.println("Enter the Face ID: ");
        String faceIdValue = scanner.nextLine();

        WebElement targetElementsss = driver.switchTo().activeElement();
        targetElementsss.sendKeys(faceIdValue);

        System.out.println("Enter the start date:");
        String startDateValue = scanner.nextLine();

        WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"startdate\"]")));
        startDate.sendKeys(startDateValue);

        for(int i = 0; i < 2; i++){

            actions.sendKeys(org.openqa.selenium.Keys.TAB).perform();
            Thread.sleep(500);
        }
        WebElement activeElementIntervals = driver.switchTo().activeElement();
        activeElementIntervals.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys(Keys.TAB)
                .keyUp(Keys.SHIFT)
                .perform();

        System.out.println("Enter the intervals: ");
        String intervalValue = scanner.nextLine();
        WebElement intervals = driver.switchTo().activeElement();
        intervals.sendKeys(intervalValue);



        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contract-master-search-form\"]/div[2]/div/div[2]/div/button[1]")));
        searchButton.click();



        for(int i = 0 ; i < 9 ; i++ ){
            actions.sendKeys(org.openqa.selenium.Keys.TAB).perform();
            Thread.sleep(500);
        }
        Thread.sleep(3000);

        actions.sendKeys(Keys.ENTER).perform();

        WebElement addFaceToContract = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addfaces\"]/div[1]/button")));
        addFaceToContract.click();








    }
}
