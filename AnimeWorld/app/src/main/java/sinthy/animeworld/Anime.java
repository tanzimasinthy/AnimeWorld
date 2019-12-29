package sinthy.animeworld;

public class Anime {

    private int pictureID;
    private String title;
    private String description;
    private String date;
    private String genre;
    private String status;
    private String rating;
    private String link;
    private int wallpaperID;
    private int videoID;

    public Anime(int pictureID, String title, String description, String date,
                 String genre, String status, String rating, String link, int wallpaperID, int videoID){

        this.title = title;
        this.pictureID = pictureID;
        this.description = description;
        this.date = date;
        this.genre = genre;
        this.status = status;
        this.rating = rating;
        this.link = link;
        this.wallpaperID = wallpaperID;
        this.videoID = videoID;
    }

    public int getPictureID() {
        return pictureID;
    }


    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public String getDate() {
        return date;
    }

    public String getGenre() {
        return genre;
    }

    public String getStatus() {
        return status;
    }

    public String getRating() {
        return rating;
    }

    public String getLink() {
        return link;
    }

    public int getWallpaperID() {
        return wallpaperID;
    }

    public int getVideoID() {
        return videoID;
    }
}
