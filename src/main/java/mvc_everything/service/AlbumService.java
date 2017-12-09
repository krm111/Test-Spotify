package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc_everything.model.Album;
import mvc_everything.repository.AlbumRepository;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository repository;

    public List<Album> getAll() {
        return repository.findAll();
    }

    public Album getById(String id) {
        return repository.findOne(id);
    }

    public Album save(Album albumAdd) {
        System.out.println("Add Album: " + albumAdd.getId());
        Album album = repository.findOne(albumAdd.getId());
        if (album != null) {
            album.setName(albumAdd.getName());
            album.setArtist(albumAdd.getArtist());
            album.setArtistA(albumAdd.getArtistA());
            album.setArtistB(albumAdd.getArtistB());
            album.setArtistC(albumAdd.getArtistC());
            album.setArtistD(albumAdd.getArtistD());
            album.setArtistE(albumAdd.getArtistE());
            album.setArtistF(albumAdd.getArtistF());
        } else {
            album = albumAdd;
        }

        return repository.save(album);
    }

}
