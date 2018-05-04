package com.alex.admin.controller;

import com.alex.admin.entity.TkExamType;
import com.alex.admin.service.TkExamTypeQueryService;
import com.alex.admin.service.UserQueryService;
import com.alex.admin.util.RedisUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private TkExamTypeQueryService tkExamTypeQueryService;

    @RequestMapping("/index")
    public String showIndex()
    {
        return "login";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Integer uploadFile(@RequestParam("testFile") MultipartFile file, HttpServletRequest request) throws IOException
    {
        if (file.isEmpty())
        {
            logger.warn("文件为空");
            return -1;
        }

        String fileName = file.getOriginalFilename();

        String path = request.getServletContext().getRealPath("/") + "/images";

        File uploadFile = new File(path + File.separator + fileName);

        if (!uploadFile.getParentFile().exists())
        {
            uploadFile.getParentFile().mkdir();
        }

        file.transferTo(uploadFile);

        return 1;
    }

    @RequestMapping("/zTree")
    public String showZTreeDemo(Map model)
    {
        return "testExamType";
    }

    private List<TkExamType> getKnowledgeBySubjectId(List<TkExamType> tkExamTypeList, Integer id)
    {
        List<TkExamType> resultList = new ArrayList<>();

        for (TkExamType tkExamType : tkExamTypeList)
        {
            if (id.equals(tkExamType.getFid()))
            {
                String[] arr = tkExamType.getName().split("_");
                String newName = arr[arr.length - 1];
                tkExamType.setName(newName);

                resultList.add(tkExamType);
                List<TkExamType> tempList = getKnowledgeBySubjectId(tkExamTypeList, tkExamType.getId());
                //如果没有子节点，则作为叶子节点
                tkExamType.setIsParent(false);
                if (tempList.size() > 0)
                {
                    tkExamType.setIsParent(true);
                }
                tkExamType.setNodes(tempList);
            }
        }

        return resultList;
    }

    @RequestMapping("/showMenu")
    @ResponseBody
    public String showMenu(Integer subjectId)
    {
        List<TkExamType> tkExamTypeList = tkExamTypeQueryService.selectAllKnowledge();

        List<TkExamType> results = getKnowledgeBySubjectId(tkExamTypeList, subjectId);

        String jsonString = JSON.toJSONString(results);
        System.out.println(jsonString);

        return jsonString;
    }
}
