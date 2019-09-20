package com.cencosud.controlAPI.Controllers;

import com.cencosud.controlAPI.Models.PipelineControl;
import com.cencosud.controlAPI.Services.PipelineControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PipelineControlController {

    @Autowired
    PipelineControlService pipelineControlService;

    @PostMapping("/pipelineControl/create")
    @ResponseBody
    public HashMap<String, Object> create(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(json.get("status") != null){
            PipelineControl createResult = pipelineControlService.create(Boolean.parseBoolean(json.get("status").toString()));
            if(createResult != null){
                map.put("status", 201);
                map.put("message", "OK");
                map.put("result", true);
                return map;
            }
            else{
                map.put("status", 403);
                map.put("message", "Could not create new record.");
                map.put("result", false);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "One or more fields are empty.");
            map.put("result", false);
            return map;
        }
    }
    @PostMapping("/pipelineControl/update")
    @ResponseBody
    public HashMap<String, Object> update(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(json.get("status") != null){
            PipelineControl updateResult = pipelineControlService.updatePipeline(Boolean.parseBoolean(json.get("status").toString()));
            if(updateResult != null){
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                return map;
            }
            else{
                map.put("status", 403);
                map.put("message", "Could not update pipeline control.");
                map.put("result", false);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "One or more fields are empty.");
            map.put("result", false);
            return map;
        }
    }

    @GetMapping("/pipelineControl")
    @ResponseBody
    public HashMap<String, Object> get(){
        HashMap<String, Object> map = new HashMap<>();
        PipelineControl data = pipelineControlService.getPipeline();
        if(data != null){
            map.put("status", 200);
            map.put("message", "OK");
            map.put("result", true);
            map.put("data", data);
            return map;
        }
        else{
            map.put("status", 404);
            map.put("message", "NO PIPELINE FOUND.");
            map.put("result", false);
            map.put("data", null);
            return map;
        }
    }
}
