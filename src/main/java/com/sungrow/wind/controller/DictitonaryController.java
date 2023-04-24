package com.sungrow.wind.controller;

import com.sungrow.wind.common.annotation.ApiPropIgnore;
import com.sungrow.wind.global.data.Result;
import com.sungrow.wind.service.DictitonaryService;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import com.sungrow.wind.common.annotation.ApiPropIgnore;
import io.swagger.annotations.*;

import java.util.List;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "DictitonaryController", tags = {"DictitonaryController"})
@RestController
@RequestMapping(value = "/dictitonary")
public class DictitonaryController {
    @Autowired
    private DictitonaryService dictitonaryService;

    @ApiOperation("删除Dictitonary对象")
    @DeleteMapping
    public Result<Object> deleteByPrimaryKey(@RequestBody DictitonaryVO dictitonaryVO) {
        return Result.success(dictitonaryService.deleteByPrimaryKey(dictitonaryVO));
    }

    @ApiOperation("插入Dictitonary对象")
    @PostMapping
    public Result<Object> insert(@RequestBody DictitonaryVO dictitonaryVO) {
        return Result.success(dictitonaryService.insert(dictitonaryVO));
    }

    @GetMapping
    @ApiOperation("查询Dictitonary对象")
    public Result<DictitonaryVO> selectByPrimaryKey(@RequestParam String dictionaryId) {
        return Result.success(dictitonaryService.selectByPrimaryKey(dictionaryId));
    }

    @ApiOperation("编辑Dictitonary对象")
    @PutMapping
    public Result<Object> updateByPrimaryKey(@RequestBody DictitonaryVO dictitonaryVO) {
        return Result.success(dictitonaryService.updateByPrimaryKey(dictitonaryVO));
    }

    @GetMapping("/page")
    @ApiOperation("查询Dictitonary对象-支持分页")
    public Result<List<DictitonaryVO>> listByPage(@ModelAttribute DictitonaryQueryVO dictitonaryQueryVO) {
        return Result.success(dictitonaryService.listByPage(dictitonaryQueryVO));
    }

    @SneakyThrows
    @GetMapping("/listBy")
    @ApiOperation("查询Dictitonary对象-不支持分页")
    public Result<List<DictitonaryVO>> listBy(@ApiPropIgnore("pageParam") @ModelAttribute DictitonaryQueryVO dictitonaryQueryVO) {
        log.info("查询字典。");
        Thread.sleep(210000);
        log.info("结束查询字典。");
        return Result.success(dictitonaryService.listBy(dictitonaryQueryVO));
    }

    @ApiOperation("批量插入Dictitonary对象")
    @PostMapping("/batch")
    public Result<Object> insertBatch(@RequestBody List<DictitonaryVO> dictitonaryVOs) {
        return Result.success(dictitonaryService.insertBatch(dictitonaryVOs));
    }

    @ApiOperation("根据groupKey查询Dictitonary对象")
    @GetMapping("/group")
    public Result<Object> listByGroupKey(@RequestParam String groupKey) {
        return Result.success(dictitonaryService.listByGroupKey(groupKey));
    }

    @ApiOperation("根据groupKey查询Dictitonary对象-折叠成树形")
    @GetMapping("/group/tree")
    public Result<Object> listTreeByGroupKey(@RequestParam String groupKey) {
        return Result.success(dictitonaryService.listTreeByGroupKey(groupKey));
    }


    @ApiOperation("获取所有字典条目Map，根据groupKey作为key，组装成Map")
    @GetMapping("/mapByGroup")
    public Result<Object> mapByGroup() {
        return Result.success(dictitonaryService.mapByGroupKey());
    }

}