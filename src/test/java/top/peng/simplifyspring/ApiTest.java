package top.peng.simplifyspring;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import top.peng.simplifyspring.bean.UserDao;
import top.peng.simplifyspring.bean.UserService;
import top.peng.simplifyspring.beans.PropertyValue;
import top.peng.simplifyspring.beans.PropertyValues;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.beans.factory.config.BeanReference;
import top.peng.simplifyspring.beans.factory.support.DefaultListableBeanFactory;
import top.peng.simplifyspring.beans.factory.xml.XmlBeanDefinitionReader;
import top.peng.simplifyspring.common.MyBeanFactoryPostProcessor;
import top.peng.simplifyspring.common.MyBeanPostProcessor;
import top.peng.simplifyspring.context.support.ClassPathXmlApplicationContext;

/**
 * ApiTest
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){
        //初始化Bean Factory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册 UserDao
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));

        //UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        //UserService 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //UserService获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }


    @Test
    public void testBeanFactoryPostProcessorAndBeanPostProcessor(){
        //初始化Bean Factory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        //BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        //Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        //UserService获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String userInfo = userService.getUserInfo();
        System.out.println(userInfo);
    }

    @Test
    public void testApplicationContextXml(){
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String userInfo = userService.getUserInfo();
        System.out.println(userInfo);
        /*System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());*/
    }

    @Test
    public void textPrototype(){
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springFactoryBean.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void textFactoryBean(){
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springFactoryBean.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);

        // 3. 调用代理方法
        System.out.println(userService.getUserInfo());
    }
}