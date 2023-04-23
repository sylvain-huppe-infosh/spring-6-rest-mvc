package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        UUID newCustomerId = UUID.randomUUID();
        this.customerMap.put(newCustomerId,
                Customer.builder()
                .id(newCustomerId)
                .customerName("J-F Dort")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build());

        newCustomerId = UUID.randomUUID();
        this.customerMap.put(newCustomerId,
                Customer.builder()
                        .id(newCustomerId)
                        .customerName("Luc Massivi")
                        .version(1)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build());

        newCustomerId = UUID.randomUUID();
        this.customerMap.put(newCustomerId,
                Customer.builder()
                        .id(newCustomerId)
                        .customerName("Marc Mainville")
                        .version(1)
                        .createdDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build());
    }

    @Override
    public List<Customer> getCustomerList(){
        return new ArrayList<>(customerMap.values());
    }


    @Override
    public Customer getCustomerById(UUID uuid) {

        log.debug("Get Customer by Id - in service. Id: " + uuid.toString());
        return this.customerMap.get(uuid);
    }
}
