import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagentoLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Store the credentials that we will use to sign in
        String username = "testautoman@email.com";
        String password = "qwerty123!";

        // Navigate to the web-app
        driver.get("https://magento.softwaretestingboard.com/");

        // Wait for 2 seconds for the page to render
        Thread.sleep(2000);

        // Locate and store the Sign In button
        WebElement signInButton = driver.findElement(By.xpath(
                "//header[@class = 'page-header']//a[contains(text(), 'Sign In')]"
        ));
        signInButton.click();

        // Wait for 2 seconds for the page to render
        Thread.sleep(2000);

        WebElement usernameField = driver.findElement(By.xpath(
                "//input[@id = 'email']"
        ));
        WebElement passwordField = driver.findElement(By.xpath(
                "//input[contains(@title,'Password')]"
        ));
        WebElement logInButton = driver.findElement(By.xpath(
                "//fieldset//button"
        ));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        logInButton.click();

        // Wait for 2 seconds for the page to render
        Thread.sleep(2000);

        // Retrieve the title of the current page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Locate the web welcome message element
        WebElement welcomeMessageElement = driver.findElement(By.xpath(
                "//div[@class = 'panel header']//span[starts-with(text(), 'Welcome, ')]"
        ));
        // Having the element, utilize getText() to retrieve
        // the text from the web element
        String welcomeMessage = welcomeMessageElement.getText();
        // Print the message that comes from the web page
        System.out.println("Actual message on the web page: "
                + welcomeMessage);


        // Validation
        if(welcomeMessage.startsWith("Welcome,")){
            System.out.println("TEST: PASSED");
        } else {
            System.out.println("TEST: FAILED");
        }

        // terminate driver session
        driver.quit();

    }

}

