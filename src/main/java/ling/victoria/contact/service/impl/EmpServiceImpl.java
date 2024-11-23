package ling.victoria.contact.service.impl;

import ling.victoria.contact.mapper.EmpMapper;
import ling.victoria.contact.pojo.Emp;
import ling.victoria.contact.pojo.PageBean;
import ling.victoria.contact.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, String phone, Integer gender,Integer isFavorite) {
        Long count = empMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize, name, phone, gender,isFavorite);
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;

    }

    @Override
    public void delete(Integer id) {
        empMapper.delete(id);
    }

    @Override
    public Emp getOne(Integer id) {
        return empMapper.getOne(id);
    }

    @Override
    public void update(Integer id, Integer isFavorite) {
        empMapper.changeFavorite(id, isFavorite);
    }

    @Override
    public void updateAll(Emp emp) {
        empMapper.updateAll(emp);
    }

    @Override
    public void insert(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public List<Emp> findAll() {

        return empMapper.findAll();
    }


}
