package test.com.mysteam.action;

import com.mysteam.action.BuyAction;
import com.mysteam.action.UserLoginAction;
import com.mysteam.action.WishAction;
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
public class WishActionTest extends StrutsSpringTestCase {

    @Test
    public void testSuccessQuery() {
        ActionProxy proxy = getActionProxy("/wishAction");
        assertNotNull(proxy);

    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testDeleteWish() throws Exception {
        Map session=new HashMap<>();
        User user=new User();
        user.setUserId(21);
        session.put("user",user);
        //获取要测试Action
        ActionProxy proxy = getActionProxy("/wishAction");
        WishAction ea = (WishAction) proxy.getAction();
        ea.setGameId(30);
        ea.setWishList(false);
        //proxy.execute();
        //获取Action中执行结果
        ActionContext ac=ActionContext.getContext();
        ac.setSession(session);
        String r = ea.deleteWish();
        assertEquals("gamedetail", r);

    }

    @Test
    public void testDeleteWish2() throws Exception {
        Map session=new HashMap<>();
        User user=new User();
        user.setUserId(21);
        session.put("user",user);
        //获取要测试Action
        ActionProxy proxy = getActionProxy("/wishAction");
        WishAction ea = (WishAction) proxy.getAction();
        ea.setGameId(30);
        ea.setWishList(true);
        //proxy.execute();
        //获取Action中执行结果
        ActionContext ac=ActionContext.getContext();
        ac.setSession(session);
        String r = ea.deleteWish();
        assertEquals("success", r);
    }

    @Test
    public void testUserWish() {
        //获取要测试Action
        ActionProxy proxy = getActionProxy("/wishAction");
        WishAction ea = (WishAction) proxy.getAction();
         ea.setUserId(21);
        //proxy.execute();
        //获取Action中执行结果
        String r = ea.userWish();
        assertEquals("success", r);
    }

    @Test
    public void testInsertWish() throws Exception {
        Map session=new HashMap<>();
        User user=new User();
        user.setUserId(21);
        session.put("user",user);
        //获取要测试Action
        ActionProxy proxy = getActionProxy("/wishAction");
        WishAction ea = (WishAction) proxy.getAction();
        ea.setGameId(30);
        //proxy.execute();
        //获取Action中执行结果
        ActionContext ac=ActionContext.getContext();
        ac.setSession(session);
        String r = ea.insertWish();
        assertEquals("success", r);
    }
} 
