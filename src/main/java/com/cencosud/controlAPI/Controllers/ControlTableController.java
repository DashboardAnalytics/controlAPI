package com.cencosud.controlAPI.Controllers;

import com.cencosud.controlAPI.Models.ControlTable;
import com.cencosud.controlAPI.Services.ControlTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControlTableController {

    @Autowired
    ControlTableService controlTableService;

    private String api_key = "C020D7AD82F2F7F1476A8E95D95A39AA34E714EB8277539AF0D8011E1E8CB18D850B5D8DC4678F6E217271D398E635AA119F7FB88F55199A8C3CB4D628CA3DDA";

    @PostMapping("/controlTables/create")
    @ResponseBody
    public HashMap<String, Object> create(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(checkCreateData(json)){
            if(descomposeAndCreate(json)){
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

    @GetMapping("/controlTables/")
    @ResponseBody
    public List<ControlTable> getAllRecords(){
        return controlTableService.getAll();
    }

    @GetMapping("/controlTables/getVideoName")
    @ResponseBody
    public HashMap<String, Object> getByVideoName(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(json.get("videoName") != null){
            ControlTable result = controlTableService.getByVideoName(json.get("videoName").toString());
            if(result != null){
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", result);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "'videoName' NOT FOUND.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "NO 'videoName' PROVIDED.");
            map.put("result", false);
            map.put("data", null);
            return map;
        }
    }

    @GetMapping("/controlTables/getByStatus")
    @ResponseBody
    public HashMap<String, Object> getByStatus(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(json.get("status") != null){
            List<ControlTable> result = controlTableService.getByStatus(Integer.parseInt(json.get("status").toString()));
            if(result.isEmpty()){
                map.put("status", 404);
                map.put("message", "NO RECORDS FOUND BY PROVIDED 'status'.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
            else{
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", result);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "NO 'status' PROVIDED.");
            map.put("result", false);
            map.put("data", null);
            return map;
        }
    }

    @GetMapping("/controlTables/getByStoreAndShopping")
    @ResponseBody
    public HashMap<String, Object> getByStoreAndShopping(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(json.get("store") != null && json.get("shoppingCenter") != null){
            List<ControlTable> result = controlTableService.getByStoreAndShopping(json.get("store").toString(), json.get("shoppingCenter").toString());
            if(result.isEmpty()){
                map.put("status", 404);
                map.put("message", "NO RECORDS FOUND BY PROVIDED 'store' AND 'shoppingCenter'.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
            else{
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", result);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "NO 'store' OR 'shoppingCenter' PROVIDED.");
            map.put("result", false);
            map.put("data", null);
            return map;
        }
    }

    @GetMapping("/controlTables/getByStoreAndShoppingAndVideo")
    @ResponseBody
    public HashMap<String, Object> getByStoreAndShoppingAndVideo(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(json.get("store") != null && json.get("shoppingCenter") != null && json.get("videoNumber") != null){
            ControlTable result = controlTableService.getByStoreAndShoppingAndVideoNumber(json.get("store").toString(), json.get("shoppingCenter").toString(), Long.parseLong(json.get("videoNumber").toString()));
            if(result == null){
                map.put("status", 404);
                map.put("message", "NO RECORDS FOUND BY PROVIDED 'store', 'shoppingCenter' AND 'videoNumber'.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
            else{
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", result);
                return map;
            }
        }
        else{
            map.put("status", 403);
            map.put("message", "NO 'store', 'shoppingCenter' OR 'videoNumber' PROVIDED.");
            map.put("result", false);
            map.put("data", null);
            return map;
        }
    }

    @PostMapping("/controlTables/updateStatus")
    @ResponseBody
    public HashMap<String, Object> updateStatusFromVideo(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(json.get("videoName") != null && json.get("status") != null){
            ControlTable result = controlTableService.updateStatus(json.get("videoName").toString(), Integer.parseInt(json.get("status").toString()));
            if(result != null){
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                map.put("data", result);
                return map;
            }
            else{
                map.put("status", 404);
                map.put("message", "NO RECORDS FOUND BY PROVIDED 'videoName'.");
                map.put("result", false);
                map.put("data", null);
                return map;
            }
        }else{
            map.put("status", 403);
            map.put("message", "NO 'videoName' OR 'status' PROVIDED.");
            map.put("result", false);
            map.put("data", null);
            return map;
        }
    }

    @DeleteMapping("/controlTables/deleteData")
    @ResponseBody
    public HashMap<String, Object> deleteAll(@RequestBody Map<String, Object> json){
        HashMap<String, Object> map = new HashMap<>();
        if(json.get("apiKey") != null){
            String apiKey = json.get("apiKey").toString();
            if(apiKey.equals(api_key)){
                controlTableService.deleteAll();
                map.put("status", 200);
                map.put("message", "OK");
                map.put("result", true);
                return map;
            }
            else{
                map.put("status", 403);
                map.put("message", "WRONG APIKEY.");
                map.put("result", false);
                return map;
            }
        }
        else {
            map.put("status", 403);
            map.put("message", "NO 'apiKey' PROVIDED.");
            map.put("result", false);
            return map;
        }
    }



    private boolean checkCreateData(Map<String, Object> json){
        if(json.get("videoName") != null && json.get("status") != null && json.get("videoNumber") != null && json.get("store") != null && json.get("shoppingCenter") != null){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean descomposeAndCreate(Map<String, Object> json){
        String videoName = json.get("videoName").toString();
        int status = Integer.parseInt(json.get("status").toString());
        Long videoNumber = Long.parseLong(json.get("videoNumber").toString());
        String store = json.get("store").toString();
        String shoppingCenter = json.get("shoppingCenter").toString();

        ControlTable result = controlTableService.create(videoName, status, videoNumber, store, shoppingCenter);
        if(result != null){
            return true;
        }
        else{
            return false;
        }
    }


}
