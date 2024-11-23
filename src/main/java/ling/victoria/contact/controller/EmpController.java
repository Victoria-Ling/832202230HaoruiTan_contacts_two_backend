package ling.victoria.contact.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import ling.victoria.contact.pojo.Emp;
import ling.victoria.contact.pojo.PageBean;
import ling.victoria.contact.pojo.Result;
import ling.victoria.contact.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@CrossOrigin
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page
            (@RequestParam(defaultValue = "1") Integer page,
             @RequestParam(defaultValue = "10") Integer pageSize,
             @RequestParam(value = "name", required = false) String name, @RequestParam(value = "phone", required = false) String phone,
             @RequestParam(value = "gender", required = false) Integer gender,
             @RequestParam(value = "isFavorite", required = false) Integer isFavorite) {
        log.info("分页查询，参数为：page={},pageSize={}", page, pageSize, name, phone, gender);
        PageBean pageBean = empService.page(page, pageSize, name, phone, gender, isFavorite);
        return Result.success(pageBean);
    }

    @PostMapping("/emps/export")
    public void ExportExcel() {
        // 设置文件导出的路径
        String realPath = "D://wsfile/";
        File folder = new File(realPath);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        String fileName = realPath  + "User" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, Emp.class).sheet("用户表").doWrite(empService.findAll());
    }




    @PostMapping("/emps/import")
    public void ImportExcel(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return;
        }

        EasyExcel.read(multipartFile.getInputStream(), Emp.class, new PageReadListener<Emp>(dataList -> {
            for (Emp emp : dataList) {

                empService.insert(emp);
            }
        })).sheet().doRead();
    }



    @PostMapping("/emps/edit")
    public Result edit(@RequestBody Emp emp) {
        empService.updateAll(emp);
        return Result.success();
    }



    @PutMapping("/emps/insert")
    public Result insertEmp(@RequestBody Emp emp) {
        empService.insert(emp);
        return Result.success();
    }

    @GetMapping("/emps/changeFavorite")
    public Result changeFavorite(@RequestParam("id") Integer id, @RequestParam("isFavorite") Integer isFavorite) {
        empService.update(id, isFavorite);
        return Result.success();
    }

    @DeleteMapping("/emps/delete/{id}")
    public Result deleteEmp(@PathVariable Integer id) {
        empService.delete(id);
        return Result.success();
    }

}
