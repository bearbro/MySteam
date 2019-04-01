package test.com.mysteam.dao;

import com.mysteam.dao.UserDao;
import com.mysteam.entity.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

import static com.mysteam.constant.UserAuthority.APPLYING_DEVELOP;
import static com.mysteam.constant.UserAuthority.DEVELOPER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * UserDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>四月 12, 2018</pre>
 */
public class UserDaoTest {

    UserDao userDao;

    @Before
    public void before() throws Exception {
        ApplicationContext ctx =
                new FileSystemXmlApplicationContext("src/applicationContext.xml");
        userDao = (UserDao) ctx.getBean("userDao");
    }

    @After
    public void after() throws Exception {
        testDeleteUser();
    }

    /**
     * Method: selectUsersByAccount(String name)
     */
    @Test
    public void testSelectUsersByAccount() throws Exception {
        List<User> users = userDao.selectUsersByAccount("");
        assertEquals(6, users.size());
    }

    /**
     * Method: insert(User user)
     */
    @Test
    public void testInsert() throws Exception {
        User user = new User();
        //id自增加
        user.setAccount("text");
        user.setPassword("text");
        user.setBalance(10.0);
        user.setAuthority(1);
        user.setGender(true);
        assertTrue("添加失败", 1 == userDao.insert(user));

    }


    /**
     * Method: findByAccountAndPassword(String account, String password)
     */
    @Test
    public void testFindByAccountAndPassword() throws Exception {
        String account = "xhb";
        String password = "xhb";
        User user = userDao.findByAccountAndPassword(account, password);
        assertTrue("查找用户", account.equals(user.getAccount())
                && password.equals(user.getPassword()));
    }

    /**
     * Method: findByUserId(Integer userId)
     */
    @Test
    public void testFindByUserId() throws Exception {
//21	xhb	xhb	1	1	1638.01	zjut.com	773854587@qq.com
        User user = userDao.findByUserId(21);
        assertEquals("", "xhb", user.getAccount());
        assertEquals("xhb", user.getPassword());
        assertEquals(new Integer(1), user.getAuthority());
        assertEquals(true, user.getGender());
        assertEquals(new Double(1638.01), user.getBalance());
        assertEquals("zjut.com", user.getCompany());
        assertEquals("773854587@qq.com", user.getEmail());
        assertEquals(new Integer(21), user.getUserId());
    }

    /**
     * Method: selectApplyingDevelopers()
     */
    @Test
    public void testSelectApplyingDevelopers() throws Exception {
        List<User> applying = userDao.selectApplyingDevelopers();
        assertEquals(0, applying.size());
    }


    /**
     * Method: selectUserByAccount(String account)
     */
    @Test
    public void testSelectUserByAccount() throws Exception {
        String Account = "xhb";
        User user = userDao.selectUserByAccount(Account);
        assertTrue("查找用户", user.getAccount().equals(Account));
    }


    /**
     * Method: deleteUser(User user)
     */
    @Test
    public void testDeleteUser() throws Exception {
        String account = "text";
        User user = userDao.selectUserByAccount(account);
        userDao.deleteUser(user);
        assertTrue("删除失败", null == userDao.selectUserByAccount(account));

    }


    /**
     * Method: updateByUser(User user)
     */
    @Test
    public void testUpdateByUser() throws Exception {
        User user = userDao.selectUserByAccount("xhb");
        Double old = user.getBalance();
        user.setBalance(old + 10);
        userDao.updateByUser(user);
        user = userDao.selectUserByAccount("xhb");
        assertTrue("更新失败", old + 10 == user.getBalance());

    }

    //未写入报告的test

    /**
     * Method: applyDeveloperFailed(int applyId)
     */
    @Test
    public void testApplyDeveloperFailed() throws Exception {
        List<User> applying = userDao.selectApplyingDevelopers();
        int oldN = applying.size();
        if (oldN > 0) {
            userDao.applyDeveloperFailed(applying.get(0).getUserId());
            applying = userDao.selectApplyingDevelopers();
            int newN = applying.size();
            assertEquals(1, oldN - newN);
        }
    }

    /**
     * Method: applyDeveloperPassed(int applyId)
     */
    @Test
    public void testApplyDeveloperPassed() throws Exception {
        List<User> applying = userDao.selectApplyingDevelopers();
        int oldN = applying.size();
        if (oldN > 0) {
            userDao.applyDeveloperPassed(applying.get(0).getUserId());
            User user = userDao.findByUserId(applying.get(0).getUserId());
            assertEquals(DEVELOPER, user.getAccount());
        }
    }


    /**
     * Method: findBuddyByUserId(Integer userId)
     */
    @Test
    public void testFindBuddyByUserId() throws Exception {
        Integer userId = 21;
        Integer followUserId = 23;
        int old = userDao.findBuddyByUserId(userId).size();
        userDao.insertBuddy( followUserId,userId);
        int now = userDao.findBuddyByUserId(userId).size();
        userDao.deleteBuddy( followUserId,userId);
        assertEquals(1, now - old);
    }

    /**
     * Method: findFansByUserId(Integer userId)
     */
    @Test
    public void testFindFansByUserId() throws Exception {
        Integer userId = 21;
        Integer followUserId = 23;
        int old = userDao.findFansByUserId(followUserId).size();
        userDao.insertBuddy( followUserId,userId);
        int now = userDao.findFansByUserId(followUserId).size();
        userDao.deleteBuddy( followUserId,userId);
        assertEquals(1, now - old);
    }

    /**
     * Method: insertBuddy(int userId, int followUserId)
     *   followUserId 关注 userId
     */
    @Test
    public void testInsertBuddy() throws Exception {
        Integer userId = 21;
        Integer followUserId = 23;
        int old = userDao.findFansByUserId(followUserId).size();
        userDao.insertBuddy( followUserId,userId);
        int now = userDao.findFansByUserId(followUserId).size();
        userDao.deleteBuddy( followUserId,userId);
        assertEquals(1, now - old);
    }

    /**
     * Method: deleteBuddy(int userId, int followUserId)
     */
    @Test
    public void testDeleteBuddy() throws Exception {
        Integer userId = 21;
        Integer followUserId = 23;
        int old = userDao.findBuddyByUserId(userId).size();
        userDao.insertBuddy( followUserId,userId);
        userDao.deleteBuddy( followUserId,userId);
        int now = userDao.findBuddyByUserId(userId).size();
        assertEquals(0, now - old);
    }

    /**
     * Method: findWishByUserId(Integer userId)
     */
    @Test
    public void testFindWishByUserId() throws Exception {
//TODO: Test goes here...
    }

} 
