package spring.lab.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    long id;
    String email;
    String username;
}
