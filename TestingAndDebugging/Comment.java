/**
 * A comment on a sales item.
 * * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class Comment
{
    private String author;
    private String text;
    private int rating; // 1-5
    private int upvotes;
    private int downvotes;

    /**
     * Create a new comment.
     * @param author The author's name.
     * @param text The comment text.
     * @param rating The rating (1-5).
     */
    public Comment(String author, String text, int rating)
    {
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.upvotes = 0;
        this.downvotes = 0;
    }

    /**
     * @return The rating.
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * Upvote this comment.
     */
    public void upvote()
    {
        upvotes++;
    }

    /**
     * Downvote this comment.
     */
    public void downvote()
    {
        downvotes++;
    }

    /**
     * Get full details of the comment.
     * @return The author, text, rating and vote counts.
     */
    public String getFullDetails()
    {
        String details = "Author: " + author + "\n";
        details += "Text: " + text + "\n";
        details += "Rating: " + rating + " stars\n";
        details += "Votes: " + (upvotes - downvotes) + 
                   " (" + upvotes + " up, " + downvotes + " down)\n";
        return details;
    }
}
