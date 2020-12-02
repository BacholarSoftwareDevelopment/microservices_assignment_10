package dk.dd.carsearch;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@FeignClient("task1")
@RibbonClient(name="task1", configuration = RibbonConfig.class)
public interface UserSearchClient
{
    @GetMapping("/users/")
    Resources<User> readUsers();
}
