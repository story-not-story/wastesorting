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

    /**
     * 展示指定顶级类目下所有类目信息
     * @param id
     * @return Result<JSONObject>
     */
    @GetMapping(value = "/class")
    public Result<JSONObject> getFirstClass(@RequestParam(value = "id") Integer id){
        return classificationService.getFirstClass(id);
    }

    /**
     * 添加物品到指定二级类目
     * @param thirdClass
     * @return Result<ThirdClass>
     */
    @PostMapping(value = "/thing", consumes = "application/json")
    public Result<ThirdClass> getFirstClass(@RequestBody ThirdClass thirdClass){
        ThirdClass thirdClass2 = new ThirdClass();
        thirdClass2.setParentId(thirdClass.getParentId());
        thirdClass2.setName(thirdClass.getName());
        thirdClass2.setPicAddr(thirdClass.getPicAddr());
        thirdClassRepository.save(thirdClass2);
        return ResultUtil.success();
    }

    /**
     * 搜索物品所属顶级类目下所有类目信息
     * @param name
     * @return Result<JSONObject>
     */
    @GetMapping(value = "/search")
    public Result<JSONObject> search(@RequestParam(value = "name") String name){
        return classificationService.search(name);
    }
}
