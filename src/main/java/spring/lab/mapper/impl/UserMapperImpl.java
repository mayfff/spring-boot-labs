package spring.lab.mapper.impl;

import org.springframework.stereotype.Component;
import spring.lab.domain.User;
import spring.lab.dto.user.UserResponseDto;
import spring.lab.mapper.UserMapper;
import spring.lab.repository.entity.UserEntity;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public UserResponseDto toUserResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    @Override
    public UserEntity toUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
