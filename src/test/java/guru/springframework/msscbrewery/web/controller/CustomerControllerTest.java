package guru.springframework.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @InjectMocks
    CustomerController customerController;

    CustomerDto validCustomer;

    BeerDto validBeer;

    @BeforeEach
    public void setUp() {

        validBeer = BeerDto.builder()
            .id(UUID.randomUUID())
            .beerName("Fanny's Arse")
            .beerStyle("Sour Mash")
            .upc(12324L)
            .build();

        validCustomer = CustomerDto.builder()
            .id(UUID.randomUUID())
            .favouriteBeer(validBeer)
            .name("Rupert Waldron")
            .build();
    }

    @Test
    public void getCustomer() throws Exception {
        given(customerService.getCustomerById(any(UUID.class))).willReturn(validCustomer);

        mockMvc.perform(get("/api/v1/customers/" + validCustomer.getId().toString()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id", is(validCustomer.getId().toString())))
            .andExpect(jsonPath("$.name", is("Rupert Waldron")));    }

    @Test
    public void getCustomers() {
    }

    @Test
    public void handlePost() throws Exception {
        //given
        CustomerDto customerDto = validCustomer;
        customerDto.setId(null);
        String customerDtoJson = objectMapper.writeValueAsString(customerDto);

        mockMvc.perform(post("/api/v1/customers/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(customerDtoJson))
            .andExpect(status().isCreated());
    }

    @Test
    public void updateCustomer() throws Exception {
        //given
        CustomerDto customerDto = validCustomer;
        String customerDtoJson = objectMapper.writeValueAsString(customerDto);

        //when
        mockMvc.perform(put("/api/v1/customers/" + validCustomer.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(customerDtoJson))
            .andExpect(status().isNoContent());

        then(customerService).should().updateCustomer(any());
    }

    @Test
    public void deleteCustomer() throws Exception {
        //given

        //when
        mockMvc.perform(delete("/api/v1/customers/" + validCustomer.getId()))
            .andExpect(status().isNoContent());

        then(customerService).should().deleteCustomer(any(UUID.class));
    }
}