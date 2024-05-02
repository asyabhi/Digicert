package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    @FindBy(xpath = "//th[text()='Title']")
    WebElement titleHeader;

    @FindBy(xpath = "//th[text()='Episode']")
    WebElement episodeHeader;

    @FindBy(xpath = "//th[text()='Director']")
    WebElement directorHeader;

    @FindBy(css = "table tbody")
    WebElement movieTable;

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void clickTitleHeader(){
        titleHeader.click();
    }

    public void clickEpisodeHeader(){
        episodeHeader.click();
    }

    public void clickDirectorHeader(){
        directorHeader.click();
    }

    public void sortTable(String sortBy){
        switch (sortBy){
            case "Title":
                clickTitleHeader();
                break;
            case "Episode":
                clickEpisodeHeader();
                break;
            case "Director":
                clickDirectorHeader();
                break;
        }
    }

    public void checkLastMovieName(String movieName){
        List<WebElement> movieElements = movieTable.findElements(By.cssSelector("td:nth-child(1)"));
        String[] movieNames = new String[6];
        for(int i=0; i<movieElements.size(); i++){
            movieNames[i] = movieElements.get(i).getText();
        }

        Assert.assertEquals(movieName, movieNames[5]);
    }

}
