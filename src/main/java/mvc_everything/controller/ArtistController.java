package mvc_everything.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import mvc_everything.model.Artist;
import mvc_everything.service.ArtistService;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @RequestMapping
    public String listarArtistas(ModelMap model, @RequestParam(value = "message", required = false) String message) {
        List<Artist> artists = artistService.getAll();
        model.addAttribute("artists", artists);
        model.addAttribute("message", message);
        return "artist/list";
    }

    @RequestMapping("/add")
    public String addArtist(ModelMap model) {
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        model.addAttribute("title", "Add");
        return "artist/data";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveArtist(@ModelAttribute Artist artistAdded, ModelMap model) {
        artistService.save(artistAdded);
        return "redirect:/artist?message=OK";
    }

}
