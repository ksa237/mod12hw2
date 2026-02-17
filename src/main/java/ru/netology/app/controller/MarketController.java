package ru.netology.app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.app.service.MarketService;

@RestController
@RequestMapping("/products")
public class MarketController {

    private final MarketService service;

    public MarketController(MarketService service) {
        this.service = service;
    }


    @GetMapping("/fetch-product")
    public ResponseEntity<String> showProductName(@RequestParam("name") String name){
        return ResponseEntity.ok(service.showProductName(name));
    }

    @GetMapping("/ping")
    public ResponseEntity<String> showOne(){
        return ResponseEntity.ok("ping - ok");
    }

}
