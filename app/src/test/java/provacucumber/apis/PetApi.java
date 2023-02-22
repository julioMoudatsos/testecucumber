package provacucumber.apis;

import java.util.List;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import provacucumber.domain.Pet;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PetApi {
   private final String FIND_PETS_BY_STATUS_ENDPOINT = "v3/pet/findByStatus?status={status}";
   private final String PET_ENDPOINT = "v3/pet/{id}";
  private   final String CREATE_PET_ENDPOINT = "v3/pet";


    public Pet criarPet(Pet pet) {
        return given().
                body(pet).
                when().
                post(CREATE_PET_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK).
                extract().body().as(Pet.class);
    }

    public Response getPetsByStatus(String status) {
        return given().
                pathParam("status", status).
                when().

                get(FIND_PETS_BY_STATUS_ENDPOINT);

    }

    public void deletarPet(int id) {
         given().
                pathParam("id",id).
                when().
                delete(PET_ENDPOINT)
                .then()
                 .log().all()
                .statusCode(200);

    }
}
