package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    public MainPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement signButton;

}
