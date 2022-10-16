package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.dao.JdbcIngredientRepository;
import tacos.pojo.Ingredient;

@Service
public class IngredientRepositoryService {
    @Autowired
    private JdbcIngredientRepository ingredientRepository;

    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }
}
