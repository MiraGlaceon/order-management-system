package mira.space.oms.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import mira.space.oms.data.model.crm.User;
import mira.space.oms.services.audit.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserService userService;

    public List<User> getUsers(final int count) {
        return userService.getUsers(count);
    }

    public User getUser(final int id) {
        return userService.getUser((long) id);
    }

}
