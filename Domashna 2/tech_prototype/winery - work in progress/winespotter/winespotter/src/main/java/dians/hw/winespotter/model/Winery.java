package dians.hw.winespotter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="winery")
@NoArgsConstructor
@AllArgsConstructor
public class Winery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String cities;
    private String TelephoneNumbers;
    private String WorkingHours;
    private String category;
    private String Latitude;
    private String Longitude;
}
