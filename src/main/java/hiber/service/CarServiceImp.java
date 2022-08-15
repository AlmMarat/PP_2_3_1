package hiber.service;

import hiber.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImp implements CarService {
    @Override
    public List<Car> getCarList(List<Car> carsList, int count) {
        if (count > 5) {
            return carsList;
        }
        return carsList.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
