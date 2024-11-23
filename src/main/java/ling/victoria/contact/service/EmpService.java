package ling.victoria.contact.service;

import ling.victoria.contact.pojo.Emp;
import ling.victoria.contact.pojo.PageBean;

import java.util.List;

public interface EmpService {
//    分页查询
    PageBean page(Integer start, Integer pageSize,String name,String phone,Integer gender,Integer isFavorite) ;


    void delete(Integer id) ;

    Emp getOne(Integer id);

    void update(Integer id ,Integer isFavorite);

    void updateAll(Emp emp);


    void insert(Emp emp);

    List<Emp> findAll();
}
