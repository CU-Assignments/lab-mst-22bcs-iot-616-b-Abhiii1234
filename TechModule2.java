//VIDEO RENTAL SYSTEM - TECH MODULE 2

class Video {
    private String title;
    private boolean checkedOut;
    private double rating;
    private int ratingCount;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.rating = 0.0;
        this.ratingCount = 0;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public void receiveRating(int rating) {
        this.rating = (this.rating * ratingCount + rating) / (++ratingCount);
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public double getRating() {
        return rating;
    }
}

class VideoStore {
    private Video[] videos;
    private int count;

    public VideoStore() {
        videos = new Video[10];
        count = 0;
    }

    public void addVideo(String title) {
        if (count < videos.length) {
            videos[count++] = new Video(title);
        }
    }

    public void checkOut(String title) {
        for (Video video : videos) {
            if (video != null && video.getTitle().equals(title)) {
                video.checkOut();
                break;
            }
        }
    }

    public void returnVideo(String title) {
        for (Video video : videos) {
            if (video != null && video.getTitle().equals(title)) {
                video.returnVideo();
                break;
            }
        }
    }

    public void receiveRating(String title, int rating) {
        for (Video video : videos) {
            if (video != null && video.getTitle().equals(title)) {
                video.receiveRating(rating);
                break;
            }
        }
    }

    public void listInventory() {
        for (Video video : videos) {
            if (video != null) {
                System.out.println("Title: " + video.getTitle() + ", Checked Out: " + video.isCheckedOut() + ", Rating: " + video.getRating());
            }
        }
    }
}

public class VideoStoreLauncher {
    public static void main(String[] args) {
        VideoStore store = new VideoStore();
        
        store.addVideo("The Matrix");
        store.addVideo("Godfather II");
        store.addVideo("Star Wars Episode IV: A New Hope");
        
        store.receiveRating("The Matrix", 5);
        store.receiveRating("Godfather II", 4);
        store.receiveRating("Star Wars Episode IV: A New Hope", 5);
        
        store.checkOut("Godfather II");
        store.returnVideo("Godfather II");
        
        store.listInventory();
    }
}
