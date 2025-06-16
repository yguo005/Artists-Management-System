package artists;

import java.util.Arrays;

/**
 *  AbstractArtist class.
 *  This is the abstract superclass of all Artist concrete classes. It implements the
 *  IArtist interface and serves as the "repository" of reuse code for certain common services.
 */
public abstract class AbstractArtist implements IArtist {
    private String name;
    private int age;
    private String [] genres;
    private String [] awards;

    /**
     * AbstractArtist constructor.
     * This class cannot be instantiated, but this creation mechanism ensures the superclass
     * portion of all subclasses is appropriately initialized.
     * @param name : name of the artist.
     * @param age : age of the artist.
     * @param genres : genres of art the artist develops.
     * @param awards : awards earned by the artist.
     */
    public AbstractArtist(String name, int age, String [] genres, String [] awards) throws IllegalArgumentException {
        if(age > 128 || age < 0 || name == null || name.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.genres = genres;
        this.awards = awards;
    }

    /**
     * This method answers the age of the artist. This is a protected method and not intended to be
     * used by clients outside of the hierarchy.
     * @return (int)
     */
    protected int getAge() {
        return this.age;
    }

    /**
     * This method answers the full name of the artist. It is a protected getter for subclass use
     * @return (String)
     */
    protected String getName() { return this.name; }

    /**
     * This method answers an array representing the genres the artist creates for.
     * @return (String [])
     */
    protected String [] getGenres() { return this.genres;}

    /**
     * This method answers the genres as a single string that is aggregated from the array.
     * @return (String)
     */
    protected String getGenresAsSingleString() {
        if(this.genres == null || this.genres.length == 0) {
            return "";
        }
        return Arrays.toString(this.genres); // convert the array to a string
    }

    /**
     * Answers the awards earned by the artist.
     * @return (String [])
     */
    public String [] getAwards() { return this.awards;}

    /**
     * This method adds another award to the list of awards won by the artist.
     * @param award (String)
     */
    public void receiveAward(String award) {
        int size = this.awards.length; // get the current size of the array

        // Iterate through the current array, copy the values, then add the new value
        String [] updatedAwards = new String[size + 1];
        for (int i=0; i<size; i++) {
            updatedAwards[i] = this.awards[i];
        }
        updatedAwards[size] = award;
        this.awards = updatedAwards;
    }

    /**
     * Override of the toString() method that answers the basic information held by the AbstractArtist.
     * @return (String)
     */
    public String toString() {
        return "My name is " + this.name + "\n" + "My age is " + this.age + "\n";
    }
}