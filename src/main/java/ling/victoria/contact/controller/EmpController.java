package ling.victoria.contact.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
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
import java.util.ArrayList;
import java.util.List;

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
    public Result ExportExcel() {
        // 设置文件导出的路径
        // 改成自己的系统
        String realPath = "/www/wwwroot/project/upload/";
        File folder = new File(realPath);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        long time =System.currentTimeMillis();
        String fileName = realPath  + "User" + time + ".xlsx";


        EasyExcel.write(fileName, Emp.class).sheet("用户表").registerWriteHandler(new SimpleColumnWidthStyleStrategy(25)).registerWriteHandler(new SimpleRowHeightStyleStrategy((short)30,(short)30)).doWrite(empService.findAll());
        return Result.success("/assets/"+"User" + time + ".xlsx");
    }




    @PostMapping("/emps/import")
    public Result ImportExcel(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return Result.error("文件为空");
        }

        EasyExcel.read(multipartFile.getInputStream(), Emp.class, new PageReadListener<Emp>(dataList -> {
            for (Emp emp : dataList) {
                empService.insert(emp);
            }
        })).sheet().doRead();

        return Result.success("导入成功");
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
