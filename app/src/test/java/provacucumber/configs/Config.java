package provacucumber.configs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import provacucumber.configs.suport.MangerConfig;
import provacucumber.configs.suport.ServerConfig;


public class Config {

    @Before
    public  void setup(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        ServerConfig propriedades = MangerConfig.getConfiguration();
        RestAssured.baseURI = String.format("%s:%d",propriedades.url(),propriedades.port());
        RestAssured.basePath= propriedades.path();

        RestAssured.requestSpecification  = new RequestSpecBuilder().
                setContentType(ContentType.JSON)
                .addHeader("Authorization",getToken()).build();
    }

    private String getToken() {
        return "grant access";
    }



}
