package space.irsi7.scheduleApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import space.irsi7.scheduleApp.dao.UserDAO;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserDAO userDAO;

    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model) {
        // Получим всех users из DAO
        model.addAttribute("users", userDAO.index());
        return "users/index";
    }
    @GetMapping("/{id}")
    public String show ( @PathVariable("id") int id, Model model){
        // Получим одного человека по id из DAO
        model.addAttribute("user", userDAO.show(id));
        return "users/show";
    }
}
