package test.com.mysteam.action;

import com.mysteam.action.BuyAction;
import com.mysteam.action.UserLoginAction;
import com.mysteam.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * UserLoginAction Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 6, 2018</pre>
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class UserLoginActionTestExample extends StrutsSpringTestCase {
    @Test
    public void testSuccessQuery() {
        ActionProxy proxy = getActionProxy("/userLogin");
        assertNotNull(proxy);

    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testUserLogin() throws Exception {
        //设置 请求参数
        request.setParameter("user.account", "xhb");
        request.setParameter("user.password", "xhb");

        //获取要测试Action
        ActionProxy proxy = getActionProxy("/userLogin");
        UserLoginAction ea = (UserLoginAction) proxy.getAction();
        proxy.execute();

        //获取Action中执行结果
        String r = ea.userLogin();
        assertEquals("playerLogin", r);

    }

    @Test
    public void testBuy() throws Exception {
        Map session=new HashMap<>();
        User user=new User();
        user.setBalance(12345.0);
        session.put("user",user);
        //获取要测试Action
        ActionProxy proxy = getActionProxy("/buy");
        BuyAction ea = (BuyAction) proxy.getAction();
        ea.setGameid(30);
        ea.setGetterid(23);
        //proxy.execute();
        //获取Action中执行结果
        ActionContext ac=ActionContext.getContext();
        ac.setSession(session);
        String r = ea.buy();
        assertEquals("alreadyhave", r);
    }

} 
