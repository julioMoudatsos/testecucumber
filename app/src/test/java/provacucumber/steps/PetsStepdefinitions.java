package provacucumber.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import provacucumber.apis.PetApi;
import provacucumber.domain.Pet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class PetsStepdefinitions {
    Pet pet = Pet.builder().build();
    PetApi petApi;

    public PetsStepdefinitions() {
        petApi = new PetApi();
    }
    @Dado("Que eu consiga criar um pet com o status: {word}")
    public void queEuConsigaCriarUmPetComOStatusStatus(String status) {
        pet.setStatus(status);
        petApi.criarPet(pet);
    }
    @Entao("Eu verifico que eles esta como status {word} na lista de pets")
    public void euVerificoQueElesEstaComoStatusStatusNaListaDePets(String status) {
       Response petlist = petApi.getPetsByStatus(status);
        petlist.then().body("findAll{it.name.contains('Greguinho')}.name",is(Arrays.asList(pet.getName())));
    }
}
