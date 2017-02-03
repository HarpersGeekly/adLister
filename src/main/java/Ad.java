public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;

    // new ad created for the first time
    public Ad(long userId, String title, String description) {
        this(0, userId, title, description);
    }

    // existing ad retrieved from the database
    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId; //we're not going to use this
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
