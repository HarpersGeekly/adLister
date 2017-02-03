import java.util.List;

/**
 * Created by RyanHarper on 2/2/17.
 */
public class EmptyAds implements Ads {
    @Override
    public List<Ad> all() {
        return null;
    }

    @Override
    public void insert(Ad ad) {

    }

    @Override
    public Ad find(long id) {
        return null;
    }
}
