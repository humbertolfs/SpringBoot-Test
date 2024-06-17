package dio.aula;

import dio.aula.repository.UserRepository;
import dio.aula.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("John Doe");
        user.setUsername("john.doe");
        user.setPassword("123456");

        repository.save(user);

        User user2 = new User();
        user2.setName("Maria Joana");
        user2.setUsername("mary.joan");
        user2.setPassword("123456");

        repository.save(user2);

        for (User u : repository.findAll()) {
            System.out.println(u);
        }
    }

}
