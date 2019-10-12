package com.hhs.boodschapp.service;

import com.hhs.boodschapp.model.entity.response.DarthVaderResponse;
import com.hhs.boodschapp.model.repository.CustomerRepository;
import com.hhs.boodschapp.model.repository.ProductRepository;
import com.hhs.boodschapp.model.repository.ShoppingListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DarthVaderServiceImpl implements DarthVaderService {
    private CustomerRepository customerRepository;
    private ShoppingListRepository shoppingListRepository;
    private ProductRepository productRepository;

    @Override
    public DarthVaderResponse clearDatabase() {
        DarthVaderResponse darthVaderResponse = new DarthVaderResponse();
        darthVaderResponse.setProductsDeleted(productRepository.findAll().size());
        darthVaderResponse.setShoppingListsDeleted(shoppingListRepository.findAll().size());
        darthVaderResponse.setCustomersDeleted(customerRepository.findAll().size());
        darthVaderResponse.setStatusMessage("Don’t be too proud of this technological terror you’ve constructed. The ability to destroy a planet is insignificant next to the power of the Force.");

        productRepository.deleteAll();
        shoppingListRepository.deleteAll();
        customerRepository.deleteAll();

        return darthVaderResponse;
    }
}
