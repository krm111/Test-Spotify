package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc_everything.model.Song;
import mvc_everything.repository.SongRepository;

@Service
public class SongService {

    @Autowired
    SongRepository repository;

    public List<Song> getAll() {
        return repository.findAll();
    }

    public Song getByDir(String dir) {
        return repository.findOne(dir);
    }

    public Song save(Song songAdd) {
        System.out.println("Add Song: " + songAdd.getDir());
        Song song = repository.findOne(songAdd.getDir());
        if (song != null) {
            song.setSname(songAdd.getSname());
            song.setAlbum(songAdd.getAlbum());
            song.setAlbumA(songAdd.getAlbumA());
            song.setAlbumB(songAdd.getAlbumB());
            song.setAlbumC(songAdd.getAlbumC());
            song.setAlbumD(songAdd.getAlbumD());
            song.setAlbumE(songAdd.getAlbumE());
            song.setAlbumF(songAdd.getAlbumF());
        } else {
            song = songAdd;
        }

        return repository.save(song);
    }

}
