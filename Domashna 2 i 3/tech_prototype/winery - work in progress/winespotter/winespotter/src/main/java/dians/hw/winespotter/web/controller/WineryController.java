package dians.hw.winespotter.web.controller;
import dians.hw.winespotter.model.Winery;
import dians.hw.winespotter.service.WineryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class WineryController {

    private final WineryService wineryService;

    public WineryController(WineryService wineryService) {
        this.wineryService = wineryService;
    }

    @GetMapping
    String getHomePage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        else{
            model.addAttribute("hasError",false);
        }
        model.addAttribute("wineries",wineryService.findAll());
        return "Home";
    }

    @PostMapping
    String getSearch(@RequestParam String winery,@RequestParam String search, Model model){
        List<Winery> wineriesByName = wineryService.findByNameContains(winery);
        List<Winery> wineriesByCity = wineryService.findByCitiesContains(winery);
        if(!wineriesByName.isEmpty() && search.equals("name")){
            model.addAttribute("wineriesSearch",wineriesByName);
            return "Home";
        }
        else if(!wineriesByCity.isEmpty() && search.equals("city")){
            model.addAttribute("wineriesSearch",wineriesByCity);
            return "Home";
        }
        else{
            return "redirect:/home?error=Winery+Not+Found";
        }
    }


}
