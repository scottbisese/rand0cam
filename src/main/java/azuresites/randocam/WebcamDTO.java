package azuresites.randocam;

//DTO means data transfer object.. a lighter weight verseion of the webcam, just caring about id and title.
class WebcamDTO {
    private String id;
    private String title;

    public WebcamDTO(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}