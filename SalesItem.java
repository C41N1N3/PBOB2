import java.util.ArrayList;

/**
 * The SalesItem class represents sales items in an online shop.
 * Information about the item is stored, such as a description and a price.
 * This version also stores comments from customers.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class SalesItem
{
    private String name;
    private int price; // harga dalam sen
    private ArrayList<Comment> comments;

    /**
     * Create a new sales item.
     * @param name The item's name.
     * @param price The item's price in cents.
     */
    public SalesItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        comments = new ArrayList<>();
    }

    /**
     * @return The item's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The item's price.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * @return The number of comments.
     */
    public int getNumberOfComments()
    {
        return comments.size();
    }

    /**
     * Add a comment to this item.
     * @param author The author of the comment.
     * @param text The comment text.
     * @param rating A rating (from 1 to 5).
     * @return true if the comment was added, false if the rating was invalid.
     */
    public boolean addComment(String author, String text, int rating)
    {
        if (rating < 1 || rating > 5) {
            // rating tidak valid
            return false;
        }
        comments.add(new Comment(author, text, rating));
        return true;
    }

    /**
     * Remove the comment at the given index.
     * @param index The index of the comment to remove. (0-based).
     */
    public void removeComment(int index)
    {
        if (index >= 0 && index < comments.size()) {
            comments.remove(index);
        }
    }

    /**
     * Show all information about this item.
     */
    public void showInfo()
    {
        System.out.println("Item: " + name + " (price: " + price + ")");
        System.out.println("Comments:");
        
        if(comments.isEmpty()) {
            System.out.println("(No comments yet)");
        }
        else {
            for(Comment comment : comments) {
                System.out.println("-------------------------------------------");
                System.out.println(comment.getFullDetails());
            }
        }
        System.out.println("===========================================");
    }
}