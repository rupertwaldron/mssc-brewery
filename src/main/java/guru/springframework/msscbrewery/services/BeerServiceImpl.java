package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.respositories.BeerRepository;
import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerRepository.findById(beerId);
    }

    @Override
    public void saveNewBeer(BeerDto beerDto) {
        beerRepository.saveEntity(beerDto);
    }

    @Override
    public List<BeerDto> listAllBeers() {
        return beerRepository.listAll();
    }

    @Override
    public void updateBeer(BeerDto beerDto) {
        beerRepository.updateEntity(beerDto);
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.info("Deleting beer");
        beerRepository.deleteById(beerId);
    }
}
