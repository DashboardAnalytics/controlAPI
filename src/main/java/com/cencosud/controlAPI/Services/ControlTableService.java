package com.cencosud.controlAPI.Services;

import com.cencosud.controlAPI.Models.ControlTable;
import com.cencosud.controlAPI.Repositories.ControlTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ControlTableService {

    @Autowired
    ControlTableRepository controlTableRepository;

    public ControlTable create(String videoName, int status, Long videoNumber, String store, String shoppingCenter){
        return controlTableRepository.save(new ControlTable(videoName, status, videoNumber, store, shoppingCenter));
    }

    public List<ControlTable> getAll(){
        return controlTableRepository.findAll();
    }

    public ControlTable getByVideoName(String videoName){
        return controlTableRepository.findByVideoName(videoName);
    }

    public List<ControlTable> getByStatus(int status){
        return controlTableRepository.findByStatus(status);
    }

    public List<ControlTable> getByStoreAndShopping(String store, String shoppingCenter){
        return controlTableRepository.findByStoreAndAndShoppingCenter(store, shoppingCenter);
    }

    public ControlTable getByStoreAndShoppingAndVideoNumber(String store, String shoppingCenter, Long videoNumber){
        return controlTableRepository.findByStoreAndShoppingCenterAndVideoNumber(store, shoppingCenter, videoNumber);
    }

    public ControlTable updateStatus(String videoName, int status){
        ControlTable result = controlTableRepository.findByVideoName(videoName);
        if(result != null){
            result.setStatus(status);
            return controlTableRepository.save(result);
        }
        else{
            return null;
        }
    }

    public void deleteAll(){
        controlTableRepository.deleteAll();
    }
}
