package guru.springframework.msscbrewery.respositories;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BeerRepository {
    private Map<UUID, BeerDto> beers = new HashMap<>();

    public BeerRepository() {
        var beer1 = BeerDto.builder()
            .id(UUID.randomUUID())
            .beerName("Galaxy Cat")
            .beerStyle("Pale Ale")
            .build();

        var beer2 = BeerDto.builder()
            .id(UUID.randomUUID())
            .beerName("Bishops Tart")
            .beerStyle("IPA")
            .build();

        beers.put(beer1.getId(), beer1);
        beers.put(beer2.getId(), beer2);
    }

    public BeerDto findBeer(UUID uuid) {
        return beers.get(uuid);
    }

    public BeerDto saveBeer(BeerDto beer) {
        return beers.put(beer.getId(), beer);
    }

    public BeerDto updateBeer(BeerDto beer) {
        if (!beers.containsKey(beer.getId())) return null;
        return beers.put(beer.getId(), beer);
    }

    public List<BeerDto> listBeers() {
        return new ArrayList<>(beers.values());
    }

    public BeerDto deleteBeer(UUID beerId) {
        if (!beers.containsKey(beerId)) return null;
        return beers.remove(beerId);
    }
}
