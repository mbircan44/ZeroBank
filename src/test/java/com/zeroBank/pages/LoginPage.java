package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement username;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(css = "#login_form>div:nth-of-type(1)")
    public WebElement loginAlert;

    public void login(String user,String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }


}
