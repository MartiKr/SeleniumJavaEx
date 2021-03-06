import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ValidDataRegisterForm {

    private WebDriver driver;

    // Open Chrome browser & go to website with registry form
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\EEC Serwer\\Desktop\\KrogulecQA\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");
    }


    @Test
    public void fillForm() throws InterruptedException {

        // Input and acceptance data
        String expectedResult = "You're logged in!!";

        String username = "angular";
        String password = "password";
        String userInfo = "angular";

        // Wait 5 s till website is open and fill the username field
        TimeUnit.SECONDS.sleep(5);
        WebElement usernameField = driver.findElement(new By.ByXPath("//html//body//div[3]//div//div//div//form//div[1]//input"));
        usernameField.clear();
        usernameField.sendKeys(username);
        usernameField.submit();

        // fill the password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
        passwordField.submit();

        // fill the last field
        WebElement user = driver.findElement(By.name("formly_1_input_username_0"));
        user.clear();
        user.sendKeys(userInfo);
        user.submit();

        // click on login button
        WebElement login = driver.findElement(new By.ByXPath("/html/body/div[3]/div/div/div/form/div[3]/button"));
        login.click();

        // Wait 5s for response
        TimeUnit.SECONDS.sleep(5);
        WebElement result = driver.findElement(new By.ByXPath("//html//body//div[3]//div//div//div//p[1]"));

        // Check if user is correctly log in
        Assert.assertEquals(expectedResult, result.getText());

    }

    @After
    public void shutDown() {

        driver.quit();

    }

}



