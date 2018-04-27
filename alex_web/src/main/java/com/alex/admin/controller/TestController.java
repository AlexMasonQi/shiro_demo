package com.alex.admin.controller;

import com.alex.admin.entity.TkExamType;
import com.alex.admin.service.TkExamTypeQueryService;
import com.alex.admin.service.UserQueryService;
import com.alex.admin.util.RedisUtil;
import com.google.common.collect.Table;
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
import java.util.*;

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

    public void test()
    {
        Table<Integer, String, TkExamType> examTypeTable = tkExamTypeQueryService.selectAllKnowledge();

        List<Integer> levelList = new ArrayList<>(examTypeTable.rowKeySet());
        Collections.sort(levelList);

        //假设subjectId为前台传过来的科目ID
        Integer subjectId = 13570;

        for (Integer level : levelList)
        {
            Map<String, TkExamType> tkExamTypeMap = examTypeTable.row(level);
            Collection<TkExamType> tkExamTypes = tkExamTypeMap.values();

            for (TkExamType tkExamType : tkExamTypes)
            {
                if (subjectId.equals(tkExamType.getFid()))
                {
                    String[] arr = tkExamType.getName().split("_");
                    String newName = arr[arr.length - 1];
                    tkExamType.setName(newName);
                    System.out.println(tkExamType);
                }
            }
        }
    }
}
