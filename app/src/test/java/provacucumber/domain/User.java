package provacucumber.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @Builder.Default
    private int id = 101;
    @Builder.Default
    private String username = "Julio" ;
    @Builder.Default
    private String firstName = "Julio";
    @Builder.Default
    private String lastName = "Moudatsos";
    @Builder.Default
    private String email = "Julio@gmail.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "819999999";
    @Builder.Default
    private int userStatus = 1;
}
