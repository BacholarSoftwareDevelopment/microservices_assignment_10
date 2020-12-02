package dk.dd.carsearch;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CarSearchController
{
    private CarSearchClient carClient = null;
    private UserSearchClient userClient = null;

    public CarSearchController(CarSearchClient carClient, UserSearchClient userClient)
    {
        this.carClient = carClient;
        this.userClient = userClient;
    }

    @GetMapping("/rating")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallbackUser") // in case of failure
    public Collection<User> ratingCars()
    {
        return userClient.readUsers()
                .getContent()
                .stream()
                //.filter(user -> user.getCar_id() == 1)
                .collect(Collectors.toList());
    }

//    private boolean isUser(User user)
//    {
//        return user.getCar_id() == 1;
//    }

    private Collection<User> fallbackUser()
    {
        return new ArrayList<>();
    }

    @GetMapping("/mycars")
    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallback") // in case of failure
    public Collection<Car> myCars()
    {
        return carClient.readCars()
                .getContent()
                .stream()
                .filter(this :: isMine)
                .collect(Collectors.toList());
    }

    private boolean isMine(Car car)
    {
        return  car.getBrand().equals("Mini") ||
                (car.getYear() > 2017 && car.getKm()< 100000);
    }

    private Collection<Car> fallback()
    {
        return new ArrayList<>();
    }
}