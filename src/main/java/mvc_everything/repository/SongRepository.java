package mvc_everything.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mvc_everything.model.Song;

public interface SongRepository extends CrudRepository<Song, String>{
    List<Song> findAll();
}
