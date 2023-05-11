package com.itzlk.mapper;

import com.itzlk.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {


    //查询所有
    //1.配置文件方式
    List<Brand> selectAll();

    //2注解方式
//    @select("select  from tb_brand")
//    @ResultMap ( "brandResultMap")
//    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据id查询
     */
    @Select("select * from tb_brand where id=#{id}")
    @ResultMap("BrandResultMap")
    Brand selectById(int id);


    /**
     * 更新数据
     */
    void update(Brand brand);

    /**
     * 删除数据
     */
    void deleteById(int id);

    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);


    /**
     * 分页查询,Brand对象
     */
    @Select("select * from tb_brand limit #{begin},#{size}")
    @ResultMap("BrandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 分页查询,查询总的条目数
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    /**
     * 分页查询之根据条件查询
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询所有条目数
     */
    int selectTotalCountByCondition(Brand brand);
}
