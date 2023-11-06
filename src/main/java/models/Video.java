package models;

public class Video {
    private int id;
    private String title;
    private String director;
    private int cliId;

    // Getters y setters para las propiedades
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getCliId() {
        return cliId;
    }

    public void setCliId(int cliId) {
        this.cliId = cliId;
    }

    @Override
    public String toString() {
        return "id=" + id + ", title=" + title + ", director=" + director + ", cliId=" + cliId;
    }
}

