package Register.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class Homepage {
    private WebDriver driver;
    String HomePageURL = "http://automationexercise.com";

    //Element Locators
    private final By PageTitle = By.xpath("//h2[@class=\"title text-center\"]");
    private final By SignupLoginButton = By.linkText("Signup / Login");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public void navigatetohomepage(){
        driver.navigate().to(HomePageURL);
    }
    public void assertonhomepageisvisible(String expectedResult) {
        String pagetitle = driver.findElement(PageTitle).getText();
        Assert.assertEquals(pagetitle,expectedResult);
    }
    public void clickSignupLoginButton() {
        driver.findElement(SignupLoginButton).click();
    }
}
