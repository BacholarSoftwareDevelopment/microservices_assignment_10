package dk.dd.carsearch;

import lombok.Data;
import lombok.NonNull;

@Data
public class CarRating
{
        //@Id
        //@GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @NonNull private String brand;
        @NonNull private int year;
        @NonNull private long km;
        private long rating;
}
