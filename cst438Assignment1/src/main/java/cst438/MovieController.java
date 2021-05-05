package cst438;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController
{
   
   @Autowired
   MovieRatingRepository movieRatingRepository;
   
   @GetMapping("movies/new")
   public String createMovieRating(Model model) {
      MovieRating movieRating = new MovieRating();
      model.addAttribute("movieRating", movieRating);
      return "rating_form";
   }
   
   @PostMapping("/movies/new")
   public String processPersonForm(@Valid MovieRating rating, BindingResult result, Model model) {
      if (result.hasErrors()) {
         return "rating_form";
      }
      rating.setDateTime(new java.util.Date());
      movieRatingRepository.save(rating);
      return "rating_show";
   }
   
   @GetMapping("/movies")
   public String movies(Model model) {
      Iterable<MovieRating> ratings = movieRatingRepository.findAllMovieRatingsOrderByTitleDateDesc();
      model.addAttribute("ratings", ratings);
      return "rating_list";
   }
}
