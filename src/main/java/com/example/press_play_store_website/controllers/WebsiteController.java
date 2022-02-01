package com.example.press_play_store_website.controllers;

import com.example.press_play_store_website.entities.tables.FilmEntity;
import com.example.press_play_store_website.entities.tables.StaffEntity;
import com.example.press_play_store_website.entities.views.FilmListEntity;
import com.example.press_play_store_website.repositories.CategoryRepository;
import com.example.press_play_store_website.repositories.FilmListRepository;
import com.example.press_play_store_website.repositories.FilmRepository;
import com.example.press_play_store_website.repositories.StaffRepository;
import com.example.press_play_store_website.services.FilmService;
import com.example.press_play_store_website.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebsiteController {
    private final FilmRepository filmRepository;
    private final FilmListRepository filmListRepository;
    private final CategoryRepository categoryRepository;
    private final StaffRepository staffRepository;

    private final StaffService staffService = new StaffService();
    private final FilmService filmService = new FilmService();

    @Autowired
    public WebsiteController(FilmRepository filmRepository, FilmListRepository filmListRepository, CategoryRepository categoryRepository, StaffRepository staffRepository) {
        this.filmRepository = filmRepository;
        this.filmListRepository = filmListRepository;
        this.categoryRepository = categoryRepository;
        this.staffRepository = staffRepository;
    }

    // film - views
    @GetMapping("/film-catalogue")
    public String getCatalogueOfFilms(Model model) {
        model.addAttribute("film", filmListRepository.findAll());
        return "film-catalogue";
    }

    @GetMapping("/view-film/{id}")
    public String viewFilm(@PathVariable("id") Integer id, Model model) {
        FilmListEntity filmListEntity = filmListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Film ID: " + id));
        model.addAttribute("film", filmListEntity);
        return "view-film";
    }

    // film - tables

    @GetMapping("/view-films")
    public String viewAllFilms(Model model) {
        model.addAttribute("film", filmRepository.findAll());
        return "view-films";
    }

    @GetMapping("/add-film")
    public String addFilm(Model model) {
        FilmEntity filmEntity = new FilmEntity();
        model.addAttribute("film", filmEntity);
        return "add-film";
    }

    @PostMapping("/save-film")
    public String saveFilm(@ModelAttribute("film") FilmEntity filmEntity) {
        filmRepository.save(filmEntity);
        return "saved-film";
    }

    @GetMapping("/edit-film/{id}")
    public String editFilm(@PathVariable("id") Integer id, Model model) {
        FilmEntity filmEntity = filmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Film ID: " + id));
        model.addAttribute("film", filmEntity);
        return "edit-film";
    }

    @GetMapping("/delete-film/{id}")
    public String deleteFilm(@PathVariable("id") Integer id) {
        FilmEntity filmEntity = filmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Film ID" + id));
        filmRepository.delete(filmEntity);
        return "deleted-film";
    }

    @PostMapping("/update-film/{id}")
    public String updateFilm(@ModelAttribute("film") FilmEntity updatedFilm,
                                 @PathVariable("id") Integer id) {
        FilmEntity filmEntity = filmRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Film ID: " + id));
        filmService.update(updatedFilm, filmEntity);
        filmRepository.save(filmEntity);
        return "admin";
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
        return "admin";
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
    public String home(Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/error")
    public String getErrorPage() {
        return "error";
    }

    @PostMapping("/search-results")
    public String getSearchResults(@ModelAttribute("categoryName") String categoryName, Model model) {
        List<FilmListEntity> foundCategoryFilms = new ArrayList<>();
        for (FilmListEntity filmListEntity: filmListRepository.findAll()) {
            if (filmListEntity.getCategory().equals(categoryName)) {
                foundCategoryFilms.add(filmListEntity);
            }
        }
        model.addAttribute("searchResults", foundCategoryFilms);
        return "search-results";
    }

}
