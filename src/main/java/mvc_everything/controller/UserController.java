package mvc_everything.controller;

//import java.util.List;
import java.io.*;


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
  
    String text = null;
	File file = new File("currentuser.txt");
	BufferedReader reader = null;
	
	try {
    	reader = new BufferedReader(new FileReader(file));
		text = reader.readLine();
	} catch (FileNotFoundException e) {
    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} 
	finally {
    try {
        if (reader != null) {
            reader.close();
        }
    } catch (IOException e) {
    }
	}
	if(text==null){
		model.addAttribute("message", message);
	    return "user/home";
	}
	else{
		return "user/session";
	}  

  }

  @RequestMapping("/login")
  public String loginUser(ModelMap model) {
    User user = new User();
    model.addAttribute("user", user);
    model.addAttribute("title", "Login");
    return "user/sign";
  }
  @RequestMapping("/logout")
  public String loginOut(ModelMap model) {
		Writer writer = null;

    	try {
    	    writer = new BufferedWriter(new OutputStreamWriter(
    	          new FileOutputStream("currentuser.txt"), "utf-8"));
    	    writer.write("");
    	} catch (IOException ex) {
    	  // report
    	} finally {
    	   try {writer.close();} catch (Exception ex) {/*ignore*/}
    	}
    return "redirect:/user?message=Logged out";
  }
  @RequestMapping(value = "/signIn", method = RequestMethod.POST)
  public String signInUser(@ModelAttribute User userSession, ModelMap model) {
    if(userService.validate(userSession) == true) {
    	


    	
    	Writer writer = null;

    	try {
    	    writer = new BufferedWriter(new OutputStreamWriter(
    	          new FileOutputStream("currentuser.txt"), "utf-8"));
    	    writer.write(userSession.getUsername());
    	} catch (IOException ex) {
    	  // report
    	} finally {
    	   try {writer.close();} catch (Exception ex) {/*ignore*/}
    	}
      
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
