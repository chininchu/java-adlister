package Models;

import java.io.Serializable;

public class Quote implements Serializable {

    private long id;

    // Including an author property instead of a foreign key

    private Author author;

    private String content;


    public Quote(long id, Author author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
