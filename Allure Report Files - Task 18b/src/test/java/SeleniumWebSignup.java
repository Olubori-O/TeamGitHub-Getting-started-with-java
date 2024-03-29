import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignup {
    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //Locate where the chrome browser is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //Open your chrome browser
        driver = new ChromeDriver();
        //Input the assigned URL
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test 1-Verify user inputs the corrects URL and redirects to the appropriate webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("Hurray!On the right webpage");
            //Fail
        else System.out.println("Ooops!Wrong website");
        //Estimate a load wait time
        Thread.sleep(10000);
        //Maximize the page
        driver.manage().window().maximize();
        //Click on Signup CTA button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    }

    @Test(priority = 6)
    public void NegativeSignup() throws InterruptedException {
        //Test 3-Verify user can't signup with username less than 3 characters
        //Input user name in the Username field
        driver.findElement(By.id("user_username")).sendKeys("To");
        //Input email in the Email field
        driver.findElement(By.id("user_email")).sendKeys("Boritea@mailinator.com");
        //Input preferred password in the Password field
        driver.findElement(By.name("user[password]")).sendKeys("Seleniumtest1234");
        //Click on Sign Up button to submit
        driver.findElement(By.id("submit")).click();
        //Estimate load time after submission
        Thread.sleep(10000);
        //Refresh page before next test
        driver.navigate().refresh();
    }

    @Test(priority = 5)
    public void NegativeSignup2() throws InterruptedException {
        //Test 4-Verify user can't signup with invalid email address
        //Input user name in the Username field
        driver.findElement(By.id("user_username")).sendKeys("Borium");
        //Input email in the Email field
        driver.findElement(By.id("user_email")).sendKeys("Borium@mailinatorco");
        //Input preferred password in the Password field
        driver.findElement(By.name("user[password]")).sendKeys("Seleniumtest1234");
        //Click on Sign Up button to submit
        driver.findElement(By.id("submit")).click();
        //Estimate load time after submission
        Thread.sleep(10000);
        //Refresh page before next test
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void NegativeSignup3() throws InterruptedException {
        //Test 6-Verify user can't signup with either or all of the fields blanks
        //Input user name in the Username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //Input email in the Email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //Input preferred password in the Password field
        driver.findElement(By.name("user[password]")).sendKeys("");
        //Click on Sign Up button to submit
        driver.findElement(By.id("submit")).click();
        //Estimate load time after submission
        Thread.sleep(10000);
        //Refresh page before next test
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void PositiveSignup() throws InterruptedException {
        //Test 7-Verify user is successfully signup when valid details are inputted
        //Input user name in the Username field
        driver.findElement(By.id("user_username")).sendKeys("Olluwabori");
        //Input email in the Email field
        driver.findElement(By.id("user_email")).sendKeys("Ollibori@mailinator.com");
        //Input preferred password in the Password field
        driver.findElement(By.name("user[password]")).sendKeys("Olaotan1234");
        //Click on Sign Up button to submit
        driver.findElement(By.id("submit")).click();
        //Estimate load time after submission
        Thread.sleep(10000);
    }

    @Test(priority = 1)
    public void ClickUser1Item() throws InterruptedException {
        //Click on user1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test 2-Verify that when user clicks on Signup button, user is redirected to Signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Hurray!On the right webpage");
            //Fail
        else System.out.println("Ooops!Wrong website");

        //Estimate load time
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void VerifyItem() throws InterruptedException {
        //Test 8-Search for an item (Using Ruby with Selenium Webdriver) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
        //Test 9-Verify User1 page URL
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Hurray!You are on the right user1 page");
            //Fail
        else System.out.println("Ooops!Wrong user1 page");

        //Estimate load time
        Thread.sleep(10000);

    }

    @Test (priority = 3)
    public void logoutSuccessfully() throws InterruptedException {
        //Logout of webpage
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10-Verify that user is redirected to the homepage after logging out
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contains(actualTitle))
            //Pass
            System.out.println("You are now on the homepage");
            //Fail
        else System.out.println("Ooops!Wrong page");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

    }


    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }


}
