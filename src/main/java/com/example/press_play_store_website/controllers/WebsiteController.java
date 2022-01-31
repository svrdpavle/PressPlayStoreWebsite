package com.example.press_play_store_website.controllers;

import com.example.press_play_store_website.entities.tables.StaffEntity;
import com.example.press_play_store_website.entities.views.FilmListEntity;
import com.example.press_play_store_website.repositories.FilmListRepository;
import com.example.press_play_store_website.repositories.StaffRepository;
import com.example.press_play_store_website.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebsiteController {
    private final FilmListRepository filmListRepository;
    private final StaffRepository staffRepository;

    private final StaffService staffService = new StaffService();
    //private final FilmService filmService = new FilmService();

    @Autowired
    public WebsiteController(FilmListRepository filmListRepository, StaffRepository staffRepository) {
        this.filmListRepository = filmListRepository;
        this.staffRepository = staffRepository;
    }

    @GetMapping("/film")
    public String getAllFilms(Model model) {
        model.addAttribute("film", filmListRepository.findAll());
        return "film";
    }

    @GetMapping("/view-film/{id}")
    public String viewFilm(@PathVariable("id") Integer id, Model model) {
        FilmListEntity filmListEntity = filmListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Film ID: " + id));
        model.addAttribute("film", filmListEntity);
        return "view-film";
    }

    @GetMapping("/admin")
    public String getStaffAdminPage(Model model) {
        return "admin";
    }

    @GetMapping("/staff")
    public String getAllStaff(Model model) {
        model.addAttribute("staff", staffRepository.findAll());
        return "staff";
    }

    @GetMapping("/add-staff")
    public String addStaff(Model model) {
        StaffEntity staffEntity = new StaffEntity();
        model.addAttribute("staff", staffEntity);
        return "add-staff";
    }

    @PostMapping("/save-staff")
    public String saveStaff(@ModelAttribute("staff") StaffEntity staffEntity) {
        staffRepository.save(staffEntity);
        return "saved-staff";
    }

    @GetMapping("/edit-staff/{id}")
    public String editStaff(@PathVariable("id") Integer id, Model model) {
        StaffEntity staffEntity = staffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Staff ID: " + id));
        model.addAttribute("staff", staffEntity);
        return "edit-staff";
    }

    @GetMapping("/delete-staff/{id}")
    public String deleteStaff(@PathVariable("id") Integer id) {
        StaffEntity staffEntity = staffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Staff ID" + id));
        staffRepository.delete(staffEntity);
        return "deleted-staff";
    }

    @PostMapping("/update-staff/{id}")
    public String updateCustomer(@ModelAttribute("staff") StaffEntity updatedStaff,
                                 @PathVariable("id") Integer id) {
        StaffEntity staffEntity = staffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Staff ID: " + id));
        staffService.update(updatedStaff, staffEntity);
        staffRepository.save(staffEntity);
        return "index";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage() {
        return "access-denied";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
