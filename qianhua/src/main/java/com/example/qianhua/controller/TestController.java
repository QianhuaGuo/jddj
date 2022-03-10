package com.example.qianhua.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.qianhua.config.AttrConfig;
import com.example.qianhua.config.TemplateConfig;
import com.example.qianhua.config.TestConfig;
import com.example.qianhua.entity.AttrEntity;
import com.example.qianhua.entity.TemplateEntity;
import com.example.qianhua.entity.User;
import com.example.qianhua.requestVo.TestVo;
import com.example.qianhua.service.TestService;
import com.example.qianhua.utils.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;

import java.util.stream.Collectors;

import static com.example.qianhua.entity.Constant.OPERATE;

@RestController
public class TestController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Resource
    private TestConfig testConfig;
    @Resource
    private TemplateConfig templateConfig;
    @Resource
    private AttrConfig attrConfig;

    @Resource
    private ThreadPoolTaskExecutor myThreadPool;

    @Autowired
    private TestService testService;

    @Value("${tmall.name.fields}")
    private List<String> delField;

    @PostMapping("/test/ttt")
    public void testInit(@RequestBody TestVo testVo){
        System.out.println(JSONObject.toJSONString(testVo));
    }

    @PostMapping("/test/t1")
    public void test1(@RequestParam("testId") String testId){
        System.out.println("test1:"+testId);
    }
    @PostMapping("/test/t2")
    public void test2(@RequestParam("testId") String testId){
        System.out.println("test2:"+testId);
    }
    @PostMapping("/test/t3")
    public void test3(@RequestParam("testId") String testId){
        System.out.println("test3:"+testId);
    }
    @PostMapping("/test/async")
    public String test4()throws Exception{
        try{
            List<String> ss = Arrays.asList("1","2");
            System.out.println(ss.get(5));
        }catch (Exception e){
            log.error(e.getMessage(),e);
//            throw new Exception();
        }
        testService.testAsync();
        System.out.println("ok.....");
        return "ok";
    }

    @PostMapping("/test/qianhua")
    public Object qianhua(@RequestParam("name") String name,@RequestParam("nikeName") String nikeName){
        User u1 = new User("甲方",3,"men");
        User u2 = new User();
        BeanUtils.copyProperties(u1,u2);
        System.out.println("name:"+name+"---"+nikeName);
        return u1;
    }

    @PostMapping("/ttt")
    public void getdd(@RequestParam("name") String name){
        String activeProfile = SpringUtils.getActiveProfile();

        String ss = OPERATE;
        System.out.println("ss:"+ss);
        System.out.println(JSONObject.toJSONString(testConfig.getShopSessionKeyList()));
        System.out.println(JSONObject.toJSONString(myThreadPool));
        System.out.println(JSONObject.toJSONString(templateConfig.getDetailId()));
        System.out.println(JSONObject.toJSONString(templateConfig.getSourceId()));
        System.out.println(JSONObject.toJSONString(templateConfig.getVideoId()));
        TemplateEntity templateEntity = new TemplateEntity();
        templateEntity.setId("001");
        templateEntity.setDetailId(templateConfig.getDetailId());
        templateEntity.setSourceId(templateConfig.getSourceId());
        templateEntity.setVideoId(templateConfig.getVideoId());
        System.out.println(JSONObject.toJSONString(templateEntity));
        System.out.println("===========================================");
        Map<String, String> attrMap = attrConfig.getAttrMap();
        List<AttrEntity> attrEntities = new ArrayList<>();
        for (Map.Entry<String,String> entry : attrMap.entrySet()){
            AttrEntity attrEntity = new AttrEntity();
            attrEntity.setColumn(entry.getKey());
            attrEntity.setColumnName(entry.getValue());
            attrEntities.add(attrEntity);
        }
        System.out.println(JSONObject.toJSONString(attrEntities));
    }

    @PostMapping("/test/function")
    public void funcTest(){
        String str1 = "方法测试1";
        String str2 = "方法测试2";
        funcT(this::myfunction,str1,str2);
    }

    public int myfunction(String str2){
        System.out.println("str2:"+str2);
        User user = new User("花猪", 5, "WOM");
        testService.handlerUser(user,this::getUser);
        return 1;
    }

    public void funcT(Function<String, Integer> function,String str1,String str2){
        System.out.println(str1);
        if (function != null){
            function.apply(str2);
        }
    }

    protected List<User> getUser(User user){
        return Arrays.asList(user);
    }

    public static void main(String[] args) {
        List<String> one;
        List<String> two;
        List<String> o = new ArrayList<>();
        List<String> t = new ArrayList<>();
        o.add("a");
        o.add("b");
        o.add("c");
        o.add("d");

        t.add("c");
        t.add("d");
        t.add("g");
        t.add("h");

        List<String> c = new ArrayList<>();
        c.add("c");
        c.add("d");

        o.removeAll(c);
        one = o;
        t.removeAll(c);
        two = t;

        System.out.println("one:"+JSONObject.toJSONString(one));
        System.out.println("two:"+JSONObject.toJSONString(two));


        HashMap<String,Object> map = new HashMap<>();
        map.put("name","大花猪");
        User uu = new User();
        uu.setName((String) map.get("name"));
        uu.setAge((Integer) map.get("age"));
        uu.setSex((String) map.get("sex"));
        System.out.println(JSONObject.toJSONString(uu));

        boolean b = testReturn();
        System.out.println(b);
        String sb = testStringBuildAndStringBuffer();
        System.out.println("sb:"+sb);
        List<User> l1 = new ArrayList<>();
        List<User> l2 = new ArrayList<>();
        User l1U1 = new User("张三",15,"men");
        User l1U2 = new User("李四",16,"men");
        User l1U3 = new User("小芳",12,"women");


        User l1U4 = new User("大芳",12,"women");
//        User l1U5 = new User(null,12,"women");



        l1.add(l1U1);
        l1.add(l1U2);
        l1.add(l1U3);
        l1.add(l1U4);
//        List<User> ls = l1.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User :: getName))), ArrayList::new));
        Map<String, String> umap = l1.stream().collect(Collectors.toMap(User::getName, User::getSex));
        System.out.println("umap:"+JSONObject.toJSONString(umap));

//        System.out.println("ls:"+JSONObject.toJSONString(ls));
        User l2U1 = new User("赵柳",11,"women");
        User l2U2 = new User("小芳",12,"women");
        l2.add(l2U1);
        l2.add(l2U2);

        List<User> allUser = new ArrayList<>();
        allUser.addAll(l1);
        allUser.addAll(l2);

        System.out.println(JSONObject.toJSONString(allUser));
        //逆序处理
        Collections.reverse(allUser);
        System.out.println(JSONObject.toJSONString(allUser));

        //去重
        ArrayList<User> collect = allUser.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getName))), ArrayList::new));
        System.out.println(JSONObject.toJSONString(collect));
    }

    private static boolean testReturn() {
        for (int i = 0;i<10;i++){
            System.out.println("i:"+i);
            if (i == 5){
                return false;
            }
        }
        System.out.println("xxxxxxx");
        return true;
    }

    private static String testStringBuildAndStringBuffer() {
        StringBuffer sb = new StringBuffer();
        sb.append("aa").append("bb").append("cc");

        StringBuilder sb1 = new StringBuilder();
        sb1.append("dd").append("ee").append("ff");

//        return sb.toString();
        return sb1.substring(0,3);
    }

}
