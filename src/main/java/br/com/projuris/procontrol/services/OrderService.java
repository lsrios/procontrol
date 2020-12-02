package br.com.projuris.procontrol.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projuris.procontrol.models.Equipment;
import br.com.projuris.procontrol.repositories.EquipmentRepository;

@Service
public class OrderService {
    private EquipmentRepository equipmentRepository;

    @Autowired
    public OrderService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Optional<Equipment> getEquipmentById(long id) {
        return equipmentRepository.findById(id);
    }

    public Optional<Equipment> createOrder(Equipment equipment) {
        return Optional.of(equipmentRepository.saveAndFlush(equipment));
    }

    public Optional<Equipment> getEquipmentByResponsibleName(String name) {
        return equipmentRepository.findByResponsible(name);
    }

    public void updateOrderStatus(Equipment equipmentWithNewStatus) {
        equipmentRepository.updateStatusEquipment(
            equipmentWithNewStatus.getId(), 
            equipmentWithNewStatus.getStatus(), 
            equipmentWithNewStatus.getDescription()
        );
    }
}
