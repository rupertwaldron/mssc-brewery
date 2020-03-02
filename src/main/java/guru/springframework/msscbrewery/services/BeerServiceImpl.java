package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.respositories.BeerRepository;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Service
public class BeerServiceImpl implements BeerService {

    private BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerRepository.findBeer(beerId);
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerRepository.saveBeer(beerDto);
    }

    @Override
    public List<BeerDto> listAllBeers() {
        return beerRepository.listBeers();
    }

    @Override
    public BeerDto updateBeer(BeerDto beerDto) {
        return beerRepository.updateBeer(beerDto);
    }

    @Override
    public BeerDto deleteBeer(UUID beerId) {
        return beerRepository.deleteBeer(beerId);
    }
}
