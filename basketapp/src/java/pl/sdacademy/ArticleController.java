package pl.sdacademy;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "ArticleController", value = "/")
public class ArticleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Article> availableProducts = new ArticleService().getAvailableArticles();

        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Shop</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\">\n" +
                "    <label for=\"articleId\">Article:</label>\n" +
                "    <select id=\"articleId\" name=\"articleId\">\n" +
                availableProducts.stream()
                        .map(product -> "<option value=\"" + product.getId() + "\">" + product.getName() + "</option>")
                        .collect(Collectors.joining()) +
                "    </select>\n" +
                "    <br>\n" +
                "    <label for=\"quantity\">Quantity:</label>\n" +
                "    <input id=\"quantity\" max=\"10\" min=\"1\" name=\"quantity\" type=\"number\">\n" +
                "    <br>\n" +
                "    <input type=\"submit\" value=\"Add\">\n" +
                "    </form>\n" +
                "<br>\n" +
                "<a href=\"/basket\">Go to basket</a>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long articleId = Long.parseLong(request.getParameter("articleId"));
        BigDecimal quantity = new BigDecimal(request.getParameter("quantity"));

        String productName = new ArticleService().getAvailableArticles().stream()
                .filter(article -> article.getId() == articleId)
                .findFirst()
                .orElseGet(null)
                .getName();
        System.out.println(productName + " x " + quantity);

        Map<Long, BigDecimal> basket = (Map<Long, BigDecimal>) request.getSession().getAttribute("selectedArticles");
        if (basket == null) {
            basket = new HashMap<>();
            request.getSession().setAttribute("selectedArticles", basket);
        }
        basket.compute(articleId, (k, value) -> (value == null) ? quantity : value.add(quantity));

        response.getWriter().println("<html><body" +
                "<p>Article " + productName + " dodawanie do koszyka</p>" +
                "<p>Ilosc: " + productName + " kup wiecej...</p>" +
                "<a href=\"shop\">Add another...</a>" +
                "<br>" +
                "<a href=\"shop\">back to the basket</a>" +
                "</body></html>");







//        System.out.println("Koszyk:");
//        System.out.printf("    current product being added: %s/artId: %s%n", productName, articleId);
//        basket.forEach((k, v) -> System.out.println("k (artId): " + k + " / v (ile): " + v));
//        System.out.println(basket);
    }




}