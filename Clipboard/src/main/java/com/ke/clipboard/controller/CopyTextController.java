package com.ke.clipboard.controller;

import com.ke.clipboard.common.Result;
import com.ke.clipboard.model.CopyText;
import com.ke.clipboard.service.CopyTextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Slf4j
@RestController
public class CopyTextController {
    @Autowired
    CopyTextService copyTextService;

    @RequestMapping(value = "/add")
    public  Result<Integer> add(@RequestBody String msg) throws ParseException {
        log.info("received request: {}" , msg);
        int id = copyTextService.insert(msg);
        return Result.success(id);
    }
    @GetMapping("/findall")
    public Result<List<CopyText>> findAll(
            @RequestParam(value = "count", defaultValue = "") Integer count,
            @RequestParam(value = "isOnlyMarked", defaultValue = "false") Boolean isOnlyMarked){
        return Result.success(copyTextService.find(count, isOnlyMarked));
    }

    @GetMapping("/query")
    public Result<List<CopyText>> findByParam(@RequestParam(value = "msg", defaultValue = "") String msg){
        return Result.success(copyTextService.query(msg));
    }

    @GetMapping("/remark")
    public Result<Void> remark(@RequestParam(value = "id") Integer id){
        copyTextService.remark(id);
        return Result.success();
    }
}
