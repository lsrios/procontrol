package br.com.projuris.procontrol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.projuris.procontrol.constants.Status;
import br.com.projuris.procontrol.models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    public Optional<Equipment> findByResponsible(String name);

    @Modifying
    @Query("update Equipment e set e.status = :status, e.description = :description where e.id = :id")
    public void updateStatusEquipment(Long id, Status status, String description);
}
