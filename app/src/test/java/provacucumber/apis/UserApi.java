package provacucumber.apis;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import provacucumber.domain.User;

import static io.restassured.RestAssured.given;

public class UserApi {

    String CREATE_USER_ENDPOINT = "/v3/user";
    String SEARCH_USER_NAME = "/v3/user/{username}";

    public  void criarUsuario(User usuario){
        given().
                body(usuario).
                when().
                post(CREATE_USER_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK);
    }

    public Response verificarUsuarioNome(String nome){
       return given().
                pathParam("username",nome).
                when().
               log().all().
                get(SEARCH_USER_NAME);
    }

    public  void atuzalizarUsuarioNome(String nome,User usuario){
           given().
                pathParam("username",nome).
                when().
                   body(usuario).

                put(SEARCH_USER_NAME)
                   .then().statusCode(HttpStatus.SC_OK);
    }

}
