package mvc_everything.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc_everything.model.PlayList;
import mvc_everything.repository.PlayListRepository;

@Service
public class PlayListService {

    @Autowired
    PlayListRepository repository;

    public List<PlayList> getAll() {
        return repository.findAll();
    }

    public PlayList getById(String id) {
        return repository.findOne(id);
    }

    public PlayList save(PlayList playListAdd) {
        System.out.println("Add Artist: " + playListAdd.getId());
        PlayList playList = repository.findOne(playListAdd.getId());
        if (playList != null) {
            playList.setName(playListAdd.getName());
            playList.setSongA(playListAdd.getSongA());
            playList.setSongB(playListAdd.getSongB());
            playList.setSongC(playListAdd.getSongC());
            playList.setSongD(playListAdd.getSongD());
            playList.setSongE(playListAdd.getSongE());
            playList.setSongF(playListAdd.getSongF());
            playList.setSongG(playListAdd.getSongG());
        } else {
            playList = playListAdd;
        }

        return repository.save(playList);
    }

}
