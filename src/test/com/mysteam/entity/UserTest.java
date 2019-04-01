package test.com.mysteam.entity;

import com.mysteam.entity.GameOrder;
import com.mysteam.entity.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * User Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 5, 2018</pre>
 */
public class UserTest {
    User user;

    @Before
    public void before() throws Exception {
        user = new User();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getEmail()
     */
    @Test
    public void testGetEmail() throws Exception {
        String email = "haoboyam@qq.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    /**
     * Method: setEmail(String email)
     */
    @Test
    public void testSetEmail() throws Exception {
        String email = "haoboyam@qq.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    /**
     * Method: getState()
     */
    @Test
    public void testGetState() throws Exception {
        Short state = 1;
        user.setState(state);
        assertEquals(state, user.getState());
    }

    /**
     * Method: setState(Short state)
     */
    @Test
    public void testSetState() throws Exception {
        Short state = 1;
        user.setState(state);
        assertEquals(state, user.getState());
    }

    /**
     * Method: getFansList()
     */
    @Test
    public void testGetFansList() throws Exception {
        List<User> fansList = new ArrayList<>();
        user.setFansList(fansList);
        assertEquals(fansList, user.getFansList());
    }

    /**
     * Method: setFansList(List<User> fansList)
     */
    @Test
    public void testSetFansList() throws Exception {
        List<User> fansList = new ArrayList<>();
        user.setFansList(fansList);
        assertEquals(fansList, user.getFansList());
    }

    /**
     * Method: getWishList()
     */
    @Test
    public void testGetWishList() throws Exception {
        List<GameOrder> wishList = new ArrayList<>();
        user.setWishList(wishList);
        assertEquals(wishList, user.getWishList());
    }

    /**
     * Method: setWishList(List<GameOrder> wishList)
     */
    @Test
    public void testSetWishList() throws Exception {
        List<GameOrder> wishList = new ArrayList<>();
        user.setWishList(wishList);
        assertEquals(wishList, user.getWishList());
    }

    /**
     * Method: getBuddyList()
     */
    @Test
    public void testGetBuddyList() throws Exception {
        List<User> buddyList = new ArrayList<>();
        user.setBuddyList(buddyList);
        assertEquals(buddyList, user.getBuddyList());
    }

    /**
     * Method: setBuddyList(List<User> buddyList)
     */
    @Test
    public void testSetBuddyList() throws Exception {
        List<User> buddyList = new ArrayList<>();
        user.setBuddyList(buddyList);
        assertEquals(buddyList, user.getBuddyList());
    }

    /**
     * Method: getUserId()
     */
    @Test
    public void testGetUserId() throws Exception {
        User user = new User();
        Integer expId = 10;
        user.setUserId(expId);
        assertEquals(expId, user.getUserId());
    }

    /**
     * Method: setUserId(Integer userId)
     */
    @Test
    public void testSetUserId() throws Exception {
        User user = new User();
        Integer expId = 10;
        user.setUserId(expId);
        assertEquals(expId, user.getUserId());
    }

    /**
     * Method: getAccount()
     */
    @Test
    public void testGetAccount() throws Exception {
        String account = "xhb";
        user.setAccount(account);
        assertEquals(account, user.getAccount());
    }

    /**
     * Method: setAccount(String account)
     */
    @Test
    public void testSetAccount() throws Exception {
        String account = "xhb";
        user.setAccount(account);
        assertEquals(account, user.getAccount());
    }

    /**
     * Method: getPassword()
     */
    @Test
    public void testGetPassword() throws Exception {
        String pswd = "xhb";
        user.setPassword(pswd);
        assertEquals(pswd, user.getPassword());
    }

    /**
     * Method: setPassword(String password)
     */
    @Test
    public void testSetPassword() throws Exception {
        String pswd = "xhb";
        user.setPassword(pswd);
        assertEquals(pswd, user.getPassword());
    }

    /**
     * Method: getAuthority()
     */
    @Test
    public void testGetAuthority() throws Exception {
        Integer authority=1;
        user.setAuthority(authority);
        assertEquals(authority,user.getAuthority());
    }

    /**
     * Method: setAuthority(Integer authority)
     */
    @Test
    public void testSetAuthority() throws Exception {
        Integer authority=1;
        user.setAuthority(authority);
        assertEquals(authority,user.getAuthority());
    }

    /**
     * Method: getGender()
     */
    @Test
    public void testGetGender() throws Exception {
        Boolean gender=false;
        user.setGender(gender);
        assertEquals(gender,user.getGender());
    }

    /**
     * Method: setGender(Boolean gender)
     */
    @Test
    public void testSetGender() throws Exception {
        Boolean gender=false;
        user.setGender(gender);
        assertEquals(gender,user.getGender());
    }

    /**
     * Method: getBalance()
     */
    @Test
    public void testGetBalance() throws Exception {
        Double balance=1.00;
        user.setBalance(balance);
        assertEquals(balance,user.getBalance());
    }

    /**
     * Method: setBalance(Double balance)
     */
    @Test
    public void testSetBalance() throws Exception {
        Double balance=1.00;
        user.setBalance(balance);
        assertEquals(balance,user.getBalance());
    }

    /**
     * Method: getCompany()
     */
    @Test
    public void testGetCompany() throws Exception {
        String company="zjut.cn";
        user.setCompany(company);
        assertEquals(company,user.getCompany());
    }

    /**
     * Method: setCompany(String company)
     */
    @Test
    public void testSetCompany() throws Exception {
        String company="zjut.cn";
        user.setCompany(company);
        assertEquals(company,user.getCompany());
    }


} 
