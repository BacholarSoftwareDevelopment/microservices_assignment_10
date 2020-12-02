package dk.dd.carsearch;

import lombok.Data;
import lombok.NonNull;

@Data
public class User
{
    private Long id;
    @NonNull private String fullname;
    private long rating;
    private long car_id;
}
