import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class App {

    public static void main(String[] args) {
       
    System.setProperty("webdriver.chrome.driver","E:\\Projects\\test\\Driver\\lib\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    invalidLogin(driver, wait);
    
   driver.quit(); // لو انا عاوز اخرج
   
}

//http://localhost:3000/login
public static void noEmailLogin(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/login");

    WebElement email = driver.findElement(By.id("email"));
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("1234");

    try {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("[data-testid='loginBtn']")));
        loginButton.click();

    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }

    
    if (email.getAttribute("value").isEmpty()) {
        System.out.println("Email field is empty");
    } else {
        System.out.println("Email field is not empty");
    }

}
public static void noPasswordLogin(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/login");

    WebElement email = driver.findElement(By.id("email"));
    email.sendKeys("Sudalftfm@gmail.com");
    WebElement password = driver.findElement(By.id("password"));



    try {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("[data-testid='loginBtn']")));
        loginButton.click();

    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }


    if (password.getAttribute("value").isEmpty()) {
        System.out.println("Password field is empty");
    } else {
        System.out.println("Password field is not empty");
    }

}
public static void invalidLogin(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/login");

    WebElement email = driver.findElement(By.id("email"));
    email.sendKeys("Sudalftfm@gmail.com");
    

    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    password.sendKeys("1234");
    

    try {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("[data-testid='loginBtn']")));
        loginButton.click();

        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[contains(text(),'Email or Password are incorrect!')]")));

        if (errorMsg.isDisplayed()) {
            System.out.println("Invalid login confirmed: Error message displayed.");
        } else {
            System.out.println("Error message not displayed.");
        }

    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}
public static void validLogin(WebDriver driver , WebDriverWait wait){
    driver.get("http://localhost:3000/login");


        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Sudalftfm@gmail.com");// Use correct email
        

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("1234");// Use correct password
        

        
        try {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("[data-testid='loginBtn']")));
        loginButton.click();

        
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
        

    }

//http://localhost:3000/register

public static void noEmailRegister(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/register");
    WebElement email = driver.findElement(By.id("email"));
    email.sendKeys("");
    WebElement name = driver.findElement(By.id("fullName"));
    name.sendKeys("Mohamed Samy");
    WebElement phone = driver.findElement(By.id("phone"));
    phone.sendKeys("01066365380");
    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    password.sendKeys("1234");
    WebElement rebeatPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repeatPassword")));
    rebeatPassword.sendKeys("1234");
    if (email.getAttribute("value").isEmpty()) {
        System.out.println("Email field is empty");
    } else {
        System.out.println("Email field is not empty");


        }
    }
public static void invalidEmailRegister(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/register");
    WebElement email = driver.findElement(By.id("email"));
    email.sendKeys("mohamedsamy");
    WebElement name = driver.findElement(By.id("fullName"));
    name.sendKeys("Mohamed Samy");
    WebElement phone = driver.findElement(By.id("phone"));
    phone.sendKeys("01066365380");
    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    password.sendKeys("1234");
    WebElement rebeatPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repeatPassword")));
    rebeatPassword.sendKeys("1234");
    
    System.out.println("Incorrect! Email should be like this example: peter@gmail.com!");
    
    }
public static void noNameRegister(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/register");
    WebElement email = driver.findElement(By.id("email"));
    email.sendKeys("Sudalftfm@gmail.com");
    WebElement name = driver.findElement(By.id("fullName"));
    name.sendKeys("");
    WebElement phone = driver.findElement(By.id("phone"));
    phone.sendKeys("01066365380");
    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    password.sendKeys("1234");
    WebElement rebeatPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repeatPassword")));
    rebeatPassword.sendKeys("1234");
    if (name.getAttribute("value").isEmpty()) {
        System.out.println("Name field is empty");
    } else {
        System.out.println("Name field is not empty");
    }


}
public static void noPhoneRegister(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/register");
    WebElement email = driver.findElement(By.id("email"));
    email.sendKeys("Sudalftfm@gmail.com");
    WebElement name = driver.findElement(By.id("fullName"));
    name.sendKeys("Mohamed Samy");
    WebElement phone = driver.findElement(By.id("phone"));
    phone.sendKeys("");
    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    password.sendKeys("1234");
    WebElement rebeatPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repeatPassword")));
    rebeatPassword.sendKeys("1234");
    if (phone.getAttribute("value").isEmpty()) {
        System.out.println("Phone field is empty");
    } else {
        System.out.println("Phone field is not empty");
    }
}
public static void noPasswordRegister(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/register");
    WebElement email = driver.findElement(By.id("email"));
    email.sendKeys("Sudalftfm@gmail.com");
    WebElement name = driver.findElement(By.id("fullName"));    
    name.sendKeys("Mohamed Samy");
    WebElement phone = driver.findElement(By.id("phone"));
    phone.sendKeys("01066365380");
    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    password.sendKeys("");  
    WebElement rebeatPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repeatPassword"))); 
    rebeatPassword.sendKeys("1234");
    if (password.getAttribute("value").isEmpty()) {
        System.out.println("Password field is empty");
    } else {
        System.out.println("Password field is not empty");
    }
}
public static void validRegister(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/register");

    // Fill in the form fields
    WebElement email = driver.findElement(By.id("email"));
    email.clear();
    email.sendKeys("Sudalftfm@gmail.com");

    WebElement name = driver.findElement(By.id("fullName"));
    name.clear();
    name.sendKeys("Mohamed Samy");

    WebElement phone = driver.findElement(By.id("phone"));
    phone.clear();
    phone.sendKeys("01066365380");

    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    password.clear();
    password.sendKeys("1234");

    WebElement repeatPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repeatPassword")));
    repeatPassword.clear();
    repeatPassword.sendKeys("1234");

   try {
    WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[contains(@class, 'btn-primary') and contains(text(), 'Register')]")));

    registerButton.click();

    System.out.println("Clicked register button, waiting for success indication...");

} catch (Exception e) {
    System.out.println("An error occurred: ");
   
}
}

//http://localhost:3000/
public static void ModeSwap(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/");
    WebElement darkModeButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[contains(@class, 'dark-mode-toggle')]")));
    darkModeButton.click();
    System.out.println("Page Mode Swapped");
}


//Navigators
public static void HomeToCatalog(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/");
    WebElement catalogButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/catalog')]")));
    catalogButton.click();
    System.out.println("Navigated to Catalog");
}
public static void CatalogToHome(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/catalog");
    WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/')]")));
    homeButton.click();
    System.out.println("Navigated to Home");
}
public static void HomeToLogin(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/");
    WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/login')]")));
    loginButton.click();
    System.out.println("Navigated to Login");
}
public static void HomeToRegister(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/");
    WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/register')]")));
    registerButton.click();
    System.out.println("Navigated to Register");}
public static void HomeToAbout(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/");
    WebElement aboutButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/aboutus')]")));
    aboutButton.click();
    System.out.println("Navigated to About");}
public static void AboutToHome(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/aboutus");
    WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/')]")));
    homeButton.click();
    System.out.println("Navigated to Home");}
public static void AboutToCatalog(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/aboutus");
    WebElement catalogButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/catalog')]")));
    catalogButton.click();
    System.out.println("Navigated to Catalog");}
public static void AboutToLogin(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/aboutus");
    WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/login')]")));
    loginButton.click();
    System.out.println("Navigated to Login");}
public static void AboutToRegister(WebDriver driver, WebDriverWait wait) {
    driver.get("http://localhost:3000/aboutus");
    WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[contains(@href, '/register')]")));
    registerButton.click();
    System.out.println("Navigated to Register");}

}
   