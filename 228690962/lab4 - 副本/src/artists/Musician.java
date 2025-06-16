package artists;

import java.util.Arrays;

/**
 * All Musicians keep track of their Recording company (a String) and the title of their current album (a String)
 * Aside from the shared attributes, these should be added parameters to the artists.Musician constructor,
 * where the current album must precede the record company in the constructor.
 */
public class Musician extends AbstractArtist {
    private String currentAlbum;
    private String recordCompany;

    public Musician(String name, int age, String[] genres, String[] awards, String currentAlbum, String recordCompany) throws IllegalArgumentException {
        super(name, age, genres, awards);
        if (genres == null || currentAlbum == null) {
                throw new IllegalArgumentException();
        }
        this.currentAlbum = currentAlbum;
        this.recordCompany = recordCompany;
    }

    /**
     * Also the toString method for artists.Musician should follow the format provided below:
     * My name is The Weeknd
     * My age is 32
     * I am an MUSICIAN
     * I make these types of music: [R&B, Pop]
     * My current album is: Dawn FM
     * My recording company is: XO
     */
    @Override
    public String toString(){
        return "My name is " + super.getName() +
        "\nMy age is " + super.getAge() +
        "\nI am a MUSICIAN" +
        "\nI make these types of music: " + Arrays.toString(super.getGenres()) +
        "\nMy current album is: " + this.currentAlbum +
        "\nMy recording company is: " + this.recordCompany;
    }
}
