package mvc_everything.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import mvc_everything.model.Album;
import mvc_everything.service.AlbumService;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping
    public String listarAlbumes(ModelMap model, @RequestParam(value = "message", required = false) String message) {
        List<Album> albums = albumService.getAll();
        model.addAttribute("albums", albums);
        model.addAttribute("message", message);
        return "album/list";
    }

    @RequestMapping("/add")
    public String addArtist(ModelMap model) {
        Album album = new Album();
        model.addAttribute("album", album);
        model.addAttribute("title", "Add");
        return "album/data";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAlbum(@ModelAttribute Album albumAdded, ModelMap model) {
        albumService.save(albumAdded);
        return "redirect:/album?message=OK";
    }

}
