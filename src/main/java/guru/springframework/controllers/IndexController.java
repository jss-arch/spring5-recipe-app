package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnityOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    public IndexController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage() {

        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UnityOfMeasure> optionalUnityOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id is: " + optionalCategory.get().getId());
        System.out.println("Unity id is: " + optionalUnityOfMeasure.get().getId());

        return "index";
    }


}
