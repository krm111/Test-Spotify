package mvc_everything.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mvc_everything.model.PlayList;

public interface PlayListRepository extends CrudRepository<PlayList, String>{
    List<PlayList> findAll();
}
