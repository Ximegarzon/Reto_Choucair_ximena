public class LoginSteps {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("the user is on the login page")
    public void userOnLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void userRedirectedToDashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @And("the user navigates to Recruitment")
    public void userNavigatesToRecruitment() {
        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
    }

    @And("the user adds a new candidate")
    public void userAddsNewCandidate() {
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("addCandidate_firstName")).sendKeys("John");
        driver.findElement(By.id("addCandidate_lastName")).sendKeys("Doe");
        driver.findElement(By.id("addCandidate_email")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("btnSave")).click();
    }

    @Then("the candidate's status should be {string}")
    public void candidateStatusShouldBe(String status) {
        WebElement candidateStatus = driver.findElement(By.xpath("//td[contains(text(), 'Hired')]"));
        Assert.assertTrue(candidateStatus.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
