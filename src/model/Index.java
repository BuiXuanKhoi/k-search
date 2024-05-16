package model;

import java.util.Set;

public class Index {
    private String representWord;
    private Set<Document> documentSet;

    public Index(String representWord, Set<Document> documentSet) {
        this.representWord = representWord;
        this.documentSet = documentSet;
    }

    public String getRepresentWord() {
        return representWord;
    }

    public void setRepresentWord(String representWord) {
        this.representWord = representWord;
    }

    public Set<Document> getDocumentSet() {
        return documentSet;
    }

    public void setDocumentSet(Set<Document> documentSet) {
        this.documentSet = documentSet;
    }
}
