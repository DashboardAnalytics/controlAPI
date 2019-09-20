package com.cencosud.controlAPI.Services;

import com.cencosud.controlAPI.Models.PipelineControl;
import com.cencosud.controlAPI.Repositories.PipelineControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PipelineControlService {

    @Autowired
    PipelineControlRepository pipelineControlRepository;

    public PipelineControl create(boolean status){
        List<PipelineControl> checkPipeline = pipelineControlRepository.findAll();
        if(checkPipeline.isEmpty()){
            return pipelineControlRepository.save(new PipelineControl(status));
        }
        else{
            PipelineControl existingPipeline = checkPipeline.get(0);
            existingPipeline.setStatus(status);
            return pipelineControlRepository.save(existingPipeline);
        }
    }

    public PipelineControl getPipeline(){
        List<PipelineControl> checkPipeline = pipelineControlRepository.findAll();
        if(checkPipeline.isEmpty()){
            return null;
        }
        else {
            return checkPipeline.get(0);
        }
    }

    public PipelineControl updatePipeline(boolean status){
        List<PipelineControl> checkPipeline = pipelineControlRepository.findAll();
        if(checkPipeline.isEmpty()){
            return null;
        }
        else {
            PipelineControl existingPipeline = checkPipeline.get(0);
            existingPipeline.setStatus(status);
            return pipelineControlRepository.save(existingPipeline);
        }
    }

}
