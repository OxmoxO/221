package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Курлык", "Махорович", "curlick@mail.ru", new Car("Хлебо_Возка", 8)));
      userService.add(new User("Вырлай", "Аппоний", "virlay@mail.ru", new Car("Мусоро_Возка", 15)));
      userService.add(new User("Уважаемый", "Почтенный", "respectfull@mail.ru", new Car("Шмаро_Возка", 71)));
      userService.add(new User("Кальпулька", "Вуй", "calpulka@mail.ru", new Car("Медико_Менто_Возка", 89)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}