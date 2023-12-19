package top.peng.simplifyspring;

import org.junit.Test;
import top.peng.simplifyspring.bean.UserService;

/**
 * ApiTest
 *
 * @author yunpeng.zhang
 * @version 1.0 2023/12/19
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){
        //初始化Bean
        BeanFactory beanFactory = new BeanFactory();

        //注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }
}