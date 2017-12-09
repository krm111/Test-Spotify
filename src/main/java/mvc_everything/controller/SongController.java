package mvc_everything.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import mvc_everything.model.Song;
import mvc_everything.service.SongService;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    SongService songService;

    @RequestMapping
    public String listarCanciones(ModelMap model, @RequestParam(value = "message", required = false) String message) {
        List<Song> songs = songService.getAll();
        model.addAttribute("songs", songs);
        model.addAttribute("message", message);
        return "song/list";
    }

    @RequestMapping("/add")
    public String addArtist(ModelMap model) {
        Song song = new Song();
        model.addAttribute("song", song);
        model.addAttribute("title", "Add");
        return "song/data";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAlbum(@ModelAttribute Song songAdded, ModelMap model) {
        songService.save(songAdded);
        return "redirect:/song?message=OK";
    }

}
