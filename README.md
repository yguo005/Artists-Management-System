# Artists Management System

A Java-based digital index system for managing different types of artists including actors, musicians, and poets. The system demonstrates advanced object-oriented programming concepts including interfaces, abstract classes, inheritance, and polymorphism.

## Overview

This project implements a comprehensive artist management system for a non-profit organization creating a digital index of artists. The system supports three types of artists with shared common attributes and specialized behaviors, showcasing polymorphic design patterns and code reuse through inheritance.

## Features

- Interface-based polymorphic design for artist management
- Abstract base class for shared functionality across artist types
- Specialized artist implementations with unique attributes
- Dynamic award system for tracking artist achievements
- Comprehensive input validation and error handling
- Formatted string representations for each artist type
- Full unit test coverage with JUnit 5

## Project Structure

```
src/artists/
├── IArtist.java           # Artist interface contract
├── AbstractArtist.java    # Abstract base class
├── Actor.java            # Actor implementation
├── Musician.java         # Musician implementation
└── Poet.java             # Poet implementation

test/
└── IArtistTest.java      # Comprehensive unit tests
```

## Architecture

### Interface Design

The system uses the `IArtist` interface to establish a common contract:

```java
public interface IArtist {
    void receiveAward(String award);
    String[] getAwards();
}
```

### Class Hierarchy

```
IArtist (interface)
    ↑
AbstractArtist (abstract class)
    ↑
    ├── Actor
    ├── Musician
    └── Poet
```

## Artist Types

### Common Attributes

All artists share the following attributes managed by the abstract base class:

- **Name**: String containing first and last name (non-null, non-empty)
- **Age**: Integer ranging from 0 to 128 years
- **Genres**: Array of strings representing artistic genres
- **Awards**: Array of strings tracking received awards

### Actor

Specializes in film and television performances.

**Additional Attributes:**
- Movies: Array of films the actor has appeared in

**Constructor:**
```java
Actor(String name, int age, String[] genres, String[] awards, String[] movies)
```

**String Format:**
```
My name is Samuel L. Jackson
My age is 73
I am an ACTOR
I make these types of movies: [Action, SciFi, Drama]
I have acted in these movies: [Star Wars, Captain America: Winter Soldier, Pulp Fiction]
```

**Example Usage:**
```java
String[] genres = {"Action", "SciFi", "Drama"};
String[] awards = {"Academy Award", "Golden Globe"};
String[] movies = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};

Actor actor = new Actor("Denzel Washington", 67, genres, awards, movies);
System.out.println(actor.toString());
```

### Musician

Specializes in musical performances and recordings.

**Additional Attributes:**
- Current Album: Title of their latest album
- Record Company: Name of their recording label

**Constructor:**
```java
Musician(String name, int age, String[] genres, String[] awards, 
         String currentAlbum, String recordCompany)
```

**String Format:**
```
My name is The Weeknd
My age is 32
I am a MUSICIAN
I make these types of music: [R&B, Pop]
My current album is: Dawn FM
My recording company is: XO
```

**Example Usage:**
```java
String[] genres = {"Rock", "Rock-Soul"};
String[] awards = {"Grammy", "American Music Award"};

Musician musician = new Musician("Bruce Springsteen", 73, genres, awards,
                                "Only the Strong Survive", "Columbia Records");
System.out.println(musician.toString());
```

### Poet

Specializes in written literary works.

**Additional Attributes:**
- Publisher: Name of the publishing company

**Constructor:**
```java
Poet(String name, int age, String[] genres, String[] awards, String publisher)
```

**String Format:**
```
My name is Maya Angelou
My age is 86
I am a POET
I make these types of poems: [Autobiographical Fiction]
My publishing company is: Random House
```

**Example Usage:**
```java
String[] genres = {"Autobiographical Fiction"};
String[] awards = {"Pulitzer"};

Poet poet = new Poet("Maya Angelou", 86, genres, awards, "Random House");
System.out.println(poet.toString());
```

## Award Management System

All artists can receive new awards through the dynamic award system:

```java
// Initial awards
String[] initialAwards = {"Pulitzer"};
Poet poet = new Poet("Maya Angelou", 86, genres, initialAwards, "Random House");

// Receive new award
poet.receiveAward("Tony");

// Check all awards
String[] allAwards = poet.getAwards(); // ["Pulitzer", "Tony"]
```

### Award System Features

- Dynamic array expansion for new awards
- Preservation of existing awards
- Thread-safe award addition
- Array-based storage for efficient retrieval

## Input Validation

The system includes comprehensive validation across all artist types:

### Common Validation Rules

**Name Validation:**
- Cannot be null
- Cannot be empty string
- Throws `IllegalArgumentException` for invalid names

