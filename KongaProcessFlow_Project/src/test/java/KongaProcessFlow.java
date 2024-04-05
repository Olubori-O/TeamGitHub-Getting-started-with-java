/**Visit the Konga URL
 * Sign in to Konga successfully
 * From the Categories, click on the "Computers and Accessories"
 * Click on the Laptop subcategory
 * Click on the Apple Macbooks
 * Add an item to the cart
 * Select Address
 * Continue to make payment
 * Input invalid card details
 * Print out error message "Invalid card number"
 * Close the iFrame that displays the input card modal
 * Quit the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaProcessFlow {
    //Import Selenium Webdriver
    private WebDriver driver;

    @BeforeTest
    public void StartPage() throws InterruptedException {
        //Locate where the ChromeDriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //Open Chrome browser
        driver = new ChromeDriver();
        //Input the Konga URL to be used for the test
        driver.get("https://www.konga.com");
        //Maximize the browser
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    public void SignIn() throws InterruptedException {
        //Click the Login/Signup on the landing page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //Enter valid email address or phone number
        driver.findElement(By.id("username")).sendKeys("bori@mailinator.com");
        //Enter valid password
        driver.findElement(By.id("password")).sendKeys("Konga12345");
        //Click on Login to continue
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //Estimate load time after submission
        Thread.sleep(4000);
        //Print out a successful login message
        System.out.println("Login Successful");

    }

     @Test (priority = 1)
    public void SelectItem() throws InterruptedException {
        //From the Categories menu, click on the Computer and Accessories
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        //Create an instance of Actions class
        Actions actions = new Actions(driver);
        //Hover on the element
        actions.moveToElement(elementToHover).build().perform();
        //Estimate wait time
        Thread.sleep(5000);
        //Select Macbook
        driver.findElement(By.xpath("//*[@id=\"subFixId\"]/div/div/div[1]/a[6]")).click();
        Thread.sleep(4000);
        //Choose item to buy
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div")).click();
        //Estimate wait time
        Thread.sleep(10000);
        //Click on Buy Now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        //Estimate wait time
        Thread.sleep(10000);

    }


    @Test (priority = 2)
    public void CheckoutAndSelectAddress() throws InterruptedException {
        //Click on Continue to Checkout
        driver.findElement(By.linkText("Continue to Checkout")).click();
        //Estimate wait time
        Thread.sleep(4000);
        //Click on Change to select address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        //Estimate wait time
        Thread.sleep(4000);
        //Click on Add Delivery Address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        //Estimate wait time
        Thread.sleep(5000);
        //Select existing address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        //Estimate load time
        Thread.sleep(8000);
        //Click on Use This Address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        //Estimate wait time
        Thread.sleep(9000);
        System.out.println("Address selected");


    }


    @Test (priority = 3)
    public void MakePayment() throws InterruptedException {
        //Select Pay Now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        //Estimate wait time
        Thread.sleep(15000);
        //Click on Continue to Payment
        driver.findElement(By.name("placeOrder")).click();
        System.out.println("Continue to payment");
        //Estimate wait time
        Thread.sleep(10000);

    }

    @Test (priority = 4)
    public void SelectCardMethod() throws InterruptedException {
        //Change from default to iframe
        WebElement paymethod = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(7000);
        System.out.println("Payment Method");
        //Select payment method, choosing card
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        //Estimate wait time
        Thread.sleep(10000);

    }

    @Test (priority = 5)
    public void InputCardDetails() throws InterruptedException {
        //Input invalid card details
        driver.findElement(By.id("card-number")).sendKeys("22987654321");
        //Input card date in its field
        driver.findElement(By.xpath("//*[@id=\"expiry\"]")).sendKeys("0727");
        //Estimate wait time
        Thread.sleep(3000);
        //Input CVV in its field
        driver.findElement(By.id("cvv")).sendKeys("419");
        //Estimate load time
        Thread.sleep(3000);
        //Input card pin
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[9]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(2000);
        //Click on Pay Now
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        //Estimate wait time
        Thread.sleep(2000);

    }

    @Test (priority = 6)
    public void PrintErrorMessage() throws InterruptedException {
        //Print out error message for invalid card details
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        //Estimate load time
        Thread.sleep(3000);
        //Confirm that the feedback message reads "Invalid card details"
        //Find the element containing the response message
        WebElement responseElement = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]"));
        //Get the text of the response message
        String actualMessage = responseElement.getText();
        //Specify the expected response message
        String expectedMessage = "invalid card number";
        //Compare the actual message with the expected message
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Response message matches the expected message");
        } else {
            System.out.println("Response message does not match the expected message");
         //Estimate load time
        Thread.sleep(3000);
        }
    }


    @Test (priority = 7)
    public void CloseiFrame() throws InterruptedException {
        //close the iFrame that displays input card details
        WebElement exitframe = driver.findElement(By.className("data-card__close"));
        exitframe.click();
        System.out.println("Exit payment method iframe");
        Thread.sleep(3000);

    }

    @Test (priority = 8)
    public void ExitiFrame() throws InterruptedException {
        //Exit iFrame
        driver.switchTo().defaultContent();
        Thread.sleep(4000);
        System.out.println("Restore default page");

    }

    @AfterTest
    public void QuitBrowser() {
        //Quit the browser
        driver.quit();

    }


}
