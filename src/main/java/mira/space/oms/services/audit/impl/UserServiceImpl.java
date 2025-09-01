package mira.space.oms.services.audit.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import mira.space.oms.data.model.crm.User;
import mira.space.oms.data.repository.crm.UserRepository;
import mira.space.oms.services.audit.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers(int count) {
        return userRepository.findAll().subList(0, count);
    }

    @Override
    public User getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found by id: " + id));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
