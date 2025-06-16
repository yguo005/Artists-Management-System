import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import artists.IArtist;
import artists.Actor;
import artists.Musician;
import artists.Poet;

public class IArtistTest {

    String[] genre1 = {"Action", "SciFi", "Drama"};
    String[] genre2 = {"Rock", "Rock-Soul"};
    String[] genre3 = {"Comedy", "Romantic Comedy"};
    String[] genre4 = {"R&B", "Pop", "Rap"};
    String[] genre5 = {"Autobiographical Fiction"};

    String[] awards = {"Academy Award", "Golden Globe"};
    String[] awards2 = {"Pulitzer"};
    String[] awards3 = {"Emmy", "People's Choice"};
    String[] awards4 = {"Grammy", "American Music Award"};
    String[] awards5 = {"Grammy", "Billboard"};

    String[] movies = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};
    String[] movies3 = {"Bridesmaids", "Tammy", "Life of the Party", "Ghostbusters"};

    IArtist denzel;
    IArtist melissa;
    IArtist musician;
    IArtist musician2;
    IArtist poet;

    @BeforeEach
    public void setUp() throws IllegalArgumentException {
        denzel = new Actor("Denzel Washington", 67, genre1, awards, movies);
        melissa = new Actor("Melissa McCarthy", 52, genre3, awards3, movies3);

        musician = new Musician("Bruce Springsteen", 73, genre2, awards4,
                "Only the Strong Survive", "Columbia Records");

        musician2 = new Musician("Lizzo", 34, genre4, awards5,
                "Special", "Atlantic Records");
        poet = new Poet("Maya Angelou", 86, genre5, awards2, "Random House");
    }

    @Test
    public void testCreatedInstances() {
        String test = """
        My name is Denzel Washington
        My age is 67
        I am an ACTOR
        I make these types of movies: [Action, SciFi, Drama]
        I have acted in these movies: [Glory, Flight, Training Day, Book of Eli, Fences]""";
        String actualOutput = denzel.toString();
        System.out.println("Actual output: " + actualOutput);
        assertTrue(denzel.toString().equalsIgnoreCase(test));

        test = """
        My name is Melissa McCarthy
        My age is 52
        I am an ACTOR
        I make these types of movies: [Comedy, Romantic Comedy]
        I have acted in these movies: [Bridesmaids, Tammy, Life of the Party, Ghostbusters]""";
        String actualOutput2 = melissa.toString();
        System.out.println("Actual output: " + actualOutput2);
        assertTrue(melissa.toString().equalsIgnoreCase(test));

        test = """
        My name is Bruce Springsteen
        My age is 73
        I am an MUSICIAN
        I make these types of music: [Rock, Rock-Soul]
        My current album is: Only the Strong Survive
        My recording company is: Columbia Records""";
        String actualOutput3 = musician.toString();
        System.out.println("Actual output: " + actualOutput3);
        assertTrue(musician.toString().equalsIgnoreCase(test));

        test = """
        My name is Lizzo
        My age is 34
        I am an MUSICIAN
        I make these types of music: [R&B, Pop, Rap]
        My current album is: Special
        My recording company is: Atlantic Records""";
        String actualOutput4 = musician2.toString();
        System.out.println("Actual output: " + actualOutput4);
        assertTrue(musician2.toString().equalsIgnoreCase(test));


        test = """
        My name is Maya Angelou
        My age is 86
        I am an POET
        I make these types of poems: [Autobiographical Fiction]
        My publishing company is: Random House""";
        String actualOutput5 = poet.toString();
        System.out.println("Actual output: " + actualOutput5);
        assertTrue(poet.toString().equalsIgnoreCase(test));
    }


    @Test
    public void testReceiveAward() {
        String[] testAwards = {"Pulitzer", "Tony"};
        poet.receiveAward("Tony");
        assertArrayEquals(poet.getAwards(), testAwards);
    }

    @Test
    public void testGetAwards() {
        String[] testAwards = {"Academy Award", "Golden Globe"};
        assertArrayEquals(denzel.getAwards(), testAwards);
    }

    @Test
    public void testBadAge() {
        assertThrows(IllegalArgumentException.class,
                () -> new Musician("Bruce Springsteen", 129, genre2, awards4,
                        "Only the Strong Survive", "Columbia Records"));
    }

    @Test
    public void testBadAge2() {
        assertThrows(IllegalArgumentException.class,
                () -> new Musician("Bruce Springsteen", -1, genre2, awards4,
                        "Only the Strong Survive", "Columbia Records"));
    }

    @Test
    public void testBadName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Musician(null, 10, genre2, awards4,
                        "Only the Strong Survive", "Columbia Records"));
    }

    @Test
    public void testNullGenres(){
        assertThrows(IllegalArgumentException.class,
                () -> new Musician("Bruce Springsteen", 73, null, awards4,
                        "Only the Strong Survive", "Columbia Records"));
    }
    @Test
    public void testNullMoviesForActor() {
        assertThrows(IllegalArgumentException.class, () -> new Actor("Denzel Washington", 67, genre1, awards, null));
    }

    @Test
    public void testNullAlbumForMusician() {
        assertThrows(IllegalArgumentException.class, () -> new Musician("Bruce Springsteen", 73, genre2, awards4, null, "Columbia Records"));
    }

    @Test
    public void testNullPublisherForPoet() {
        assertThrows(IllegalArgumentException.class, () -> new Poet("Maya Angelou", 86, genre5, awards2, null));
    }
}
