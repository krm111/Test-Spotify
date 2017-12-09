package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc_everything.model.Artist;
import mvc_everything.repository.ArtistRepository;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository repository;

    public List<Artist> getAll() {
        return repository.findAll();
    }

    public Artist getById(String id) {
        return repository.findOne(id);
    }

    public Artist save(Artist artistAdd) {
        System.out.println("Add Artist: " + artistAdd.getId());
        Artist artist = repository.findOne(artistAdd.getId());
        if (artist != null) {
            artist.setName(artistAdd.getName());
        } else {
            artist = artistAdd;
        }

        return repository.save(artist);
    }
}
