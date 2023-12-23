package dians.hw.winespotter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Optional;

@Entity
@Data
@Table(name="review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Min(value = 1, message = "Grade must be between 1 and 5")
    @Max(value = 5, message = "Grade must be between 1 and 5")
    private Integer grade;
    private String comment;

    @ManyToOne
    private Winery winery;

    public Review(String name, Integer grade, String comment, Winery winery) {
        this.name = name;
        this.grade = grade;
        this.comment = comment;
        this.winery = winery;
    }
}
