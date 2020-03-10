package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    void saveNewBeer(BeerDto beerDto);

    List<BeerDto> listAllBeers();

    void updateBeer(BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
