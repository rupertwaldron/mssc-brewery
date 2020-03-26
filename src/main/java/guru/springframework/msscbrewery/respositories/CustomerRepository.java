package guru.springframework.msscbrewery.respositories;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerRepository implements Repo<CustomerDto> {
    private Map<UUID, CustomerDto> customers = new HashMap<>();

    public CustomerRepository() {
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

        var customer1 = CustomerDto.builder()
            .id(UUID.fromString("60a590c4-c581-4282-b319-1a3bd2cdfb3e"))
            .favouriteBeer(beer1)
            .name("Gary Townsend")
            .build();

        var customer2 = CustomerDto.builder()
            .id(UUID.fromString("ab1c5448-a596-4485-bd77-980aec746f26"))
            .name("Bob Martin")
            .favouriteBeer(beer2)
            .build();

        customers.put(customer1.getId(), customer1);
        customers.put(customer2.getId(), customer2);
    }

    @Override
    public CustomerDto findById(UUID uuid) {
        return customers.get(uuid);
    }

    @Override
    public void saveEntity(CustomerDto entity) {
        customers.put(entity.getId(), entity);
    }

    @Override
    public void updateEntity(CustomerDto entity) {
        if (customers.containsKey(entity.getId())) customers.put(entity.getId(), entity);
    }

    @Override
    public List<CustomerDto> listAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void deleteById(UUID uuid) {
        customers.remove(uuid);
    }
}
