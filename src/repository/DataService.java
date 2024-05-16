package repository;

import model.Document;

import java.util.List;

public interface DataService {
    List<Document> search(String terms);

    void insert(Document document);
}
