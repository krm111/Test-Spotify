package mvc_everything.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mvc_everything.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, String>{
    List<Artist> findAll();
}
