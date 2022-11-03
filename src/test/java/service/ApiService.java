package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import model.Status;

import java.util.Arrays;
import java.util.List;

public class ApiService {

    private static final String PET_ENDPOINT = "/pet";
    private static final String PETS_BY_STATUS_ENDPOINT = PET_ENDPOINT + "/findByStatus";
    private static final int OK_STATUS_CODE = 200;
    private final String SERVICE_URL;
    private final RequestSpecification specification;

    public ApiService(String applicationUrl)
    {
        SERVICE_URL = applicationUrl;
        specification = RestAssured.given()
                .baseUri(applicationUrl);
    }




    public List<Pet> findPetsByStatus(Status status) throws ApiException {

        Response response = RestAssured.given(specification)
                .queryParam("status", status.getValue())
                .get(PETS_BY_STATUS_ENDPOINT);

        validateResponse(response);
        Pet[] statuses = response.getBody()
                .as(Pet[].class);
 //     Before pressing some hot key to auto creation code above
//        Pet[] statuses = RestAssured.given(specification)
//                .queryParam("status", status.getValue())
//                .get(PETS_BY_STATUS_ENDPOINT)
//                .getBody().as(Pet[].class);

        return Arrays.asList(statuses);
    }


    public List<Pet> findPetsByStatus()
    {
        return findPetsByStatus();
    }


    public Pet addPet(Pet pet) throws ApiException {
         Response response = RestAssured.given(specification)
                .body(pet)
                .contentType(ContentType.JSON)
                .post(PET_ENDPOINT);

         validateResponse(response);

        return response.getBody()
                .as(Pet.class);
    }

    private void validateResponse(Response response) throws ApiException {

        if (response.statusCode() != OK_STATUS_CODE){
            throw new ApiException(response.statusCode(), response.body().asString());
        }

    }










//    public ApiResponse getSomething() throws ApiException {
//        //Before creating request specification
//        //return RestAssured.given().baseUri(SERVICE_URL).get(SERVICE_ENDPOINT).getBody().asString();
//        //After  request specification to avoid code dupliacation
//        //return RestAssured.given(specification).get(SERVICE_ENDPOINT).getBody().asString();
//
//        final Response response = RestAssured.given(specification).get(SERVICE_ENDPOINT_ONE);
//        //part of custom validation
//        //validateResponse(response);
//        //STANDART REST ASSURED VALIDATION
//        response.then().statusCode(OK_STATUS_CODE);
//        return response.as(ApiResponse.class);
//    }

    //Custom Validation by mentor
//    private void validateResponse(Response response) throws ApiException {
//        if (response.statusCode()!= OK_STATUS_CODE)
//        {
//            throw new ApiException(response.statusCode(), response.body().asPrettyString());
//        }
//    }


}
