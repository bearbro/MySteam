package test.com.mysteam.dao;

import com.mysteam.dao.GameDao;
import com.mysteam.entity.Game;
import com.mysteam.entity.GameOrder;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * GameDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 6, 2018</pre>
 */
public class GameDaoTest {
    GameDao gameDao;

    @Before
    public void before() throws Exception {
        ApplicationContext ctx =
                new FileSystemXmlApplicationContext("src/applicationContext.xml");
        gameDao = (GameDao) ctx.getBean("gameDao");
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectAllGames()
     */
    @Test
    public void testSelectAllGames() throws Exception {
        List<Game> gameList = gameDao.selectAllGames();
        assertEquals(5, gameList.size());
    }

    /**
     * Method: selectGamesByName(String name)
     */
    @Test
    public void testSelectGamesByName() throws Exception {
        List<Game> gameList = gameDao.selectAllGames();
        List<Game> game = gameDao.selectGamesByName(gameList.get(0).getGameName());
        assertTrue(game.size() > 0);
    }


    /**
     * Method: insertApplyGame(Game game)
     */
    @Test
    public void testInsertApplyGame() throws Exception {
        Game game = gameDao.selectAllGames().get(0);
        game.setGameId(-1);
        game.setGameName("test");
        gameDao.insertApplyGame(game);
        Game game1 = gameDao.selectApplyingGameById(game.getGameId());
        gameDao.deleteApplyingGameById(game.getGameId());
        assertTrue(null!=game1);
    }

    /**
     * Method: selectByGameId(Integer gameId)
     */
    @Test
    public void testSelectByGameId() throws Exception {
        List<Game> gameList = gameDao.selectAllGames();
        Game game = gameDao.selectByGameId(gameList.get(0).getGameId());
        assertEquals(game.getGameId(), gameList.get(0).getGameId());
    }

    /**
     * Method: selectApplyingGameById(Integer gameId)
     */
    @Test
    public void testSelectApplyingGameById() throws Exception {
        Game game = gameDao.selectApplyingGames().get(0);
        Game game1 = gameDao.selectApplyingGameById(game.getGameId());
        assertEquals(game.getGameId(), game1.getGameId());
    }

    /**
     * Method: deleteApplyingGameById(int applyId)
     */
    @Test
    public void testDeleteApplyingGameById() throws Exception {
        Game game = gameDao.selectAllGames().get(0);
        game.setGameId(-1);
        game.setGameName("test");
        gameDao.insertApplyGame(game);
        gameDao.deleteApplyingGameById(game.getGameId());
        Game game1 = gameDao.selectApplyingGameById(game.getGameId());
        assertEquals(null, game1);
    }




    /**
     * Method: selectGamesByDeveloper(int userId)
     */
    @Test
    public void testSelectGamesByDeveloper() throws Exception {
        Game game = gameDao.selectAllGames().get(0);
        int n=gameDao.selectGamesByDeveloper(game.getDeveloper().getUserId()).size();
        assertTrue(n>0);
    }

    /**
     * Method: selectAppplyingGamesByDeveloper(int userId)
     */
    @Test
    public void testSelectAppplyingGamesByDeveloper() throws Exception {
        Game game = gameDao.selectAllGames().get(0);
        game.setGameId(-1);
        game.setGameName("test");
        int old  = gameDao.selectAppplyingGamesByDeveloper(game.getDeveloper().getUserId()).size();
        gameDao.insertApplyGame(game);
        int now  = gameDao.selectAppplyingGamesByDeveloper(game.getDeveloper().getUserId()).size();
        gameDao.deleteApplyingGameById(game.getGameId());
        assertEquals(1,now-old);
    }

    /**
     * Method: selectGamesByType(String type)
     */
    @Test
    public void testSelectGamesByType() throws Exception {
        int n=gameDao.selectGamesByType("动作").size();
        assertEquals(5,n);
    }

    /**
     * Method: selectApplyingGames()
     */
    @Test
    public void testSelectApplyingGames() throws Exception {
        Game game = gameDao.selectAllGames().get(0);
        game.setGameId(-1);
        game.setGameName("test");
        int old  = gameDao.selectApplyingGames().size();
        gameDao.insertApplyGame(game);
        int now  = gameDao.selectApplyingGames().size();
        gameDao.deleteApplyingGameById(game.getGameId());
        assertEquals(1,now-old);
    }

    /**
     * Method: applyAddNewPassed(int applyId)
     */
    @Test
    public void testApplyAddNewPassed() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: applyUpdatePassed(int applyId)
     */
    @Test
    public void testApplyUpdatePassed() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: applyAddNewFailed(int applyId)
     */
    @Test
    public void testApplyAddNewFailed() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: applyUpdateFailed(int applyId)
     */
    @Test
    public void testApplyUpdateFailed() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: applyRemoveFailed(int applyId)
     */
    @Test
    public void testApplyRemoveFailed() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updateGameStateById(int gameId, short state)
     */
    @Test
    public void testUpdateGameStateById() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: selectOriginIdById(int applyId)
     */
    @Test
    public void testSelectOriginIdById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: insert(Game game)
     */
    @Test
    public void testInsert() throws Exception {
        //TODO: Test goes here...
    }
    /**
     * Method: findByType(String type, int page, int pageSize)
     */
    @Test
    public void testFindByType() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getPageNumByType(String type)
     */
    @Test
    public void testGetPageNumByType() throws Exception {
//TODO: Test goes here...
    }

} 
