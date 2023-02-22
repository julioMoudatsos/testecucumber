package provacucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import provacucumber.apis.PetApi;
import provacucumber.domain.Pet;

public class PetHooks {
    PetApi petApi;
    Pet pet = Pet.builder().build();
    public PetHooks() {
        petApi = new PetApi();
    }

    @After("@deletarPetCriado")
    public void deletarPetsCriados(){
        petApi.deletarPet(pet.getId());
    }
}
