package mk.ukim.finki.wp.labaratoriska233155.service.interfaces;

import mk.ukim.finki.wp.labaratoriska233155.model.Chef;

import java.util.List;

public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId,String dishId);
}
