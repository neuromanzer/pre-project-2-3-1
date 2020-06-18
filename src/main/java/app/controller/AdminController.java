package app.controller;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import app.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public ModelAndView adminPage() {
        List<User> users = userService.getAllUsers();
        ModelAndView mav = new ModelAndView("/admin/admin_page");
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping(value = "/admin/add",method = RequestMethod.GET)//GET method
    public String addUserForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "admin/add_page";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String saveUserAction(User user) {//no ModelAttribute
        if (!userService.validateUser(user.getLogin())) {
            userService.addUser(user);
            return "redirect:/admin";
        }
        return "/admin/add_user_exist_page";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public ModelAndView editUserForm(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("admin/edit_page");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String editUserAction(User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    /*@RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String editUserAction(User user) {
        if (!userService.validateUser(user.getLogin())) {
            userService.updateUser(user);
            return "redirect:/admin";
        }
        return "/admin/edit_user_exist_page";
    }*/

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ModelAndView deleteUserForm(@RequestParam Long id) {
        ModelAndView mav = new ModelAndView("admin/delete_page");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/admin/delete/save", method = RequestMethod.POST)
    public String deleteUserAction(User user) {
        userService.deleteUser(user.getId());
        return "redirect:/admin";
    }
}
