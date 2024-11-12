package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.AddressDTO;
import br.com.techchalleng4.mslogistica.model.Address;
import br.com.techchalleng4.mslogistica.model.Shipping;

public class AddressMapper {

    public static AddressDTO toDTO(Address address) {
        return AddressDTO.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .neighborhood(address.getNeighborhood())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zip(address.getZip())
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
                .zip(addressDTO.zip())
                .phone(addressDTO.phone())
                .shipping(shipping).build();
    }
}
