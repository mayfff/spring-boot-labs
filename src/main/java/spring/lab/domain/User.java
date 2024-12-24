package spring.lab.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    long id;
    String email;
    String password;
    String username;
}
