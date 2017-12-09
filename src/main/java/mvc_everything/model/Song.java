package mvc_everything.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @Column(name = "dir", length = 128, nullable = false)
    private String dir;

    @Column(name = "s_name", length = 64, nullable = false)
    private String sname;

    @Column(name = "album", length = 64, nullable = false)
    private String album;

    @Column(name = "albumA", length = 64)
    private String albumA;

    @Column(name = "albumB", length = 64)
    private String albumB;

    @Column(name = "albumC", length = 64)
    private String albumC;

    @Column(name = "albumD", length = 64)
    private String albumD;

    @Column(name = "albumE", length = 64)
    private String albumE;

    @Column(name = "albumF", length = 64)
    private String albumF;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbumA() {
        return albumA;
    }

    public void setAlbumA(String albumA) {
        this.albumA = albumA;
    }

    public String getAlbumB() {
        return albumB;
    }

    public void setAlbumB(String albumB) {
        this.albumB = albumB;
    }

    public String getAlbumC() {
        return albumC;
    }

    public void setAlbumC(String albumC) {
        this.albumC = albumC;
    }

    public String getAlbumD() {
        return albumD;
    }

    public void setAlbumD(String albumD) {
        this.albumD = albumD;
    }

    public String getAlbumE() {
        return albumE;
    }

    public void setAlbumE(String albumE) {
        this.albumE = albumE;
    }

    public String getAlbumF() {
        return albumF;
    }

    public void setAlbumF(String albumF) {
        this.albumF = albumF;
    }
    
}
