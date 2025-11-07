package mk.ukim.finki.wp.lab.service;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.repository.InMemoryDishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChefServiceImpl implements ChefService{
    private final DishRepository dishRepo;
    private final ChefRepository chefRepo;

    public ChefServiceImpl(DishRepository dishRepo, ChefRepository chefRepo) {
        this.dishRepo = dishRepo;
        this.chefRepo = chefRepo;
    }

    @Override
    public List<Chef> listChefs(){
        return chefRepo.findAll();
    }

    @Override
    public Chef findById(Long id){
        return chefRepo.findById(id).orElse(null);
    }

    @Override
    public Chef addDishToChef(Long chefId,String dishId){
        Chef chef=findById(chefId);
        Dish dish=dishRepo.findByDishId(dishId);

        chef.getDishes().add(dish);
        return chefRepo.save(chef);
    }
    @PostConstruct
    public void initData() {
        if (chefRepo.findAll().isEmpty() && dishRepo.findAll().isEmpty()) {
            Chef chef1 = new Chef(1L, "Gordon", "Ramsay", "British chef", new ArrayList<>());
            Chef chef2 = new Chef(2L, "Christine", "Ha", "Blind chef", new ArrayList<>());
            InMemoryDishRepository dishRepoImpl = (InMemoryDishRepository) dishRepo;
            Dish dish1 = new Dish("First Dish: ", "Tavche Gravche", "Macedonian", 30);
            Dish dish2 = new Dish("Second Dish: ", "Gyro", "Greek", 20);
            Dish dish3 = new Dish("Third Dish: ", "Burger", "American", 25);
            dishRepoImpl.save(dish1);
            dishRepoImpl.save(dish2);
            dishRepoImpl.save(dish3);
            chefRepo.save(chef1);
            chefRepo.save(chef2);

        }
    }
}
