package mvc_everything.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "playlist")
public class PlayList {
    @Id
    @Column(name = "id", length = 64, nullable = false)
    private String id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "songA", length = 64)
    private String songA;

    @Column(name = "songB", length = 64)
    private String songB;

    @Column(name = "songC", length = 64)
    private String songC;

    @Column(name = "songD", length = 64)
    private String songD;

    @Column(name = "songE", length = 64)
    private String songE;

    @Column(name = "songF", length = 64)
    private String songF;

    @Column(name = "songG", length = 64)
    private String songG;

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

    public String getSongA() {
        return songA;
    }

    public void setSongA(String songA) {
        this.songA = songA;
    }

    public String getSongB() {
        return songB;
    }

    public void setSongB(String songB) {
        this.songB = songB;
    }

    public String getSongC() {
        return songC;
    }

    public void setSongC(String songC) {
        this.songC = songC;
    }

    public String getSongD() {
        return songD;
    }

    public void setSongD(String songD) {
        this.songD = songD;
    }

    public String getSongE() {
        return songE;
    }

    public void setSongE(String songE) {
        this.songE = songE;
    }

    public String getSongF() {
        return songF;
    }

    public void setSongF(String songF) {
        this.songF = songF;
    }

    public String getSongG() {
        return songG;
    }

    public void setSongG(String songG) {
        this.songG = songG;
    }

}
