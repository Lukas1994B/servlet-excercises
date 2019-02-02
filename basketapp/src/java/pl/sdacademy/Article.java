package pl.sdacademy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Article {


    private Long id;
    private String name;
    private BigDecimal price;

    public Article(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //        Map<String, String> articles = new HashMap<>();
//        articles.keySet().stream()
//                .map(key -> "<option value=\"" + key + "\">" + articles.get(key) + "</option>")
//                .collect(Collectors.joining());


    public BigDecimal getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}



