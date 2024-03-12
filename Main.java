package TD2;

public class Main {
    public static void main(String[] args) {

        Article article1 = new Article("Article 1", 50.0);
        Article article2 = new Article("Article 2", 250.0);
        Stock stock = new Stock();
        stock.addNouvArticle(article1, 50);
        stock.addNouvArticle(article2, 30);
        Facture facture = new Facture(stock);
        facture.addLigne(2, "Article 1");
        facture.addLigne(1, "Article 2");
        System.out.println("Total amount: " + facture.getMontantTotal());
    }
}
