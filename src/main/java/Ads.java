
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    void insert(Ad ad);
    //adding a method so that all implementations can find the id:
    Ad findById(long id);
}
