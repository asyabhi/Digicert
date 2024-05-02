package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.Objects;

public class EmpireStrikesBackPage {

    @FindBy(css = "section[class='layout_container__F8gUU'] div:nth-child(3) ul")
    WebElement speciesList;

    WebDriver driver;

    public EmpireStrikesBackPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public boolean checkSpeciesList(String specieName){
        List<WebElement> species = speciesList.findElements(By.cssSelector("li"));
        boolean flag = false;

        for (WebElement webElement : species) {
            if (Objects.equals(specieName, webElement.getText())) {
                flag = true;
                System.out.println(specieName + " is present in Species List");
                break;
            }
        }
        return flag;
    }
}
