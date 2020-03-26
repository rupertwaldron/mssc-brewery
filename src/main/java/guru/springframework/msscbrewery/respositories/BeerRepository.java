package guru.springframework.msscbrewery.respositories;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BeerRepository implements Repo<BeerDto> {
    private Map<UUID, BeerDto> beers = new HashMap<>();

    public BeerRepository() {
        var beer1 = BeerDto.builder()
            .id(UUID.fromString("361b562e-9431-41f1-a9ac-0a3670f38c99"))
            .beerName("Galaxy Cat")
            .beerStyle("Pale Ale")
            .build();

        var beer2 = BeerDto.builder()
            .id(UUID.fromString("78e11a49-8372-4892-8fed-98bb20152922"))
            .beerName("Bishops Tart")
            .beerStyle("IPA")
            .build();

        beers.put(beer1.getId(), beer1);
        beers.put(beer2.getId(), beer2);
    }

    @Override
    public BeerDto findById(UUID uuid) {
        return beers.get(uuid);
    }

    @Override
    public void saveEntity(BeerDto entity) {
        beers.put(entity.getId(), entity);
    }

    @Override
    public void updateEntity(BeerDto entity) {
        if (beers.containsKey(entity.getId())) beers.put(entity.getId(), entity);
    }

    @Override
    public List<BeerDto> listAll() {
        return new ArrayList<>(beers.values());
    }

    @Override
    public void deleteById(UUID uuid) {
        beers.remove(uuid);
    }
}
