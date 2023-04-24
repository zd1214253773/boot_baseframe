package com.sungrow.wind.controller;

import com.sungrow.wind.common.annotation.ApiPropIgnore;
import com.sungrow.wind.global.data.Result;
import com.sungrow.wind.service.DictitonaryService;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(value = "ParameterController", tags = {"ParameterController"})
@RestController
@RequestMapping(value = "/api")
public class ParameterController {
    @Autowired
    private DictitonaryService dictitonaryService;


    @ApiOperation("根据itemCode查询对应的value")
    @GetMapping("/parameter/value")
    public Result<Object> getByItemCode(@RequestParam String itemCode) {
        DictitonaryQueryVO dictitonaryQueryVO = new DictitonaryQueryVO();
        dictitonaryQueryVO.setItemCode(itemCode);
        List<DictitonaryVO> list = dictitonaryService.listBy(dictitonaryQueryVO);
        if(list.size() != 1) {
            if(list.size()==0) {
                throw new RuntimeException(String.format("没有配置[%s]链接", itemCode));
            }
            if(list.size()>1) {
                throw new RuntimeException(String.format("配置了多条重复的[%s]字典项", itemCode));
            }
        }
        return Result.success(list.get(0).getItemValue());
    }

}