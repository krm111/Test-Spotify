package mvc_everything.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @Column(name = "id", length = 64, nullable = false)
    private String id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "artist", length = 64, nullable = false)
    private String artist;

    @Column(name = "artistA", length = 64)
    private String artistA;

    @Column(name = "artistB", length = 64)
    private String artistB;

    @Column(name = "artistC", length = 64)
    private String artistC;

    @Column(name = "artistD", length = 64)
    private String artistD;

    @Column(name = "artistE", length = 64)
    private String artistE;

    @Column(name = "artistF", length = 64)
    private String artistF;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtistA() {
        return artistA;
    }

    public void setArtistA(String artistA) {
        this.artistA = artistA;
    }

    public String getArtistB() {
        return artistB;
    }

    public void setArtistB(String artistB) {
        this.artistB = artistB;
    }

    public String getArtistC() {
        return artistC;
    }

    public void setArtistC(String artistC) {
        this.artistC = artistC;
    }

    public String getArtistD() {
        return artistD;
    }

    public void setArtistD(String artistD) {
        this.artistD = artistD;
    }

    public String getArtistE() {
        return artistE;
    }

    public void setArtistE(String artistE) {
        this.artistE = artistE;
    }

    public String getArtistF() {
        return artistF;
    }

    public void setArtistF(String artistF) {
        this.artistF = artistF;
    }

}
