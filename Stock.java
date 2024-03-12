package TD2;

import java.util.*;
public class Stock {
    private HashSet<Article> articlesMg = new HashSet<Article>();
    private HashMap<String, Integer> stockMg = new HashMap<String, Integer>();

    // permet d’ajouter un nouveau article à l’ensemble
    // articlesMg et de préciser sa quantité dans la table stockMg
    public boolean addNouvArticle(Article a, int qt) {
        if (stockMg.containsKey(a.getNom()))
            return false;
        articlesMg.add(a);
        stockMg.put(a.getNom(), qt);
        return true;
    }

    // retourne true si le nom de l’article donné a est en vente
    // dans le magasin, false sinon
    public boolean verifArticle(String a) {
        for (Article article : articlesMg) {
            if (article.getNom().equals(a)) {
                return true;
            }
        }
        return false;
    }

    // retourne l’article correspondant au nom donné a s’il
    // existe, null sinon
    public Article getArticle(String a) {
        for (Article article : articlesMg) {
            if (article.getNom().equals(a)) {
                return article;
            }
        }
        return null;
    }

    // supprime l’article correspondant au nom donné a de
    // articlesMg et stockMg
    public boolean removeArticle(String a) {
        if (!stockMg.containsKey(a)) {
            return false;
        }
        Iterator<Article> it = articlesMg.iterator();
        while (it.hasNext()) {
            Article article = it.next();
            if (article.getNom().equals(a)) {
                it.remove();
                stockMg.remove(a);
                return true;
            }
        }
        return false;
    }

    public int getQt(String a) {
        if (!stockMg.containsKey(a))
            return -1;
        else
            return stockMg.get(a);
    }

    // modifie la quantité en stock de l’article correspondant au
    // nom donné a
    public Boolean changeQt(String a, int i) {
        if (!stockMg.containsKey(a))
            return false;
        int qt = stockMg.get(a);
        qt = qt + i;
        if (qt < 0)
            return false;
        else
            stockMg.put(a, qt);
        return true;
    }

    // afficher le stock (stockMg) trié selon l’ordre
    // alphabétique des noms des articles.
    public void sortStock() {
        List<String> sortedKeys = new ArrayList<>(stockMg.keySet());
        Collections.sort(sortedKeys);
        for (String key : sortedKeys) {
            System.out.println(key + ": " + stockMg.get(key));
        }
    }
}
