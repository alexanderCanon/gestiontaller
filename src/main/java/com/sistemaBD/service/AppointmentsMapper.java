package com.sistemaBD.service;

import com.sistemaBD.domain.Appointments;
import com.sistemaBD.domain.Customer;
import com.sistemaBD.domain.Mechanic;
import com.sistemaBD.domain.Vehicles;
import com.sistemaBD.dto.AppointmentsRequestDTO;
import com.sistemaBD.dto.AppointmentsResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, ServiceMapper.class, MechanicMapper.class, VehicleMapper.class, OilMapper.class})
public interface AppointmentsMapper {

    @Mapping(target = "id.citaId", source = "citaId")
    @Mapping(target = "id.servicioId", source = "servicioId")
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "aceite", source = "incluyeAceite")
    @Mapping(target = "cliente", source = "clienteId", qualifiedByName = "mapCliente")
    @Mapping(target = "mecanico", source = "mecanicoId", qualifiedByName = "mapMecanico")
    @Mapping(target = "vehiculo", source = "vehiculoPlaca", qualifiedByName = "mapVehiculo")
    @Mapping(target = "servicio", ignore = true) // Ignorado porque ya está en el ID
    Appointments toEntity(AppointmentsRequestDTO dto);

    @Mapping(source = "id.citaId", target = "citaId")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "servicio", target = "servicio")
    @Mapping(source = "mecanico", target = "mecanico")
    @Mapping(source = "vehiculo", target = "vehiculo")
    @Mapping(source = "aceite", target = "incluyeAceite")
    AppointmentsResponseDTO toResponseDTO(Appointments entity);

    List<AppointmentsResponseDTO> toResponseDTOList(List<Appointments> appointments);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "mecanico", ignore = true)
    @Mapping(target = "vehiculo", ignore = true)
    @Mapping(target = "servicio", ignore = true)
    void updateEntityFromDto(AppointmentsRequestDTO dto, @MappingTarget Appointments entity);

    // Métodos para ayudar a MapStruct a resolver las relaciones a partir de IDs
    @Named("mapCliente")
    default Customer mapCliente(Integer id) {
        if (id == null) return null;
        Customer c = new Customer();
        c.setClienteId(id);
        return c;
    }

    @Named("mapMecanico")
    default Mechanic mapMecanico(String id) {
        if (id == null) return null;
        Mechanic m = new Mechanic();
        m.setMecanicoId(id);
        return m;
    }

    @Named("mapVehiculo")
    default Vehicles mapVehiculo(String placa) {
        if (placa == null) return null;
        Vehicles v = new Vehicles();
        v.setPlaca(placa);
        return v;
    }
}
