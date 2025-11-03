import static org.junit.Assert.*;
import org.junit.Test;

public class SalesItemTest {

    private SalesItem item;
    @org.junit.Before
    public void setUp() {
        item = new SalesItem("Laptop Gaming", 15000000);
    }

    @Test
    public void testItemCreation() {
        assertEquals("Laptop Gaming", item.getName());
        assertEquals(15000000, item.getPrice());
        assertEquals(0, item.getNumberOfComments());
    }

    @Test
    public void testAddValidComment() {
        boolean result = item.addComment("Rina", "Suka!", 5);
        assertTrue(result);
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    public void testAddInvalidCommentRatingTooHigh() {
        boolean result = item.addComment("Tono", "Terlalu bagus!", 6);
        assertFalse(result);
        assertEquals(0, item.getNumberOfComments());
    }
    
    @Test
    public void testAddInvalidCommentRatingTooLow() {
        boolean result = item.addComment("Vina", "Buruk sekali", 0);
        assertFalse(result);
        assertEquals(0, item.getNumberOfComments());
    }

    @Test
    public void testRemoveComment() {
        item.addComment("User1", "Komen 1", 3);
        item.addComment("User2", "Komen 2", 4);
        item.addComment("User3", "Komen 3", 5);
        assertEquals(3, item.getNumberOfComments());
        item.removeComment(1);
        assertEquals(2, item.getNumberOfComments());
    }

    @Test
    public void testRemoveCommentInvalidIndex() {
        item.addComment("User1", "Komen 1", 3);
        item.removeComment(99);
        item.removeComment(-1);
        assertEquals(1, item.getNumberOfComments());
    }
}