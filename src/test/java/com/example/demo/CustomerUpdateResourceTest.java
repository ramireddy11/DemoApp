package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CustomerUpdateResource.class)
public class CustomerUpdateResourceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("aaa");
        customer.setLastName("bbb");
        customer.setUserName("ab");

    }

    @Test
    void testFetchCustomer() {
        when(customerRepository.findById(1L)).thenReturn(customer);
        assertEquals(fetchCustomer(1L), customer);
    }
}
