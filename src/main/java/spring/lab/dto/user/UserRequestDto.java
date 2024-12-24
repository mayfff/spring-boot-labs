package spring.lab.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    @NotBlank(message = "Username is required")
    String username;

    @NotBlank(message = "Email is required")
    @Size(min = 8, message = "Password length must be more than 8")
    String email;

    @NotBlank(message = "Password is required")
    String password;
}
