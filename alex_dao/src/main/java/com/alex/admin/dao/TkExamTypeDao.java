package com.alex.admin.dao;

import com.alex.admin.entity.TkExamType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TkExamTypeDao
{
    List<TkExamType> selectAllExamType(@Param("isType") Integer isType);

    List<TkExamType> selectSubjectByExamType(@Param("fid") Integer fid);

    List<Integer> selectAllLevelFromKnowledge();

    List<TkExamType> selectAllKnowledge();

    List<Integer> isNodeExist();
}
