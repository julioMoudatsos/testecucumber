package provacucumber.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import provacucumber.apis.UserApi;
import provacucumber.domain.User;

import static org.hamcrest.Matchers.is;

public class UserStepdefinitions {

    User usuario = User.builder().build();
    UserApi userApi;

    public UserStepdefinitions() {
        userApi = new UserApi();
    }

    @Dado("Que eu consiga criar um usuario com {word} e {int}")
    public void queEuConsigaCriarUmUsuarioComNomeEId(String nome , int id) {
        usuario.setId(id);
        usuario.setUsername(nome);
        userApi.criarUsuario(usuario);
    }

    @Quando("eu tiver um usuario criado verifico que ele esta na nossa basse de dados pelo {word} e {int}")
    public void euTiverUmUsuarioCriadoVerificoQueEleEstaNaNossaBasseDeDadosPeloNomeEId(String nome , int id) {
       Response resposta = userApi.verificarUsuarioNome(nome);
       resposta.then().body("id",is(id));
    }

    @Entao("eu atualizo esse usuario para seu {word}")
    public void euAtualizoEsseUsuarioParaSeuNovo(String nome) {
        String nomeAntigo = usuario.getUsername();
        usuario.setUsername(nome);
        userApi.atuzalizarUsuarioNome(nomeAntigo,usuario);
    }

    @E("verifico que o nome foi alterado para seu {word}")
    public void verificoQueONomeFoiAlteradoParaSeuNovo(String nome) {
        Response resposta = userApi.verificarUsuarioNome(nome);
        resposta.then().body("id",is(usuario.getId()));
    }
}
