package test.com.mysteam.entity;

import com.mysteam.entity.Game;
import com.mysteam.entity.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Date;

import static com.mysteam.constant.GameState.ON_SALE;
import static org.junit.Assert.assertEquals;

/**
 * Game Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 5, 2018</pre>
 */
public class GameTest {
    Game game;

    @Before
    public void before() throws Exception {
        game = new Game();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getGameId()
     */
    @Test
    public void testGetGameId() throws Exception {
        Integer id = 10;
        game.setGameId(id);
        assertEquals(id, game.getGameId());
    }

    /**
     * Method: setGameId(Integer gameId)
     */
    @Test
    public void testSetGameId() throws Exception {
        Integer id = 10;
        game.setGameId(id);
        assertEquals(id, game.getGameId());
    }

    /**
     * Method: getGameName()
     */
    @Test
    public void testGetGameName() throws Exception {
        String name = "test";
        game.setGameName(name);
        assertEquals(name, game.getGameName());
    }

    /**
     * Method: setGameName(String gameName)
     */
    @Test
    public void testSetGameName() throws Exception {
        String name = "test";
        game.setGameName(name);
        assertEquals(name, game.getGameName());
    }

    /**
     * Method: getDeveloper()
     */
    @Test
    public void testGetDeveloper() throws Exception {
        User user = new User();
        game.setDeveloper(user);
        assertEquals(user, game.getDeveloper());
    }

    /**
     * Method: setDeveloper(User developer)
     */
    @Test
    public void testSetDeveloper() throws Exception {
        User user = new User();
        game.setDeveloper(user);
        assertEquals(user, game.getDeveloper());
    }

    /**
     * Method: getType()
     */
    @Test
    public void testGetType() throws Exception {
        String type = "动作";
        game.setType(type);
        assertEquals(type, game.getType());
    }

    /**
     * Method: setType(String type)
     */
    @Test
    public void testSetType() throws Exception {
        String type = "动作";
        game.setType(type);
        assertEquals(type, game.getType());
    }

    /**
     * Method: getPrice()
     */
    @Test
    public void testGetPrice() throws Exception {
        Double price = 100.0;
        game.setPrice(price);
        assertEquals(price, game.getPrice());
    }

    /**
     * Method: setPrice(Double price)
     */
    @Test
    public void testSetPrice() throws Exception {
        Double price = 100.0;
        game.setPrice(price);
        assertEquals(price, game.getPrice());
    }

    /**
     * Method: getVersion()
     */
    @Test
    public void testGetVersion() throws Exception {
        String version = "1.0.0";
        game.setVersion(version);
        assertEquals(version, game.getVersion());
    }

    /**
     * Method: setVersion(String version)
     */
    @Test
    public void testSetVersion() throws Exception {
        String version = "1.0.0";
        game.setVersion(version);
        assertEquals(version, game.getVersion());
    }

    /**
     * Method: getState()
     */
    @Test
    public void testGetState() throws Exception {
        Short state = ON_SALE;
        game.setState(state);
        assertEquals(state, game.getState());
    }

    /**
     * Method: setState(Short state)
     */
    @Test
    public void testSetState() throws Exception {
        Short state = ON_SALE;
        game.setState(state);
        assertEquals(state, game.getState());
    }

    /**
     * Method: getOnSaleDate()
     */
    @Test
    public void testGetOnSaleDate() throws Exception {
        Date onSaleDate = new Date();
        game.setOnSaleDate(onSaleDate);
        assertEquals(onSaleDate, game.getOnSaleDate());
    }

    /**
     * Method: setOnSaleDate(Date onSaleDate)
     */
    @Test
    public void testSetOnSaleDate() throws Exception {
        Date onSaleDate = new Date();
        game.setOnSaleDate(onSaleDate);
        assertEquals(onSaleDate, game.getOnSaleDate());
    }

    /**
     * Method: getIntroduction()
     */
    @Test
    public void testGetIntroduction() throws Exception {
        String introduction = "这是个好游戏";
        game.setIntroduction(introduction);
        assertEquals(introduction, game.getIntroduction());
    }

    /**
     * Method: setIntroduction(String introduction)
     */
    @Test
    public void testSetIntroduction() throws Exception {
        String introduction = "这是个好游戏";
        game.setIntroduction(introduction);
        assertEquals(introduction, game.getIntroduction());
    }

    /**
     * Method: getOriginId()
     */
    @Test
    public void testGetOriginId() throws Exception {
        Integer originId = 76;
        game.setOriginId(originId);
        assertEquals(originId, game.getOriginId());
    }

    /**
     * Method: setOriginId(Integer originId)
     */
    @Test
    public void testSetOriginId() throws Exception {
        Integer originId = 76;
        game.setOriginId(originId);
        assertEquals(originId, game.getOriginId());
    }


} 
