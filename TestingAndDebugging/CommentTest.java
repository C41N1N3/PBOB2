import static org.junit.Assert.*;
import org.junit.Test;

public class CommentTest {

    @Test
    public void testCommentCreation() {
        Comment comment = new Comment("Ami", "Produk bagus!", 4);
        assertEquals(4, comment.getRating());
        String expectedDetails = "Author: Ami\n" +
                                 "Text: Produk bagus!\n" +
                                 "Rating: 4 stars\n" +
                                 "Votes: 0 (0 up, 0 down)\n";
        assertEquals(expectedDetails, comment.getFullDetails());
    }

    @Test
    public void testVoting() {
        Comment comment = new Comment("Budi", "Biasa saja.", 3);
        comment.upvote();
        comment.upvote();
        comment.upvote();
        comment.upvote();
        comment.upvote();
        comment.downvote();
        comment.downvote();
        String expectedDetails = "Author: Budi\n" +
                                 "Text: Biasa saja.\n" +
                                 "Rating: 3 stars\n" +
                                 "Votes: 3 (5 up, 2 down)\n";
        assertEquals(expectedDetails, comment.getFullDetails());
    }
}
