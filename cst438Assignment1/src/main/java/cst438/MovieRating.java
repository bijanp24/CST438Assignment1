package cst438;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class MovieRating
{

   
     @Id
     @GeneratedValue
     private long id;
     
     @NotNull
     @Size(min=3, max=25)
     private String title;
     
     @NotNull(message= "Rating must be selected")
     @Range(min = 1, max = 5)
     private Integer rating;
     
     @NotNull
     @Size(min=3, max=25)
     private String name;
     
     private Date dateTime;
     
     public MovieRating() {
        title = null;
        rating = 0;
        name = null;
        dateTime = null;
     }
     
     public MovieRating(long id, String title, Integer rating, String name, Date dateTime) {
        super();
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.name = name;
        this.dateTime = dateTime;
     }
     
     public long getId() { return id; }
     
     public void setId(long id) { this.id = id; }
     
     public String getTitle() {
        return title;
     }
     
     public void setTitle(String title) {
        this.title = title;
     }
     
     public Integer getRating() {
        return rating;
     }
     
     public void setRating(Integer rating) {
        this.rating = rating;
     }
     
     public String getName() {
        return name;
     }
     
     public void setName(String name) {
        this.name = name;
     }
     
     public Date getDateTime() {
        return dateTime;
     }
     
     public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
     }
}
