package dians.hw.winespotter.web.controller;

        import dians.hw.winespotter.model.User;
        import dians.hw.winespotter.model.exceptions.InvalidUserCredentialsException;
        import dians.hw.winespotter.service.AuthenticationService;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        // You can add model attributes if needed
        return "Log-in";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {
        try {
            User user = authenticationService.login(username, password);
            // Add user to the session or perform other actions if needed
            return "redirect:/home";
        } catch (InvalidUserCredentialsException ex) {
            model.addAttribute("hasErrors", true);
            model.addAttribute("error", ex.getMessage());
            return "Log-in";
        }
    }
}