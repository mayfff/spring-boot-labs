package spring.lab.mapper;

import spring.lab.domain.User;
import spring.lab.dto.user.UserResponseDto;
import spring.lab.repository.entity.UserEntity;

public interface UserMapper {
    User toUser(UserEntity entity);

    UserResponseDto toUserResponseDto(User user);

    UserEntity toUserEntity(User user);
}
