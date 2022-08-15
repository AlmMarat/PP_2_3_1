package web.controller;

import hiber.model.Car;
import hiber.service.CarService;
import hiber.service.CarServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    CarService carService = new CarServiceImp();

    @GetMapping(value = "/cars")
    public String addCars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("BMW", "Black", 11111));
        list.add(new Car("Mercedes", "Grey", 22222));
        list.add(new Car("Opel", "Red", 33333));
        list.add(new Car("Nissan", "Black", 44444));
        list.add(new Car("Audi", "Brown", 55555));
        list = carService.getCarList(list, allCars);
        model.addAttribute("list", list);
        return "cars";
    }
}
