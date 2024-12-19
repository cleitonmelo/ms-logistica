package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.AddressDTO;
import br.com.techchalleng4.mslogistica.model.Address;
import br.com.techchalleng4.mslogistica.model.Shipping;

public class AddressMapper {

    private  AddressMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static AddressDTO toDTO(Address address) {
        return AddressDTO.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .neighborhood(address.getNeighborhood())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .phone(address.getPhone())
                .build();
    }

    public static Address toEntity(AddressDTO addressDTO, Shipping shipping) {
        return Address.builder()
                .street(addressDTO.street())
                .number(addressDTO.number())
                .neighborhood(addressDTO.neighborhood())
                .city(addressDTO.city())
                .state(addressDTO.state())
                .country(addressDTO.country())
                .zipCode(addressDTO.zipCode())
                .phone(addressDTO.phone())
                .shipping(shipping).build();
    }
}
