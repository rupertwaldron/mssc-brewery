package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        BeerDto fav = BeerDto.builder()
            .id(UUID.randomUUID())
            .beerName("Bishops Finger")
            .beerStyle("IPA")
            .build();

        return CustomerDto.builder()
            .id(UUID.randomUUID())
            .name("Rupert Waldron")
            .favouriteBeer(fav)
            .build();
    }
}
