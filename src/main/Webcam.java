package azuresites.randocam;

public class Webcam extends WebcamDTO {
    public Webcam(String id, String title) {
        super(id, title);
        this.title = title;
        this.id = id;
    }

    private String id;
    private String status;
    private String title;
    private Player player;

    // Getters and setters for id, status, title, player
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static class Player {
        private Live live;
       
        public Live getLive() {
            return live;
        }

        public void setLive(Live live) {
            this.live = live;
        }

        public static class Live {
            private boolean available;
            private String embed;

            public boolean isAvailable() {
                return available;
            }

            public void setAvailable(boolean available) {
                this.available = available;
            }

            public String getEmbed() {
                return embed;
            }

            public void setEmbed(String embed) {
                this.embed = embed;
            }
        }
    }
}
