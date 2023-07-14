package com.example.qianhua.controller;

import com.alibaba.fastjson.JSONObject;
import com.baozun.i18n.context.I18nLocaleContextHolder;
import com.example.qianhua.Result;
import com.example.qianhua.config.AttrConfig;
import com.example.qianhua.config.FolderMarkMapConfig;
import com.example.qianhua.config.TemplateConfig;
import com.example.qianhua.config.TestConfig;
import com.example.qianhua.entity.*;
import com.example.qianhua.enums.SystemErrorCodeEnum;
import com.example.qianhua.exception.BizException;
import com.example.qianhua.filter.FilterManager;
import com.example.qianhua.requestVo.TestVo;
import com.example.qianhua.service.TestService;
import com.example.qianhua.utils.DozerUtils;
import com.example.qianhua.utils.SpringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.aspectj.weaver.tools.cache.CacheKeyResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

import java.util.stream.Collectors;

import static com.example.qianhua.entity.Constant.OPERATE;

@RestController
@PropertySource(value = "classpath:application-sit.yml",encoding = "UTF-8")
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

    @Value("#{${status:{}}}")
    private Map<String,String> status;

    @Value("${g-sdk.appKey}")
    private String appKey;

//    @Value("${user.name}")
//    private String username;
//
//    @Value("${user.sex}")
//    private String sex;

    private static final ThreadLocal<String> threadlocal = new ThreadLocal<>();

    private static final InheritableThreadLocal<String> inheritableThreadlocal = new InheritableThreadLocal<>();

    /**@RequestBody @Valid CheckHh checkHh, BindingResult result*/
    /**
     * 可继承的threadLocal,子线程会继承父线程中的threadlocal,子线程修改子线程的threadlocal不会改变父线程的threadlocal
     * @param testId
     */
    @PostMapping("/test/testSigno")
    public void testSigno(String testId){

//        Uu u = new Uu();
//        System.out.println(u);
//        System.out.println(this);
//
//        AttrEntity ae = new AttrEntity("100","11","200","jdj",true);
//        MyAttrEntity mae = new MyAttrEntity();
//
//        DozerUtils.map(ae,mae);
//        System.out.println(mae);

        I18nLocaleContextHolder.setLanguage("en_US");

        System.out.println("currentThread_name1:"+Thread.currentThread().getName());
        System.out.println("currentThread_name1_lang:"+I18nLocaleContextHolder.getLanguage());
        new Thread(()->{
            try {
                I18nLocaleContextHolder.setLanguage("zh_CN");
                Thread.sleep(5000L);
                System.out.println("currentThread_name2:"+Thread.currentThread().getName());
                System.out.println("currentThread_name1_lang:"+I18nLocaleContextHolder.getLanguage());
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }finally {
                I18nLocaleContextHolder.reset();
            }
        }).start();
        System.out.println("currentThread_name1_lang:"+I18nLocaleContextHolder.getLanguage());
        I18nLocaleContextHolder.reset();
    }


    @PostMapping("/test/threadtest")
    public void threadtest(String testId){
        threadlocal.set("currentThread_name1");
//        System.out.println("currentThread_name1:"+Thread.currentThread().getName());
//        System.out.println("currentThread_name1_lang:"+threadlocal.get());
        new Thread(()->{
            try {
                threadlocal.set("currentThread_name2");
                Thread.sleep(5000L);
//                System.out.println("currentThread_name2:"+Thread.currentThread().getName());
                System.out.println("currentThread_name2_lang:"+threadlocal.get());
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }finally {
                threadlocal.remove();
            }
            System.out.println("currentThread_name2_lang:"+threadlocal.get());
        }).start();
        System.out.println("currentThread_name1_lang:"+threadlocal.get());
        threadlocal.remove();
        System.out.println("currentThread_name1_lang:"+threadlocal.get());
    }

    @PostMapping("/test/inheritablethreadtest")
    public void inheritabletest(String testId){
        inheritableThreadlocal.set("currentThread_name1");
        System.out.println("currentThread_name1:"+Thread.currentThread().getName());
        System.out.println("currentThread_name1_lang:"+inheritableThreadlocal.get());
        new Thread(()->{
            try {
                inheritableThreadlocal.set("currentThread_name2");
                Thread.sleep(5000L);
                System.out.println("currentThread_name2:"+Thread.currentThread().getName());
                System.out.println("currentThread_name2_lang:"+inheritableThreadlocal.get());
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }finally {
                inheritableThreadlocal.remove();
            }
            System.out.println("currentThread_name22_lang:"+inheritableThreadlocal.get());
        }).start();
        System.out.println("currentThread_name1_lang:"+inheritableThreadlocal.get());
        inheritableThreadlocal.remove();
        System.out.println("currentThread_name11_lang:"+inheritableThreadlocal.get());
    }

    @PostMapping("/test/ttt")
    public void testInit(@RequestBody @Valid TestVo testVo){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String lang = request.getHeader("lang");

//        if (StringUtils.isEmpty(testVo.getTest())){
//            throw new BizException(SystemErrorCodeEnum.PARAM_ERROR.getMsg());
//        }
        System.out.println(JSONObject.toJSONString(testVo));
    }

    @PostMapping("/test/testI18")
    public void testI18Code(@RequestBody TestI18 testI18){

        System.out.println("...ok..."+appKey);
    }

    @GetMapping("/test/t1")
    public void test1(@RequestParam("testId") String testId,@RequestParam("testname") String testname) throws Exception {
//        if (testId.equals("111")){
//            throw new BizException("testId不能为111");
//        }else{
//            throw new Exception("ccccccc");
//        }

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
        System.out.println("controller:"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//        try{
//            List<String> ss = Arrays.asList("1","2");
//            System.out.println(ss.get(5));
//        }catch (Exception e){
//            log.error(e.getMessage(),e);
//            System.out.println(e.getMessage());
//            System.out.println(e);
////            throw new Exception();
//        }
        FilterManager sington = FilterManager.getSington();

        testService.testAsync();
        System.out.println("ok.....");
        return "ok";
    }

    @PostMapping("/test/async1")
    public String test5(String a) throws Exception{
        testService.test5Async();
        return "ok";
    }

    @PostMapping("/test/sleepThread")
    public Result sleepThread(){
        new Thread(()->{
            try {
                log.info("线程名称:{}，线程ID:{}",Thread.currentThread().getName(),Thread.currentThread().getId());
                Thread.sleep(6000*100L);
                log.info("线程跑完了！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return Result.success();
    }

    @PostMapping("/test/killThreadById")
    public Result killThreadById(@RequestParam Long pid){

        Boolean boo = this.killThread(pid);
        if (boo){
            return Result.success();
        }


        return Result.fail("失败");
    }

    private Boolean killThread(Long pid) {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        log.info("现有线程数" + noThreads);

        for (int i = 0; i < noThreads; i++) {
            String nm = lstThreads[i].getName();
            Long id = lstThreads[i].getId();

            log.info("线程号：" + i + " = " + nm);
            log.info("线程号：" + i + " = " + id);

//            if (nm.equals(name)) {
//                lstThreads[i].interrupt();
//
//                return true;
//
//            }
            if (pid.equals(id)) {
                lstThreads[i].interrupt();

                return true;

            }

        }

        return false;
    }

    @PostMapping("/test/qianhua")
    public Object qianhua(@RequestParam("name") String name,@RequestParam("nikeName") String nikeName){
        User u1 = new User("甲方",3,"men");
        User u2 = new User();
        BeanUtils.copyProperties(u1,u2);
        System.out.println("name:"+name+"---"+nikeName);
        return u1;
    }

    //内存做分页
    @PostMapping(value = "/test/ttt/qianhua")
    public List<Integer> ttts(int pageIndex,int pageSize){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        List<Integer> integers = currentPageData(pageIndex, pageSize, list.size(), list);
        return integers;
    }

    @Resource
    private FolderMarkMapConfig folderMarkMapConfig;




    @GetMapping(value = "/test/ttt/testConfig")
    public String testCofig(String aa){
        String s = status.get("001");
        System.out.println("s:"+s);
        System.out.println(JSONObject.toJSONString(status));
        String lang = "zh";
        if ("zh".equals(aa)){
            return JSONObject.toJSONString(folderMarkMapConfig.getZhMarkMap());
        }else{
            return JSONObject.toJSONString(folderMarkMapConfig.getEnMarkMap());
        }
    }

    @GetMapping(value = "/test/ttt/testLog")
    public String TestLog(String aa){
        testService.testLog();
        return "ok";
    }

    static List<Integer> currentPageData(Integer pageIndex, Integer pageSize, long count, List<Integer> list) {
        if (CollectionUtils.isEmpty(list)){
            return Collections.emptyList();
        }
        List<Integer> current = new ArrayList<>();
        int min = (pageIndex-1) * pageSize;
        int max = pageIndex * pageSize - 1;
        for (int i = min ; i<=max && i< count ;i++){
            current.add(list.get(i));
        }
        return current;
    }

    @PostMapping("/ttt")
    public void getdd(@RequestParam("name") String name){
        String activeProfile = SpringUtils.getActiveProfile();
        Object bean = SpringUtils.getBean("com.baozun.midcenter.publish.proxy.client.internalAutoProxyDdcAdapterClient.jddj");

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
//        for (int i = 0;i<10;i++){
//            if (i == 2){
//                throw new BizException("22","发布异常");
//            }
//        }

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
