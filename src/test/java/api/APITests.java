package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests {

    String BASE_URL = "https://swapi.dev/api/";
    String FILMS = "films";
    int FILMS_COUNT = 6;
    String DIRECTOR = "Richard Marquand";
    String PRODUCER = "Gary Kurtz, Rick McCallum";

    JsonPath json;


    @Test
    public void getMovieCount() {
        Response response = given()
                .when()
                .get(BASE_URL + FILMS)
                .then()
                .statusCode(200)
                .extract()
                .response();

        json = response.jsonPath();
        Assert.assertEquals(json.getInt("count"), FILMS_COUNT);
    }

    @Test
    public void getThirdMovieDirector() {
        Response response = given()
                .pathParams("id", 3)
                .when()
                .get(BASE_URL + FILMS + "/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        json = response.jsonPath();
        Assert.assertEquals(json.getString("director"), DIRECTOR);

    }

    @Test
    public void getFifthMovieProducers() {
        Response response = given()
                .pathParams("id", 5)
                .when()
                .get(BASE_URL + FILMS + "/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        json = response.jsonPath();
        Assert.assertNotEquals(json.getString("producer"), PRODUCER);
    }

}
