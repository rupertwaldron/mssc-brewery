package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.respositories.CustomerRepository;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void saveNewCustomer(CustomerDto customerDto) {
        customerRepository.saveEntity(customerDto);
    }

    @Override
    public List<CustomerDto> listAllCustomers() {
        return customerRepository.listAll();
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        customerRepository.updateEntity(customerDto);
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.info("Deleting customer");
        customerRepository.deleteById(customerId);
    }
}
