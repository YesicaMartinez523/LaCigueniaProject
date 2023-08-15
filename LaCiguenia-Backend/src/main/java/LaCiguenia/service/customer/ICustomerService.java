package LaCiguenia.service.customer;

import LaCiguenia.commons.domains.dto.customer.CustomerDTO;
import LaCiguenia.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ICustomerService {
    ResponseEntity<GenericResponseDTO> createCustomer(CustomerDTO customerDTO);
    ResponseEntity<GenericResponseDTO> readCustomer(CustomerDTO customerDTO);
    ResponseEntity<GenericResponseDTO> readCustomers();
    ResponseEntity<GenericResponseDTO> updateCustomer(CustomerDTO customerDTO);
    ResponseEntity<GenericResponseDTO> deleteCustomer(CustomerDTO customerDTO);
}