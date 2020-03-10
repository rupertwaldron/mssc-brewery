package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    void saveNewCustomer(CustomerDto customerDto);

    List<CustomerDto> listAllCustomers();

    void updateCustomer(CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}
