import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SoundexEncoderTest {
    
    @Test void mustNotBeNull() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertThrows(IllegalArgumentException.class, () -> encoder.nameToSoundex(null));
    }

    @Test void mustNotBeEmpty() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertThrows(IllegalArgumentException.class, () -> encoder.nameToSoundex(""));
    }

    @Test void mustBeAlphaCharacters() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertThrows(IllegalArgumentException.class, () -> encoder.nameToSoundex("1"));
    }
 
    @Test void mustContainAtLeastOneLetter() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertThrows(IllegalArgumentException.class, () -> encoder.nameToSoundex("123!@#"));
    }

    @Test void matthewToSoundex() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("M300", encoder.nameToSoundex("Matthew"));
    }

    @Test void danielToSoundex() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("D540", encoder.nameToSoundex("Daniel"));
    }

    @Test void markToSoundex() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("M620", encoder.nameToSoundex("Mark"));
    }

    @Test void alexToSoundex() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("A420", encoder.nameToSoundex("Alex"));
    }

    @Test void shortNameIsPaddedWithZeros() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("L000", encoder.nameToSoundex("Lee"));
    }
 
    @Test void adjacentSameCodeLettersAreCollapsed() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("P236", encoder.nameToSoundex("Pfister"));
    }

    @Test void hAndWDoNotSeparateSameCodeLetters() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("A261", encoder.nameToSoundex("Ashcraft"));
    }

    @Test void vowelSeparatesSameCodeLetters() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("T522", encoder.nameToSoundex("Tymczak"));
    }
 
    @Test void lowercaseInputIsHandled() {
        SoundexEncoder encoder = new SoundexEncoder();
        assertEquals("M300", encoder.nameToSoundex("matthew"));
    }
}
