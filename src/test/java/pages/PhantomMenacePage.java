package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.Objects;

public class PhantomMenacePage {

    @FindBy(css = "div[class='layout_lists__rBjPn'] div:nth-child(2) ul")
    WebElement planetsList;

    WebDriver driver;

    public PhantomMenacePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public boolean checkPlanets(String planetName){
        List<WebElement> species = planetsList.findElements(By.cssSelector("li"));
        boolean flag = false;

        for (WebElement webElement : species) {
            if (Objects.equals(planetName, webElement.getText())) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
