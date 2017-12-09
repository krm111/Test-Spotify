package mvc_everything.controller;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import mvc_everything.model.User;
import mvc_everything.service.UserService;
import mvc_everything.service.MusicService;

import mvc_everything.model.Song;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  MusicService musicService;

  @RequestMapping
  public String Home(ModelMap model, @RequestParam(value = "message", required = false) String message) {
    model.addAttribute("message", message);
    return "user/home";
  }

  @RequestMapping("/login")
  public String loginUser(ModelMap model) {
    User user = new User();
    model.addAttribute("user", user);
    model.addAttribute("title", "Login");
    return "user/sign";
  }

  @RequestMapping(value = "/signIn", method = RequestMethod.POST)
  public String signInUser(@ModelAttribute User userSession, ModelMap model) {
    if(userService.validate(userSession) == true) {
      return "user/session";
    }
    else {
      return "redirect:/user?message=Username or Password is wrong!";
    }
  }

  @RequestMapping("/prePlayMusic")
  public String prePlay(ModelMap model) {
    Song song = new Song();
    model.addAttribute("song", song);
    model.addAttribute("title", "Music");
    return "user/prePlay";
  }


  @RequestMapping(value = "/play", method = RequestMethod.POST)
  public String playMusic(@ModelAttribute Song songPlayed, ModelMap model) {
    String dirSong = songPlayed.getDir();
    musicService.Play(dirSong);
    model.addAttribute("title", "PlayMusic");
    return "user/playMusic";
  }

  @RequestMapping("/stop")
  public String stopMusic(ModelMap model) {
    musicService.Stop();
    model.addAttribute("title", "StopMusic");
    return "user/stopMusic";
  }

  @RequestMapping("/resume")
  public String resumeMusic(ModelMap model) {
    musicService.Resume();
    model.addAttribute("title", "ResumeMusic");
    return "user/playMusic";
  }

  @RequestMapping("/pause")
  public String pauseMusic(ModelMap model) {
    musicService.Pause();
    model.addAttribute("title", "PauseMusic");
    return "user/pauseMusic";
  }

  @RequestMapping("/register")
  public String registerUser(ModelMap model) {
    User user = new User();
    model.addAttribute("user", user);
    model.addAttribute("title", "Register");
    return "user/data";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveUser(@ModelAttribute User userRegistered, ModelMap model) {
    userService.save(userRegistered);
    return "redirect:/user?message=Usuario Registrado";
  }

  /*
  @RequestMapping
  public String listarUsuarios(ModelMap model,
                               @RequestParam(value = "message", required = false) String message) {
    List<User> users = userService.getAll();
    model.addAttribute("users", users);
    model.addAttribute("message", message);
    return "user/list";
  }
  */

}
