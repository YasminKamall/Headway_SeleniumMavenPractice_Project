import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniimHeadlessexcutionDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set ChromeDriver path
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Enable headless mode
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(chromeOptions);

        // Maximize window and navigate to the website
        driver.manage().window().maximize();
        driver.navigate().to("http://automationexercise.com");
    }
    @Test
    public void User_Registration(){
        //Verify that home page is visible successfully
        //driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"))
        // .isDisplayed();
        String Pagetitle = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]")).getText();
        Assert.assertEquals(Pagetitle,"FEATURES ITEMS");
        //Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();
        //Verify 'New User Signup!' is visible
        String signup = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText();
        Assert.assertEquals(signup,"New User Signup!");
        //Enter name and email address
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Yasmin");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("yassmin.Kamall@gmail.com");
        //Click 'Signup' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String Enter_Account = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b")).getText();
        Assert.assertEquals(Enter_Account,"ENTER ACCOUNT INFORMATION");
        //Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345");
        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByVisibleText("1");
        Select months = new Select(driver.findElement(By.id("months")));
        months.selectByVisibleText("January");
        Select years = new Select(driver.findElement(By.id("years")));
        years.selectByVisibleText("2021");
        //Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        //Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();
        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number.
        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Yasmin");
        driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Mohamed");
        driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("GizaSystems");
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("October");
        driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("Haram");
        Select Country = new Select(driver.findElement(By.id("country")));
        Country.selectByVisibleText("Canada");
        driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Ontario");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("London");
        driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("000");
        driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("01114323232");
        //Click 'Create Account button'
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
        // Verify that 'ACCOUNT CREATED!' is visible
        String Account_Created = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
        Assert.assertEquals(Account_Created,"ACCOUNT CREATED!");
        // Click 'Continue' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
        //Verify that 'Logged in as username' is visible
        String Logged_in = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).getText();
        Assert.assertEquals(Logged_in,"Logged in as Yasmin");
        // Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]")).click();
        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String Account_Deleted = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
        Assert.assertEquals(Account_Deleted,"ACCOUNT DELETED!");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();


    }
}
