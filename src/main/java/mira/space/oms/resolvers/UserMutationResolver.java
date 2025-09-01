package mira.space.oms.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import mira.space.oms.data.model.crm.User;
import mira.space.oms.services.audit.UserService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserService userService;

    public User createUser(final String login, final String password, final String nickname, final String email) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setEmail(email);
        return userService.saveUser(user);
    }
}
