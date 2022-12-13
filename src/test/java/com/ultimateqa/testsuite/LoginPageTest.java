package com.ultimateqa.testsuite;

import com.ultimateqa.pages.HomePage;
import com.ultimateqa.pages.LoginPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnSignInLink();
        String expectedMessage = "Welcome Back!";
        String actualMessage = homePage.getTextWelcomeBack();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");

    }

    @Test(groups = {"smoke", "regression"})
    public void usershouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enteremail("nimishapatel1987@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();

    }
}

