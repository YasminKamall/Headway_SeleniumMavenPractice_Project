import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumPOMDemo {
    WebDriver driver;
    String HomePageURL = "http://automationexercise.com";

         //Element Locators
         private final By PageTitle = By.xpath("//h2[@class=\"title text-center\"]");
         private final By SignupLoginButton = By.linkText("Signup / Login");
         private final By NewUserSignup = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
         private final By NameInput = By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]");
         private final By EmailInput = By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]");
         private final By SignupButton = By.xpath("//*[@id='form']/div/div/div[3]/div/form/button");
         private final By ENTERACCOUNTINFORMATION = By.xpath("//*[@id='form']/div/div/div/div[1]/h2/b");
         private final By GenderCheckBox = By.xpath("//*[@id='id_gender2']");
         private final By PasswordInput = By.xpath("//*[@id='password']");
         private final By dayslist = By.id("days");
         private final By monthslist = By.id("months");
         private final By yearslist = By.id("years");
         private final By NewsletterCheckbox = By.xpath("//*[@id='newsletter']");
         private final By SpecialOffersCheckbox = By.xpath("//*[@id='optin']");
         private final By firstNameInput = By.xpath("//*[@id='first_name']");
         private final By lastNameInput = By.xpath("//*[@id='last_name']");
         private final By CompanyInput = By.xpath("//*[@id='company']");
         private final By address1Input = By.xpath("//*[@id='address1']");
         private final By address2Input = By.xpath("//*[@id='address2']");
         private final By countrylist = By.id("country");
         private final By stateInput = By.xpath("//*[@id='state']");
         private final By cityInput = By.xpath("//*[@id='city']");
         private final By zipcodeInput = By.xpath("//*[@id='zipcode']");
         private final By mobileNumberInput = By.xpath("//*[@id='mobile_number']");
         private final By CreateAccountButton = By.xpath("//*[@id='form']/div/div/div/div[1]/form/button");
         private final By accountCreatedHeader = By.xpath("//*[@id='form']/div/div/div/h2/b");
         private final By continueButton = By.xpath("//*[@id='form']/div/div/div/div/a");
         private final By loggedInHeader = By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a");
         private final By DeleteAccountButton = By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[5]");
         private final By AccountDeletedHeader = By.xpath("//*[@id='form']/div/div/div/h2/b");
         private final By ContinueButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
        @BeforeMethod
        public void BrowserSearch() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            navigatetohomepage();
        }

        @Test
        public void RegisterUser() {
            //Verify that home page is visible successfully
            assertonhomepageisvisible("FEATURES ITEMS");
           //Click on 'Signup / Login' button
            clickSignupLoginButton();
            //Verify 'New User Signup!' is visible
            assertonNewUserSignupisvisible("New User Signup!");
            //Enter name and email address
            enterNameAndEmail("Yasmin", "yassmin.kamal@gmail.com");
            //Click 'Signup' button
             clickSignupButton();
            //Verify that 'ENTER ACCOUNT INFORMATION' is visible
            assertonenteraccountinfoisvisible("ENTER ACCOUNT INFORMATION");
            //Fill details: Title, Name, Email, Password, Date of birth
             selectgender();
             InputPassword("12345");
             Selectdateofbirth("1", "January", "2021");
            //Select checkbox 'Sign up for our newsletter!'
             NewsletterCheckBox();
            //Select checkbox 'Receive special offers from our partners!'
             SpecialoffersCheckBox();
            //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number.
             filldetails("Yasmin", "Mohamed", "GizaSystems", "October", "Haram", "Canada", "Ontario", "London", "000", "01114323232");
            //Click 'Create Account button'
             CreateaccountButton();
            // Verify that 'ACCOUNT CREATED!' is visible
             assertonaccountcreatedisvisisble("ACCOUNT CREATED!");
            // Click 'Continue' button
             Clickcontinue();
            //Verify that 'Logged in as username' is visible
            assertonloggedinasisvisible("Logged in as Yasmin");
            // Click 'Delete Account' button
            Clickdeleteaccount();
            //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
            assertonAccountdeleted("ACCOUNT DELETED!");
        }



    ////Actions
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
       public void assertonenteraccountinfoisvisible(String expectedResult){
        String Enter_Account = driver.findElement(ENTERACCOUNTINFORMATION).getText();
        Assert.assertEquals(Enter_Account,expectedResult);
    }
    public void selectgender(){
        driver.findElement(GenderCheckBox).click();
    }
    public void InputPassword(String password){
        driver.findElement(PasswordInput).sendKeys(password);
    }
    public void Selectdateofbirth(String day,String month,String year){
        Select days = new Select(dayslist.findElement(driver));
        days.selectByVisibleText(day);
        Select months = new Select(driver.findElement(monthslist));
        months.selectByVisibleText(month);
        Select years = new Select(driver.findElement(yearslist));
        years.selectByVisibleText(year);
    }
    public void NewsletterCheckBox(){
        driver.findElement(NewsletterCheckbox).click();
    }
    public void SpecialoffersCheckBox(){
        driver.findElement(SpecialOffersCheckbox).click();
    }
    public void filldetails(String firstname,String lastname, String Company,String Add1,String Add2,String country,String state,String city, String zipcode,String mobilenumber){
        driver.findElement(firstNameInput).sendKeys(firstname);
        driver.findElement(lastNameInput).sendKeys(lastname);
        driver.findElement(CompanyInput).sendKeys(Company);
        driver.findElement(address1Input).sendKeys(Add1);
        driver.findElement(address2Input).sendKeys(Add2);
        Select Country = new Select(driver.findElement(countrylist));
        Country.selectByVisibleText(country);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipcodeInput).sendKeys(zipcode);
        driver.findElement(mobileNumberInput).sendKeys(mobilenumber);
    }
    public void CreateaccountButton(){
        driver.findElement(CreateAccountButton).click();
    }
    public void assertonaccountcreatedisvisisble(String expected){
        String Account_Created = driver.findElement(accountCreatedHeader).getText();
        Assert.assertEquals(Account_Created, expected);
    }
    public void Clickcontinue(){
        driver.findElement(continueButton).click();
    }
    public void assertonloggedinasisvisible(String expected){
        String Logged_in = driver.findElement(loggedInHeader).getText();
        Assert.assertEquals(Logged_in,expected);
    }
    public void Clickdeleteaccount(){
        driver.findElement(DeleteAccountButton).click();

    }
    public void assertonAccountdeleted(String expected){
        String Account_Deleted = driver.findElement(AccountDeletedHeader).getText();
        Assert.assertEquals(Account_Deleted,expected);
        driver.findElement(ContinueButton).click();
    }
}
