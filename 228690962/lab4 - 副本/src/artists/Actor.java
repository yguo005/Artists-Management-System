package artists;

import artists.AbstractArtist;

import java.util.Arrays;

/**
 * All Actors keep track of the movies they've acted in (a String array)
 * Aside from the shared attributes, this should be another parameter for the artists.Actor constructor
 */

public class Actor extends AbstractArtist {
    private String[] movies;
    public Actor(String name, int age, String[] genres, String[] awards, String[] movies) throws IllegalArgumentException{
        super(name, age, genres, awards);
        if (movies == null){
            throw new IllegalArgumentException();
        }
        this.movies = movies;
    }

    /**
     * the toString method for artists.Actor should follow the format provided below:
     * My name is Samuel L. Jackson
     * My age is 73
     * I am an ACTOR
     * I make these types of movies: [Action, SciFi, Drama]
     * I have acted in these movies: [Star Wars, Captain America: Winter Soldier, Pulp Fiction]
     * @return (string)
     */
    @Override
    public String toString(){
        return "My name is " + super.getName() +
                "\nMy age is " + super.getAge() +
                "\nI am an ACTOR" +
                "\nI make these types of movies: " + Arrays.toString(super.getGenres()) +
                "\nI have acted in these movies: " + Arrays.toString(this.movies);

    }
}
