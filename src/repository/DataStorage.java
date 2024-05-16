package repository;

import model.Document;

import java.util.*;
import java.util.stream.Collectors;

public class DataStorage{

    private static final Map<String, List<Document>> indexTable = new HashMap<>();


    public static List<Document> search(String sentence) {
        if (sentence.isBlank() || sentence.isEmpty()) return null ;
        String[] terms = sentence.split("\\s+");
        List<Document> documents = indexTable.get(terms[0]);

        for (int i = 1; i < terms.length; i++){
            documents = intersection(documents, indexTable.get(terms[i]));
        }

        return documents;
    }

    public static void insert(Document document) {
        String title = document.getTitle();

        String[] terms = title.split("\\s+");

        for (String term : terms){
            List<Document> belongDocuments = indexTable.containsKey(term) ? indexTable.get(term) : new ArrayList<>();
            belongDocuments.add(document);
            indexTable.put(term, belongDocuments);
        }
    }

    public static void insertAll(Document ... documents){
        for (Document document : documents) {
            insert(document);
        }
    }

    private static List<Document> intersection(List<Document> source, List<Document> target){
        Set<Document> indexDocuments;
        if(source.size() > target.size()){
            indexDocuments = new HashSet<>(target);
            return source.stream().filter(indexDocuments::contains).collect(Collectors.toList());
        } else{
            indexDocuments = new HashSet<>(source);
            return target.stream().filter(indexDocuments::contains).collect(Collectors.toList());
        }
    }
}
