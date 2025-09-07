package mira.space.oms.services.crm;

import mira.space.oms.data.model.crm.User;

import java.util.List;

public interface UserService {

    List<User> getUsers(int count);

    User getUser(Long id);

    User saveUser(User user);

}
