package school.wastesorting.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.wastesorting.domain.FirstClass;
import school.wastesorting.domain.Result;
import school.wastesorting.domain.SecondClass;
import school.wastesorting.domain.ThirdClass;
import school.wastesorting.enums.ErrorCode;
import school.wastesorting.repository.ClassificationRepository;
import school.wastesorting.util.ResultUtil;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificationService {
    @Autowired
    private ClassificationRepository classificationRepository;

    @Transactional(rollbackFor = Exception.class)
    public Result<JSONObject> getFirstClass(Integer id){
        Optional<FirstClass> optional = classificationRepository.findById(id);
        if(!optional.isPresent()){
            return ResultUtil.fail(ErrorCode.CATEGORY_NOT_FOUND);
        }
        FirstClass firstClass = optional.get();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", firstClass.getName());
        jsonObject.put("description", firstClass.getDesciption());
        jsonObject.put("requirement", firstClass.getRequirement());
        List<SecondClass> secondList = classificationRepository.findSecondByFirst(firstClass.getId());
        JSONArray jsonArray  = new JSONArray();
        secondList.forEach(s -> {
            List <ThirdClass> thirdList =classificationRepository.findThirdBySecond(s.getId());
            JSONArray thirdArray = new JSONArray();
            thirdList.forEach(o -> thirdArray.add(o.getName()));
            JSONObject object = new JSONObject();
            object.put("secondId", s.getId());
            object.put(s.getName(), thirdArray);
            jsonArray.add(object);
        });
        jsonObject.put("classification", jsonArray);
        return ResultUtil.success(jsonObject);
    }

    @Transactional(rollbackFor = Exception.class)
    public Result<JSONObject> search(String name){
        Integer id = classificationRepository.findFirstIdByThirdName(name);
        if (id == null) {
            return ResultUtil.fail(ErrorCode.THING_NOT_FOUND);
        }
        return getFirstClass(id);
    }
}
