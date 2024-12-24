package spring.lab.service;

import spring.lab.domain.User;
import spring.lab.dto.user.UserRequestDto;

public interface UserService {
    User createUser(UserRequestDto userRequestDto);

    User updateUser(Long id, UserRequestDto userRequestDto);

    String deleteUser(long id);

    User findUserById(Long id);
}
