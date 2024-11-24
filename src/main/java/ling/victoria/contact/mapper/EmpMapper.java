package ling.victoria.contact.mapper;

import ling.victoria.contact.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmpMapper {
    //    查询总记录
    @Select("select count(*) from Emp")
    Long count();

    //    分页查询获取列表数据
    List<Emp> page(Integer start, Integer pageSize, String name, String phone, Integer gender,Integer isFavorite);

    // 获取某个备忘录详情
    @Select("select * from Emp where id=#{id}")
    Emp getOne(Integer id);

    @Update("update Emp set isFavorite = #{isFavorite} ,update_time= now() where id=#{id}")
    void changeFavorite(Integer id, @Param("isFavorite")Integer isFavorite);

    @Select("delete from Emp where id=#{id}")
    void delete(Integer id);



    //查询全部数据,导出excel
    @Select("select * from Emp")
    List<Emp> findAll();


    void insert(Emp emp);


    void updateAll(Emp emp);
}
