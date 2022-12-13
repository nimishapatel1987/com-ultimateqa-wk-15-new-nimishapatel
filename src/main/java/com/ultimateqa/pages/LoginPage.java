package com.ultimateqa.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "user[email]")
    WebElement Email;

    @CacheLookup
    @FindBy(name = "user[password]")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement signinButton;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email or password.')]")
    WebElement errorMessage;

    public void enteremail(String userNameText) {
        Reporter.log("Email" + Email.toString());
        sendTextToElement(Email, userNameText);
    }

    public void enterPassword(String passwordText) {
        Reporter.log("password" + password.toString());
        sendTextToElement(password, passwordText);
    }

    public void clickOnLoginButton() {
        Reporter.log("signinButton" + signinButton.toString());
        clickOnElement(signinButton);
    }

    public String getErrorMessage() {
        Reporter.log("getErrorMessage" + errorMessage.toString());
        CustomListeners.test.log(Status.PASS, "getErrorMessage");
        return getTextFromElement(errorMessage);
    }
}
