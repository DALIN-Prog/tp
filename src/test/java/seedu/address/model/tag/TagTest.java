package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidTagName));
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));
        // PG tag name
        assertTrue(Tag.isValidTagName("PG"));
        // PGG tag name
        assertFalse(Tag.isValidTagName("PGG"));
        // pg tag name
        assertFalse(Tag.isValidTagName("pg"));
        // SG tag name
        assertTrue(Tag.isValidTagName("SG"));
        // SGG tag name
        assertFalse(Tag.isValidTagName("SGG"));
        // sg tag name
        assertFalse(Tag.isValidTagName("sg"));
        // SF tag name
        assertTrue(Tag.isValidTagName("SF"));
        // SFF tag name
        assertFalse(Tag.isValidTagName("SFF"));
        // sf tag name
        assertFalse(Tag.isValidTagName("sf"));
        // PF tag name
        assertTrue(Tag.isValidTagName("PF"));
        // PFF tag name
        assertFalse(Tag.isValidTagName("PFF"));
        // pf tag name
        assertFalse(Tag.isValidTagName("pf"));
        // C tag name
        assertTrue(Tag.isValidTagName("C"));
        // Cc tag name
        assertFalse(Tag.isValidTagName("Cc"));
        // c tag name
        assertFalse(Tag.isValidTagName("c"));
    }

}
