package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("all_users")
    public String mainList(Model model) {
        List<User> list = userService.getUsers();
        model.addAttribute("listUser", list);
        return "all_users";
    }

    @RequestMapping("createUser")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/all_users";
    }

    @RequestMapping("info_user")
    public String infoUser(Model model) {
        User user = new User();
        model.addAttribute("info_user", user);
        return "save_user";
    }

    @RequestMapping("updateUser/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        User user = userService.update(id);
        model.addAttribute("info_user", user);
        return "save_user";
    }

    @RequestMapping("anigilation_user_in_hell/{id}")
    public String anigilation(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/all_users";
    }
}
