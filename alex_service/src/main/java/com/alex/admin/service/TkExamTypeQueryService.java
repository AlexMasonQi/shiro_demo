package com.alex.admin.service;

import com.alex.admin.dao.TkExamTypeDao;
import com.alex.admin.entity.TkExamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TkExamTypeQueryService
{
    @Autowired
    private TkExamTypeDao tkExamTypeDao;

    /**
     * @param isType 节点类型
     * @return 考试类型集合
     * @description 查询所有考试类型
     * @author Xu Shiqi
     * @date 2018.04.26 17:38
     */
    public List<TkExamType> selectAllExamType(Integer isType)
    {
        return tkExamTypeDao.selectAllExamType(isType);
    }

    /**
     * @param fid 考试类型ID
     * @return 考试科目集合
     * @description 查询考试类型对应的考试科目
     * @author Xu Shiqi
     * @date 2018.04.27
     */
    public List<TkExamType> selectSubjectByExamType(Integer fid)
    {
        return tkExamTypeDao.selectSubjectByExamType(fid);
    }

    /**
     * @return level集合
     * @description 获取所有知识点的level
     * @author Xu Shiqi
     * @date 2018.04.27
     */
    public List<Integer> selectAllLevelFromKnowledge()
    {
        return tkExamTypeDao.selectAllLevelFromKnowledge();
    }

    /**
     * @return 考试知识点集合
     * @description 获取所有的知识点
     * @author Xu Shiqi
     * @date 2018.04.27 11:56
     */
//    public Table<Integer, String, TkExamType> selectAllKnowledge()
//    {
//        List<TkExamType> tkExamTypeList = tkExamTypeDao.selectAllKnowledge();
//        List<Integer> levelList = selectAllLevelFromKnowledge();
//
//        Table<Integer, String, TkExamType> resultTable = HashBasedTable.create();
//
//        for (Integer level : levelList)
//        {
//            for (TkExamType tkExamType : tkExamTypeList)
//            {
//                if (level.equals(tkExamType.getLevel()))
//                {
//                    resultTable.put(level, tkExamType.getId() + "-" + tkExamType.getFid(), tkExamType);
//                }
//            }
//        }
//
//        return resultTable;
//    }

    /**
     * @return 考试知识点集合
     * @description 获取所有的知识点
     * @author Xu Shiqi
     * @date 2018.04.27 11:56
     */
    public List<TkExamType> selectAllKnowledge()
    {
        return tkExamTypeDao.selectAllKnowledge();
    }

    /**
     * @return 考试类型集合
     * @description 判断该节点是否存在子节点
     * @author Xu Shiqi
     * @date 2018.05.02 15:35
     */
    public List<Integer> isNodeExist()
    {
        return tkExamTypeDao.isNodeExist();
    }
}
