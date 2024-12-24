package spring.lab.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.lab.domain.User;
import spring.lab.dto.user.UserRequestDto;
import spring.lab.mapper.UserMapper;
import spring.lab.repository.TicketRepository;
import spring.lab.repository.UserRepository;
import spring.lab.repository.entity.TicketEntity;
import spring.lab.repository.entity.UserEntity;
import spring.lab.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TicketRepository ticketRepository;

    @Override
    @Transactional
    public User createUser(UserRequestDto userRequestDto) {
        UserEntity newUser = UserEntity.builder()
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .username(userRequestDto.getUsername())
                .build();

        try {
            return userMapper.toUser(userRepository.save(newUser));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public User updateUser(Long id, UserRequestDto userRequestDto) {
        UserEntity user = userMapper.toUserEntity(findUserById(id));

        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());

        try {
            return userMapper.toUser(userRepository.save(user));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public String deleteUser(long id) {
        List<TicketEntity> tickets = ticketRepository.findTicketsByUserId(id);

        ticketRepository.deleteAll(tickets);

        try {
            userRepository.deleteById(id);
            return String.format("Deleted user with id %d deleted", id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userMapper.toUser(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }
}
