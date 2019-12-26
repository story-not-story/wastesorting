package school.wastesorting.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.wastesorting.domain.Result;
import school.wastesorting.domain.ThirdClass;
import school.wastesorting.repository.ThirdClassRepository;
import school.wastesorting.service.ClassificationService;
import school.wastesorting.util.ResultUtil;

@RestController
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @Autowired
    private ThirdClassRepository thirdClassRepository;

    @PostMapping(value = "/class", consumes = "application/json")
    public Result<JSONObject> getFirstClass(@RequestBody Integer id){
        return classificationService.getFirstClass(id);
    }

    @PostMapping(value = "/thing", consumes = "application/json")
    public Result<JSONObject> getFirstClass(@RequestBody ThirdClass thirdClass){
        ThirdClass thirdClass2 = new ThirdClass();
        thirdClass2.setParentId(thirdClass.getParentId());
        thirdClass2.setName(thirdClass.getName());
        thirdClass2.setPicAddr(thirdClass.getPicAddr());
        thirdClassRepository.save(thirdClass2);
        return ResultUtil.success();
    }

    @PostMapping(value = "/search", consumes = "application/json")
    public Result<JSONObject> search(@RequestBody String name){
        return classificationService.search(name);
    }
}
