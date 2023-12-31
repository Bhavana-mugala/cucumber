package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.AdminSignInPage;
import pageObject.CreateBrandPage;
import pageObject.DashBoardPage;
import pageObject.ManageBrandPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Stepdefinition {

	public WebDriver driver = null;
	public AdminSignInPage loginPage;
	public DashBoardPage dashboard;
	public CreateBrandPage createBrand;
	public ManageBrandPage manageBrand;

	@Before
	public void setup() {
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("admin launch the browser")
	public void user_launch_the_browser() {
		System.setProperty("webdriver.com.driver",
				"D:/Eclipse-workspace/CarRental_Cucumber_Project/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginPage = new AdminSignInPage(driver);
		dashboard = new DashBoardPage(driver);
		createBrand = new CreateBrandPage(driver);
		manageBrand = new ManageBrandPage(driver);
	}

	@Given("admin is on the Car Rental page")
	public void admin_is_on_the_car_rental_page() {
		driver.get("https://carrental.neohire.io/");
		loginPage = new AdminSignInPage(driver);
		driver.manage().window().maximize();
	}

	@When("admin clicks on Admin module")
	public void admin_clicks_on_admin_module() {
		loginPage.clickAdminButton();
	}

	@Then("admin navigates to sign in page")
	public void admin_navigates_to_sign_in_page() {
		Assert.assertTrue(loginPage.adminSignInPage().contains("Car Rental Portal | Admin Login"));
	}

	@Given("admin have entered a valid username and password")
	public void admin_have_entered_a_valid_username_and_password() {
		loginPage.enterUsername("admin");
		loginPage.enterPassword("Test@12345");
	}

	@When("admin click on the login button")
	public void admin_click_on_the_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("admin should be logged in successfully")
	public void admin_should_be_logged_in_successfully() {
		Assert.assertTrue(loginPage.getAdminSignInPageTitle().contains("Car Rental Portal | Admin Dashboard"));
	}

	@Given("admin have entered invalid {string} and {string}")
	public void admin_have_entered_invalid_and(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@Then("admin should see an error message indicating {string}")
	public void admin_should_see_an_error_message_indicating(String string) {
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();
		Assert.assertTrue(true);
	}

	@When("admin click on the {string} link")
	public void admin_click_on_the_link(String string) {
		loginPage.clickBacktoHomeLink();
	}

	@Then("admin should be redirected to the home page")
	public void admin_should_be_redirected_to_the_home_page() {
		Assert.assertTrue(loginPage.getHomePageTitle().contains("Car Rental Portal"));
	}

	@When("admin opens url {string}")
	public void admin_opens_url(String url) {
		driver.get(url);
	}

	@Then("admin should able to see the admin signin page")
	public void admin_should_able_to_see_the_admin_signin_page() {
		loginPage.adminSignInPage();
	}

	@Then("admin should enter username as {string}  and password as {string}")
	public void admin_should_enter_username_as_and_passwrod_ad(String string, String string2) {
		loginPage.enterUsername("admin");
		loginPage.enterPassword("Test@12345");
	}

	@Then("click on login")
	public void click_on_login() {
		loginPage.clickLoginButton();
	}

	@Then("admin should able to view car rental portal | admin panel")
	public void admin_should_able_to_view_car_rental_portal_admin_panel() {
		dashboard.checkCarRentalPortal();
	}

	@When("admin click on Dashboard")
	public void admin_click_on_dashboard() {
		dashboard.dashboardButton();
	}

	@When("click on Reg Users Full Detail link")
	public void click_on_reg_users_full_detail_link() {
		dashboard.regUserButton();
	}

	@Then("admin should be navigated to Registered Users Page")
	public void admin_should_be_navigated_to_registered_users_page() {
		dashboard.checkRegUser();
		driver.navigate().back();
	}

	@When("admin click on Listed Vehicles Full Detail link")
	public void admin_click_on_listed_vehicles_full_detail_link() {
		dashboard.listVehButton();
	}

	@Then("admin should be navigated to Manage Vehicles Page")
	public void admin_should_be_navigated_to_manage_vehicles_page() {
		dashboard.checkManVeh();
		driver.navigate().back();
	}

	@When("admin click on Total Bookings Full Detail link")
	public void admin_click_on_total_bookings_full_detail_link() {
		dashboard.totalBookButton();
	}

	@Then("admin should be navigated to Manage Bookings Page")
	public void admin_should_be_navigated_to_manage_bookings_Page() {
		dashboard.checkManBook();
		driver.navigate().back();
	}

	@When("admin click on Listed Brands Full Detail link")
	public void admin_click_on_listed_brands_full_detail_link() {
		dashboard.listBrandButton();
	}

	@Then("admin should be navigated to Manage Brands Page")
	public void admin_should_be_navigated_to_manage_brands_Page() {
		dashboard.checkListBrand();
		driver.navigate().back();
	}

	@When("admin click on Subscibers Full Detail link")
	public void admin_click_on_subscibers_full_detail_link() {
		dashboard.subscibersButton();
	}

	@Then("admin should be navigated to Manage Subscribers Page")
	public void admin_should_be_navigated_to_manage_subscribers_Page() {
		dashboard.checkSubscibers();
		driver.navigate().back();
	}

	@When("admin click on Queries Full Detail link")
	public void admin_click_on_queries_full_detail_link() {
		dashboard.queriesButton();
	}

	@Then("admin should be navigated to Manage Contact Us Queries Page")
	public void admin_should_be_navigated_to_manage_contact_us_queries_Page() {
		dashboard.checkQueries();
		driver.navigate().back();
	}

	@When("admin click on Testimonials Full Detail link")
	public void admin_click_on_testimonials_full_detail_link() {
		dashboard.testimonialButton();
	}

	@Then("admin should be navigated to Manage Testimonials Page")
	public void admin_should_be_navigated_to_manage_testimonials_Page() {
		dashboard.checktestimonial();
		driver.navigate().back();
	}

	@When("admin click on Account option")
	public void admin_click_on_account_option() {
		dashboard.clickAccount();
	}

	@When("clicks on Logout")
	public void clicks_on_logout() {
		dashboard.clickLogout();
	}

	@When("clicks on Change Password")
	public void clicks_on_change_password() {
		dashboard.clickChangePassword();
	}

	@Then("change password page will be displayed")
	public void change_password_page_will_be_displayed() {
		dashboard.checkChangePassPage();
	}

	@When("admin fills the form")
	public void admin_fills_the_form() {
		dashboard.checkPasswordField("Test@12345");
		dashboard.checkNewPassword("abc");
		dashboard.checkConfirmPassword("abc");

	}

	@When("admin click on save changes button")
	public void admin_click_on_save_changes_button() {
		dashboard.clickSaveChanges();
	}

	@Then("password changed success message will be displayed")
	public void password_changed_success_message_will_be_displayed() {
		String msg = dashboard.getSuccessPassMsg();
		System.out.println(msg);
	}

	@Then("admin navigates to Admin|SignIn page")
	public void admin_navigates_to_admin_sign_in_page() {
		loginPage.adminSignInPage();
	}

	@Then("popup message will be displayed")
	public void popup_message_will_be_displayed() {
		String message = dashboard.getValidationMsg();
		System.out.println(message);
	}

	@When("admin click on Brands")
	public void admin_click_on_brands() {
		createBrand.clickBrands();
	}

	@When("click on Create Brand")
	public void click_on_create_brand() {
		createBrand.clickCreateBrands();
	}

	@Then("admin will navigates to create Brand Page")
	public void admin_will_navigates_to_create_brand_page() {
		createBrand.getpageTitle();
	}

	@When("admin enter Brand name in the text field")
	public void i_enter_brand_name_in_the_text_field() {
		createBrand.enterBrandName("BMW");
	}

	@When("admin click on Submit button")
	public void admin_click_on_submit_button() {
		createBrand.clickSubmit();
	}

	@Then("Success message will be displayed")
	public void success_message_will_be_displayed() {
		String msg = createBrand.getMessage();
		System.out.println(msg);
	}

	@When("admin navigates to {string}")
	public void admin_navigates_to(String url) {
		driver.get(url);
	}

	@When("click on select brand dropdown menu")
	public void click_on_select_brand_dropdown_menu() {
		createBrand.clickSelectBrandDropdown();
	}

	@When("click on select brand dropdown")
	public void click_on_select_brand_dropdown() {
		manageBrand.clickSelectBrand();
	}

	@Then("verify the brand name")
	public void verify_the_brand_name() {
		createBrand.findYourCar();
	}

	@Then("verify the updated brand name")
	public void verify_the_updated_brand_name() {
		manageBrand.findBrandName();
	}

	@Then("alert message will be displayed")
	public void alert_message_will_be_displayed() {
		String message = createBrand.getValMessage();
		System.out.println(message);
	}

	@When("click on Manage Brands")
	public void click_on_manage_brands() {
		manageBrand.clickManageBrand();
	}

	@Then("admin will navigate to Manage Brands Page")
	public void admin_will_navigate_to_manage_brands_page() {
		manageBrand.getManageBrandTitle();
	}

	@When("admin selects show entries")
	public void admin_selects_show_entries() {
		manageBrand.clickShowDropdown();
	}

	@When("admin search for the brand name")
	public void admin_search_for_the_brand_name() {
		manageBrand.enterSearchField("BENZ");
	}

	@Then("filtered result will be displayed")
	public void filtered_result_will_be_displayed() {
		// manageBrand.getSearchedBrandName();
		String fil_msg = manageBrand.getFilteredBrand();
		System.out.println(fil_msg);
	}

	@When("admin clicks on Next button")
	public void admin_clicks_on_next_button() {
		manageBrand.clickNextButton();
	}

	@When("Previous button")
	public void previous_button() {
		manageBrand.clickPreviousButton();
	}

	@Then("entries will be displayed")
	public void entries_will_be_displayed() {
		manageBrand.getEntries();
	}

	@When("admin click edit option in action")
	public void admin_click_edit_option_in_action() {
		manageBrand.clickEdit();
	}

	@Then("it navigates to Update Brand page")
	public void it_navigates_to_update_brand_page() {
		manageBrand.getUpdateBrandTitle();
	}

	@When("admin updates the brand name")
	public void admin_updates_the_brand_name() {
		manageBrand.enterUpdateBrandName("Audi");
	}

	@When("click on submit button")
	public void click_on_submit_button() {
		createBrand.clickSubmit();
	}

	@Then("the success message will be displayed")
	public void the_success_message_will_be_displayed() {
		String message = manageBrand.getSuccessMessage();
		System.out.println(message);
	}

	@Then("Updation date also displayed")
	public void Updation_date_also_displayed() {
		driver.navigate().back();
		driver.navigate().back();
		manageBrand.getUpdationDate();
	}

	@When("admin click on delete option in action")
	public void admin_click_on_delete_option_in_action() {
		manageBrand.clickDelete();
	}

	@Then("confirm alert displays and accept it")
	public void confirm_alert_displays_and_accept_it() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Then("success page updated message will be displayed")
	public void success_page_updated_message_will_be_displayed() {
		String suc_msg = manageBrand.getSuccessUpdateMessage();
		System.out.println(suc_msg);
	}

	@Then("confirm alert displays and reject it")
	public void confirm_alert_displays_and_reject_it() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	@Then("admin will be on manage brand page")
	public void admin_will_be_on_manage_brand_page() {
		manageBrand.getManageBrandTitle();
	}
}
