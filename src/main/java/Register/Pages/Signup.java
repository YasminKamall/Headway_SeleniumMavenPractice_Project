package Register.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Signup {
    private WebDriver driver;
    //Locators
    private final By NewUserSignup = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    private final By NameInput = By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]");
    private final By EmailInput = By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]");
    private final By SignupButton = By.xpath("//*[@id='form']/div/div/div[3]/div/form/button");

    public Signup(WebDriver driver) {
        this.driver = driver;
    }

    public void assertonNewUserSignupisvisible(String expectedResult) {
        String signup = driver.findElement(NewUserSignup).getText();
        Assert.assertEquals(signup,expectedResult);
    }
    public void enterNameAndEmail(String name, String email) {
        driver.findElement(NameInput).sendKeys(name);
        driver.findElement(EmailInput).sendKeys(email);
    }
    public void clickSignupButton() {
        driver.findElement(SignupButton).click();
    }

}
