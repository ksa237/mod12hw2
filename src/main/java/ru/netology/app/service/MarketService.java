package ru.netology.app.service;

import org.springframework.stereotype.Service;
import ru.netology.app.repository.MarketRepository;

@Service
public class MarketService {

    private final MarketRepository repository;

    public MarketService(MarketRepository repository) {
        this.repository = repository;
    }

    public String showProductName(String name) {
        return repository.getProductName(name);
    }
}
