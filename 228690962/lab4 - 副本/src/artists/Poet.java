package artists;

import artists.AbstractArtist;

import java.util.Arrays;

/**
 * All Poets keep track of the publisher (a String) that publishes their books/work
 * Aside from the shared attributes, this should be the another parameter for the artists.Poet constructor.
 */
public class Poet extends AbstractArtist {
    private String publisher;

    public Poet(String name, int age, String[] genres, String[] awards, String publisher) throws IllegalArgumentException{
        super(name, age, genres, awards);
        if (publisher == null){
            throw new IllegalArgumentException();
        }
        this.publisher = publisher;
    }

    /**
     * Also the toString method for artists.Poet should follow the format provided below:
     * My name is Maya Angelou
     * My age is 86
     * I am an POET
     * I make these types of poems: [Autobiographical Fiction]
     * My publishing company is: Random House
     */
    @Override
    public String toString(){
        return "My name is " + super.getName() +
        "\nMy age is " + super.getAge() +
        "\nI am a POET" +
        "\nI make these types of poems: " + Arrays.toString(super.getGenres()) +
        "\n My publishing company is: " + this.publisher;
    }
}



