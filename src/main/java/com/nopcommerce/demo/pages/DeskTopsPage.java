package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeskTopsPage extends Utility {


    @CacheLookup
    @FindBy(id = "products-orderby" )
    WebElement sortByTextField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='details']/child::h2/a")
    List<WebElement> allProductsOnPageLinks;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputer;



    public void selectSortByName(String text){
        Reporter.log("Select SortBy" + sortByTextField.toString());
        selectByVisibleTextFromDropDown(sortByTextField, text);
        CustomListeners.test.log(Status.PASS,"Select SortBy" + text);
    }



    public void addBuildYourOwnComputerProductInCart(){
        Reporter.log("Click on build your own computer" + buildYourOwnComputer.toString());
        clickOnElement(buildYourOwnComputer);
        CustomListeners.test.log(Status.PASS,"Click on build your own computer");

    }


    public void verifySortedElementsInReverseOrder() {
        Reporter.log("Get list of products" + allProductsOnPageLinks.toString());
        List<WebElement> elements = allProductsOnPageLinks;
        ArrayList<String> originalElementList = new ArrayList<>();
        for (WebElement e : elements) {
            originalElementList.add(e.getText());
        }
        System.out.println(originalElementList);
        // Sort By Reverse order
        Collections.reverse(originalElementList);
        System.out.println(originalElementList);

        // After filter Z -A Get all the products name and stored into array list
        elements = allProductsOnPageLinks;
        ArrayList<String> afterSortByReverseList = new ArrayList<>();
        for (WebElement e : elements) {
            afterSortByReverseList.add(e.getText());
        }
        System.out.println(afterSortByReverseList);
        CustomListeners.test.log(Status.PASS,"Get list of products" );
    }





    public void selectProductByName(String product) {
        List<WebElement> products = allProductsOnPageLinks;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) {
        Reporter.log("Select sortBy option" + sortByTextField.toString());
        selectByVisibleTextFromDropDown(sortByTextField, option);
        CustomListeners.test.log(Status.PASS,"Select sortBy option" + option);
    }


}
