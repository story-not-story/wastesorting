package school.wastesorting.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.wastesorting.domain.Result;
import school.wastesorting.repository.ClassificationRepository;
import school.wastesorting.service.ClassificationService;
import school.wastesorting.util.ResultUtil;

@RestController
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @Autowired
    private ClassificationRepository classificationRepository;

    @PostMapping(value = "/class", consumes = "application/json")
    public Result<JSONObject> getFirstClass(@RequestBody Integer id){
        return classificationService.getFirstClass(id);
    }

    @PostMapping(value = "/thing", consumes = "application/json")
    public Result<JSONObject> getFirstClass(@RequestBody String name, @RequestBody Integer parentId){
        classificationRepository.saveThirdClass(name, parentId);
        return ResultUtil.success();
    }

    @PostMapping(value = "/search", consumes = "application/json")
    public Result<JSONObject> search(@RequestBody String name){
        return classificationService.search(name);
    }
}
