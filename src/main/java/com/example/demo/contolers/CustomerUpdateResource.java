package com.example.demo.contolers;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
public class CustomerUpdateResource {

    private CustomerRepository customerRepository;

    @PostMapping("/request/api/customer")
    public ResponseEntity<String> saveCustomer(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
                                               @RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) {
        try {
           Customer customer = new Customer();
           customer.setFirstName(firstName);
           customer.setLastName(lastName);
            customer.setUserName(userName);
            customer.setPassword(password);
            customerRepository.save(customer);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.valueOf(201));
        }
        return ResponseEntity.status(HttpStatus.valueOf(400));
    }

    @GetMapping("/request/api/customer")
    public ResponseEntity<String> fetchCustomer(@RequestParam(value = "id") Long id) {
            Customer customer =  customerRepository.findById(id);
            if(customer!=null){
                return ResponseEntity.status(HttpStatus.valueOf(200)).body(customer);
            }else{
                return ResponseEntity.status(HttpStatus.valueOf(404));
            }
    }
}
