import model.Document;
import repository.DataStorage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Document document1 = new Document("News For Kids", "The content are rendered for kids");
        Document document2 = new Document("News For Adult", "This content are rendered for Adult");
        Document document3 = new Document("News For Old", "This content are rendered for Old");
        Document document4 = new Document("Kids Playing", "This content are game for kids");
        Document document5 = new Document("Adult Playboy", "This content is 18+ for Adult");

        DataStorage.insertAll(document1, document2, document3, document4, document5);

        List<Document> documents = DataStorage.search("Kids");

        if (documents != null)  documents.forEach(document -> System.out.println("Title Is: " + document.getTitle() + " And Content Is: " + document.getContent()));


    }
}