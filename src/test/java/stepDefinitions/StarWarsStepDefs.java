package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EmpireStrikesBackPage;
import pages.HomePage;
import pages.PhantomMenacePage;

import java.util.concurrent.TimeUnit;

public class StarWarsStepDefs {

    WebDriver driver = null;

    HomePage home;
    EmpireStrikesBackPage empire;
    PhantomMenacePage phantom;

    @Given("I navigate to Star Wars App")
    public void iNavigateToStarWarsApp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.navigate().to("http://localhost:3000/");
    }

    @Given("I click on Title and sort the movies")
    public void iClickOnTitleAndSortTheMovies() {
        home = new HomePage(driver);

        home.sortTable("Title");
    }

    @Then("Last movie should be The Phantom Menace")
    public void lastMovieShouldBeThePhantomMenace() {
        home = new HomePage(driver);

        home.checkLastMovieName("The Phantom Menace");
        System.out.println("Last Movie Name is The Phantom Menace");

        driver.quit();
    }

    @Given("I click on The Empire Strikes Back")
    public void iClickOnTheEmpireStrikesBack() {
        home = new HomePage(driver);

        home.clickEmpireStrikesBack();
        
    }

    @Then("Species list should have Wookie")
    public void speciesListShouldHaveWookie() {
        empire = new EmpireStrikesBackPage(driver);

        boolean checkSpecies = empire.checkSpeciesList("Wookie");
        Assert.assertTrue(checkSpecies);

        driver.quit();
    }

    @Given("I click on The Phantom Menace")
    public void iClickOnThePhantomMenace() {
        home = new HomePage(driver);

        home.clickPhantomMenace();

    }

    @Then("Planet List should not have Camino")
    public void planetListShouldNotHaveCamino() {
        phantom = new PhantomMenacePage(driver);

        boolean planetPresent = phantom.checkPlanets("Camino");
        Assert.assertFalse(planetPresent);

        driver.quit();
    }
}
