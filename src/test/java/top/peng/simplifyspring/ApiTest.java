package top.peng.simplifyspring;

import org.junit.Test;
import top.peng.simplifyspring.bean.UserService;
import top.peng.simplifyspring.beans.factory.BeanFactory;
import top.peng.simplifyspring.beans.factory.config.BeanDefinition;
import top.peng.simplifyspring.beans.factory.support.DefaultListableBeanFactory;

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

        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();

        //第二次获取bean
        UserService userServiceSingleton = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }
}