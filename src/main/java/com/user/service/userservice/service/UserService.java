package com.user.service.userservice.service;


import com.user.service.userservice.dto.UserDTO;
import com.user.service.userservice.entities.Invoice;
import com.user.service.userservice.entities.User;
import com.user.service.userservice.jpa.InvoiceRepository;
import com.user.service.userservice.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final InvoiceRepository invoiceRepository;

    public List<UserDTO> getUsers(List<String> ids) {

        log.info("looking into database for ids : {} ", ids);

        List<User> users = userRepository.findAllById(ids);

        users.stream()
                .forEach(user -> {

                    List<Invoice> invoices = invoiceRepository.findAllByUserId(user.getId());
                    user.setInvoicesNumbers(invoices);
                });

        return users.stream()
                .map(this::populateUserDTO)
                .collect(Collectors.toList());

    }

    private UserDTO populateUserDTO(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        userDTO.setGender(user.getGender());
        userDTO.setCreatedTime(user.getCreatedTime());
        userDTO.setUpdatedTime(user.getUpdatedTime());

        if( user.getInvoicesNumbers().size() > 0 ) {

            List<String> invoiceNumbers =
            user.getInvoicesNumbers()
                    .stream()
                    .map(Invoice::getInvoiceNumber)
                    .collect(Collectors.toList());

            userDTO.setInvoiceNumbers(invoiceNumbers);

        } else {
            userDTO.setInvoiceNumbers(Collections.EMPTY_LIST);
        }

        return userDTO;

    }
}
