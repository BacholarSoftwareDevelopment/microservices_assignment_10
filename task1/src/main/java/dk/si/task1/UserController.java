package dk.si.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
//@RepositoryRestController
@RepositoryRestResource
@ResponseBody
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserRepo repo;
    private Object User;

    @GetMapping("/")
    public List<User> retrieveAllUsers()
    {
        return (List<User>) repo.findAll();
    }

    @GetMapping("/{name}")
    public User findByName(@PathVariable String name)
    {
        return repo.findByFullname(name);
    }

    @PostMapping("/")
    public String saveUser(@RequestBody User user)
    {
        repo.save(user);
        return " record saved..";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id)
    {
        repo.deleteById((long) id);
        return " record deleted...";
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateCar(@RequestBody dk.oertel.carcatalog.Car car, @PathVariable int id)
//    {
//        Optional<dk.oertel.carcatalog.Car> found = repo.findById((long) id);
//
//        if (!found.isPresent())
//            return ResponseEntity.badRequest()
//                    .header("Custom-Header", "foo")
//                    .body("Try again")
//                    .notFound().build();
//        car.setId((long) id);
//        repo.save(car);
//        return   ResponseEntity.ok()
//                .header("Custom-Header", "foo")
//                .body("Notice the custom header")
//                .noContent().build();
//    }
//    @Autowired
//    private UserRepo repo;
//    private Object Car;
//
//    @GetMapping("/")
//    public List<dk.oertel.carcatalog.Car> retrieveAllCars()
//    {
//        return (List<dk.oertel.carcatalog.Car>) repo.findAll();
//    }
//
//    @GetMapping("/{brand}")
//    public dk.oertel.carcatalog.Car findByBrand(@PathVariable String brand)
//    {
//        return repo.findByBrand(brand);
//    }
//
//    @PostMapping("/")
//    public String saveCar(@RequestBody dk.oertel.carcatalog.Car car)
//    {
//        repo.save(car);
//        return " record saved..";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCar(@PathVariable int id)
//    {
//        repo.deleteById((long) id);
//        return " record deleted...";
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateCar(@RequestBody dk.oertel.carcatalog.Car car, @PathVariable int id)
//    {
//        Optional<dk.oertel.carcatalog.Car> found = repo.findById((long) id);
//
//        if (!found.isPresent())
//            return ResponseEntity.badRequest()
//                    .header("Custom-Header", "foo")
//                    .body("Try again")
//                    .notFound().build();
//        car.setId((long) id);
//        repo.save(car);
//        return   ResponseEntity.ok()
//                .header("Custom-Header", "foo")
//                .body("Notice the custom header")
//                .noContent().build();
//    }
}

