package pl.sdacademy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

public class ArticleService {


    private Collection<Article> availableArticles = Arrays.asList(
            new Article(1L, "Beer", new BigDecimal(4.5)),
            new Article(2L, "Water", new BigDecimal(5.5)),
            new Article(3L,"Orange Juice", new BigDecimal(2.3)),
            new Article(4L, "Cola", new BigDecimal(4.3)),
            new Article(5L,"Soda", new BigDecimal(1.2))
    );
    
    public Collection<Article> getAvailableArticles() {
        return availableArticles;
    }

    public Article findArticleById(Long articleId){
        return availableArticles.stream()
                .filter(a ->a.getId().equals(articleId))
                .findFirst()
                .orElse(null);
    }


}