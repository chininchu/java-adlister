import Models.Album;
import Models.Author;
import Models.Quote;

public class BeanTest {


    public static void main(String[] args) {


        Album album = new Album(9033810, "Jay-z", "Watch the Throne", 2011, 10, "Hiphop");

        Author author = new Author(900890, "Charles", "Dickens");


        Quote quote = new Quote(9099090, author, "All our lives, we have seen our sister-women suffer, in themselves and in their children.\"");

        System.out.println(quote.getId() + " " + quote.getAuthor().getFirstName() + quote.getAuthor().getLastName() + " " + quote.getContent() + " ");


        System.out.println(album.getArtist() + album.getArtist() + album.getRecordName() + album.getReleaseDate() + Double.toString(album.getSales()) + album.getGenre());


        System.out.println(author.getFirstName() + author.getLastName());


    }
}
