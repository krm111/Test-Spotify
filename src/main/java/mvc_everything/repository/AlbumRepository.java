package mvc_everything.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mvc_everything.model.Album;

public interface AlbumRepository extends CrudRepository<Album, String>{
    List<Album> findAll();
}