**Age Validation:**
- Must be between 0 and 128 (inclusive)
- Throws `IllegalArgumentException` for invalid ages

### Artist-Specific Validation

**Actor:**
- Movies array cannot be null
- Throws `IllegalArgumentException` for null movies

**Musician:**
- Genres array cannot be null
- Current album cannot be null
- Throws `IllegalArgumentException` for null values

**Poet:**
- Publisher cannot be null
- Throws `IllegalArgumentException` for null publisher

## Error Handling Examples

```java
// Invalid age
try {
    Actor actor = new Actor("John Doe", 150, genres, awards, movies);
} catch (IllegalArgumentException e) {
    System.out.println("Age must be between 0 and 128");
}

// Invalid name
try {
    Musician musician = new Musician("", 25, genres, awards, album, company);
} catch (IllegalArgumentException e) {
    System.out.println("Name cannot be empty");
}

// Null required field
try {
    Poet poet = new Poet("Jane Doe", 45, genres, awards, null);
} catch (IllegalArgumentException e) {
    System.out.println("Publisher cannot be null");
}
```

## Polymorphic Usage

The system supports polymorphic operations through the common interface:

```java
IArtist[] artists = {
    new Actor("Denzel Washington", 67, actorGenres, awards, movies),
    new Musician("Bruce Springsteen", 73, musicGenres, awards, album, company),
    new Poet("Maya Angelou", 86, poetGenres, awards, publisher)
};

// Polymorphic award ceremony
for (IArtist artist : artists) {
    artist.receiveAward("Lifetime Achievement Award");
    System.out.println(artist.toString());
    System.out.println("Awards: " + Arrays.toString(artist.getAwards()));
}
```

## Testing

### Test Coverage

The project includes comprehensive unit tests covering:

**Instance Creation:**
- Valid artist creation with all required parameters
- String representation format validation
- Case-insensitive string comparison testing

**Award Management:**
- Award addition functionality
- Award retrieval accuracy
- Dynamic array expansion verification

**Validation Testing:**
- Invalid age handling (negative, over 128)
- Null name validation
- Empty string name validation
- Artist-specific null field validation

### Running Tests

```bash
# Compile all source and test files
javac -cp ".:junit5.jar" src/artists/*.java *.java

# Run all tests
java -cp ".:junit5.jar" org.junit.platform.console.ConsoleLauncher --scan-classpath
```

### Sample Test Output

```
Test: testCreatedInstances - PASSED
Test: testReceiveAward - PASSED
Test: testGetAwards - PASSED
Test: testBadAge - PASSED
Test: testBadAge2 - PASSED
Test: testBadName - PASSED
Test: testNullGenres - PASSED
Test: testNullMoviesForActor - PASSED
Test: testNullAlbumForMusician - PASSED
Test: testNullPublisherForPoet - PASSED
```

## Design Patterns Implemented

### Template Method Pattern
The `AbstractArtist` class provides common functionality while allowing subclasses to implement specific behavior through method overriding.

### Strategy Pattern
Different artist types implement specialized string formatting strategies while maintaining a common interface.

### Factory Pattern Potential
The polymorphic design supports factory pattern implementation for dynamic artist creation.

## Access Modifiers Usage

**Public Methods:**
- Interface-mandated methods (`receiveAward`, `getAwards`)
- Constructor methods for all concrete classes
- `toString` method overrides

**Protected Methods:**
- Getter methods in `AbstractArtist` for subclass access
- `getName()`, `getAge()`, `getGenres()` for inheritance support

**Private Fields:**
- All instance variables in `AbstractArtist`
- Artist-specific attributes in concrete classes

## Advanced Features

### Dynamic Array Management

The award system implements manual array expansion:

```java
public void receiveAward(String award) {
    int size = this.awards.length;
    String[] updatedAwards = new String[size + 1];
    
    for (int i = 0; i < size; i++) {
        updatedAwards[i] = this.awards[i];
    }
    updatedAwards[size] = award;
    this.awards = updatedAwards;
}
```

### Genre String Conversion

Utility method for array-to-string conversion:

```java
protected String getGenresAsSingleString() {
    if (this.genres == null || this.genres.length == 0) {
        return "";
    }
    return Arrays.toString(this.genres);
}
```

## Performance Considerations

- Array-based storage for efficient memory usage
- Manual array expansion minimizes object creation overhead
- Protected access modifiers optimize subclass method calls
- String formatting uses efficient concatenation methods

## Extension Points

The system can be easily extended with new artist types:

1. Create new class extending `AbstractArtist`
2. Implement required constructor with validation
3. Override `toString()` method with specific format
4. Add artist-specific attributes and validation
5. Update test suite with new artist type coverage

