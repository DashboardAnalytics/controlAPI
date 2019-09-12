package com.cencosud.controlAPI.Repositories;

import com.cencosud.controlAPI.Models.ControlTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ControlTableRepository extends JpaRepository<ControlTable, String> {

    List<ControlTable> findByStoreAndAndShoppingCenter(String store, String shoppingCenter);

    ControlTable findByVideoName(String videoName);

    ControlTable findByStoreAndShoppingCenterAndVideoNumber(String store, String shoppingCenter, Long videoNumber);

    List<ControlTable> findByStatus(int status);


}
