package com.mvc.mapper;

import com.mvc.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {
    @Results({
            @Result(property = "id", column = "p_id"),
            @Result(property = "cardId", column = "p_card_id"),
            @Result(property = "name", column = "p_name"),
            @Result(property = "pinyin", column = "p_name_pinyin"),
            @Result(property = "usedName", column = "p_used_name"),
            @Result(property = "sex", column = "p_sex"),
            @Result(property = "birth", column = "p_birth"),
            @Result(property = "politicalStatus", column = "p_political_status"),
            @Result(property = "phone", column = "p_phone"),
            @Result(property = "job", column = "p_job"),
            @Result(property = "hometown", column = "p_hometown"),
            @Result(property = "homeAddress", column = "p_home_address"),
            @Result(property = "officeAddress", column = "p_office_address"),
            @Result(property = "relationWithHost", column = "p_relation_with_host")
    })
    @Select("SELECT * from s_person")
    List<Person> findAll();

    @Results({
            @Result(property = "id", column = "p_id"),
            @Result(property = "cardId", column = "p_card_id"),
            @Result(property = "name", column = "p_name"),
            @Result(property = "pinyin", column = "p_name_pinyin"),
            @Result(property = "usedName", column = "p_used_name"),
            @Result(property = "sex", column = "p_sex"),
            @Result(property = "birth", column = "p_birth"),
            @Result(property = "politicalStatus", column = "p_political_status"),
            @Result(property = "phone", column = "p_phone"),
            @Result(property = "job", column = "p_job"),
            @Result(property = "hometown", column = "p_hometown"),
            @Result(property = "homeAddress", column = "p_home_address"),
            @Result(property = "officeAddress", column = "p_office_address"),
            @Result(property = "relationWithHost", column = "p_relation_with_host")
    })
    @Insert("insert into s_person(p_card_id,p_name,p_name_pinyin,p_used_name,p_sex,p_birth,p_political_status,p_phone,p_job" +
            "p_home_town,p_home_address,p_home_address,p_office_address,p_relation_with_host) values(#{cardId},#{name})," +
            "#{pinyin},#{usedName},#{sex},#{birth},#{politicalStatus},#{phone},#{job},#{hometown}," +
            "#{homeAddress},#{officeAddress},#{officeAddress},#{relationWithHost}")
    int addPerson(Person person);

    @Results({
            @Result(property = "id", column = "p_id"),
            @Result(property = "cardId", column = "p_card_id"),
            @Result(property = "name", column = "p_name"),
            @Result(property = "pinyin", column = "p_name_pinyin"),
            @Result(property = "usedName", column = "p_used_name"),
            @Result(property = "sex", column = "p_sex"),
            @Result(property = "birth", column = "p_birth"),
            @Result(property = "politicalStatus", column = "p_political_status"),
            @Result(property = "phone", column = "p_phone"),
            @Result(property = "job", column = "p_job"),
            @Result(property = "hometown", column = "p_hometown"),
            @Result(property = "homeAddress", column = "p_home_address"),
            @Result(property = "officeAddress", column = "p_office_address"),
            @Result(property = "relationWithHost", column = "p_relation_with_host")
    })
    @Select("select * from s_person where p_name=#{name}")
    Person findByName(String name);

    @Results({
            @Result(property = "id", column = "p_id"),
            @Result(property = "cardId", column = "p_card_id"),
            @Result(property = "name", column = "p_name"),
            @Result(property = "pinyin", column = "p_name_pinyin"),
            @Result(property = "usedName", column = "p_used_name"),
            @Result(property = "sex", column = "p_sex"),
            @Result(property = "birth", column = "p_birth"),
            @Result(property = "politicalStatus", column = "p_political_status"),
            @Result(property = "phone", column = "p_phone"),
            @Result(property = "job", column = "p_job"),
            @Result(property = "hometown", column = "p_hometown"),
            @Result(property = "homeAddress", column = "p_home_address"),
            @Result(property = "officeAddress", column = "p_office_address"),
            @Result(property = "relationWithHost", column = "p_relation_with_host")
    })
    @Select("select * where p_name = #{personName}")
    List<Person> findPersonByCondition(String personName);
}
