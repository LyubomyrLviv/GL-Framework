import model.Pet;
import model.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


public class PetsTest extends BaseTest {

    static List<Pet> pets = new ArrayList<>();

    @BeforeAll
    static void doSomething()
    {
        for (Status petStatus: Status.values()) {
            Pet pet = Pet.getDefaultPet(petStatus);
            pets.add(pet);
            apiService.addPet(pet);
        }

        //------->   BEFORE ADDING THE LIST OF "pets" <-------
//        final Pet availablePet = Pet.getDefaultPet(Pet.AVAILABLE_STATUS);
//        final Pet pendingPet = Pet.getDefaultPet(Pet.PENDING_STATUS);
//        final Pet soldPet = Pet.getDefaultPet(Pet.SOLD_STATUS);

    }

    @ParameterizedTest
    @MethodSource("getAllPetStatuses")
    void shouldReturnPetsByAvailableStatus(Status status){
        List<Pet> response = apiService.findPetsByStatus(status);
        assert response.size() > 0;
        Assertions.assertThat(response).hasSizeGreaterThan(0);
        Assertions.assertThat(response).allMatch(pet -> pet.getStatus().equals(status));

    }



// ------------> This test won't be needed anymore because we start using Test parametrization <---------------------------
//    @Test
//    void shouldReturnPetsByPendingStatus(){
//        final List<Pet> response = apiService.findPetsByStatus(Pet.PENDING_STATUS);
//        assert response.size() > 0;
//        Assertions.assertThat(response.stream().filter(pet -> !Objects.equals(pet.getStatus(), Pet.PENDING_STATUS))).hasSize(0);
//
//    }
//
//    @Test
//    void shouldReturnPetsBySoldStatus(){
//        final List<Pet> response = apiService.findPetsByStatus(Pet.SOLD_STATUS);
//        assert response.size() > 0;
//        Assertions.assertThat(response.stream().filter(pet -> !Objects.equals(pet.getStatus(), Pet.SOLD_STATUS))).hasSize(0);

//    }

//    @Test
//    void shouldBeAbleToAddPet()
//    {
//       final Pet defaultPet = Pet.getDefaultPet();
//       final Pet pet = apiService.addPet(defaultPet);
//       Assertions.assertThat(pet).isEqualTo(defaultPet);
//
//    }

    static Stream<Status> getAllPetStatuses()
    {
        return Arrays.stream(Status.values());
    }


}
