package game.systeminterface;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.HumanoidFigure;
import game.actors.player.Player;
import game.grounds.*;
import game.grounds.computer.Terminal;
import game.grounds.computer.TerminalControlCentre;
import game.grounds.crater.AstronautSpawner;
import game.grounds.crater.BugSpawner;
import game.grounds.crater.Crater;
import game.grounds.crater.SpiderSpawner;
import game.grounds.trees.Sapling;
import game.grounds.trees.Sprout;
import game.items.foods.fruits.LargeFruit;
import game.items.foods.JarOfPickles;
import game.items.scraps.LargeBolt;
import game.items.scraps.PotOfGold;
import game.items.weapons.MetalPipe;
import game.items.scraps.MetalSheet;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Er Jun Yet
 */
public class Application {
    /**
     * The main entry point of the game system and application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {

        // Create the world
        World world = new World(new Display());

        // Create the ground factory
        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Sprout(), new Sapling());

        // Create the game maps
        GameMap polymorphiaMoon = createGameMap(groundFactory, Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~.......................",
                "...~~~..............t.........",
                "..............................",
                ".............#####............",
                ".............#___#...........~",
                ".............#___#.....t....~~",
                ".....t.......##_##.........~~~",
                ".................~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~"));
        world.addGameMap(polymorphiaMoon);

        GameMap staticFactory = createGameMap(groundFactory, Arrays.asList(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                "......."));
        world.addGameMap(staticFactory);

        GameMap refactorioMoon = createGameMap(groundFactory, Arrays.asList(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~..........................~..",
                "~~...........#####............",
                "~~~..........#___#............",
                "~~~..........#___#.......,....",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~.........,......~~~~......",
                "~~~~...............~~~~~......",
                "..~................~~~~.......",
                "......,.............~~........",
                ".............~~...............",
                "............~~~~.............."));
        world.addGameMap(refactorioMoon);

        // Create a terminal control centre
        TerminalControlCentre controlCentre = new TerminalControlCentre();

        // Set up terminal station for each map
        setUpTerminalStations(controlCentre, "Polymorphia Moon", polymorphiaMoon, 15, 5);
        setUpTerminalStations(controlCentre, "Static Factory", staticFactory, 3, 2);
        setUpTerminalStations(controlCentre, "Refactorio Moon", refactorioMoon, 15, 5);

        // Display welcoming message
        displayFancyMessage(FancyMessage.TITLE);

        // Set up the game maps
        setUpGameMap1(polymorphiaMoon);
        setUpGameMap2(staticFactory);
        setUpGameMap3(refactorioMoon);

        // Set up player on the map
        setUpPlayerOnMap(world, polymorphiaMoon);

        // Run the world
        world.run();

        // Display the ending message
        displayFancyMessage(FancyMessage.YOU_ARE_FIRED);
    }

    /**
     * Display fancy message.
     *
     * @param message The fancy message to be displayed.
     */
    public static void displayFancyMessage(String message) {
        for (String line : message.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Create a game map with the given ground factory and map.
     *
     * @param groundFactory The ground factory to be used.
     * @param map           The map to be used.
     * @return The game map created.
     */
    public static GameMap createGameMap(FancyGroundFactory groundFactory, List<String> map) {
        return new GameMap(groundFactory, map);
    }

    /**
     * Set up the player on the map.
     *
     * @param world      The world to be used.
     * @param defaultMap The default map to be used.
     */
    public static void setUpPlayerOnMap(World world, GameMap defaultMap) {
        Player player = new Player("Player", '@', 4);
        world.addPlayer(player, defaultMap.at(15, 6));
        player.addBalance(1000);
    }

    /**
     * Set up the game map 1.
     *
     * @param polymorphiaMoon The game map to be used.
     */
    public static void setUpGameMap1(GameMap polymorphiaMoon) {
        polymorphiaMoon.at(6, 12).setGround(new Crater(new AstronautSpawner()));
        polymorphiaMoon.at(15, 12).setGround(new Crater(new BugSpawner()));
        polymorphiaMoon.at(22, 12).setGround(new Crater(new SpiderSpawner()));

        polymorphiaMoon.at(4, 9).addItem(new MetalSheet());
        polymorphiaMoon.at(4, 9).addItem(new MetalSheet());
        polymorphiaMoon.at(4, 9).addItem(new MetalSheet());
        polymorphiaMoon.at(4, 9).addItem(new MetalSheet());
        polymorphiaMoon.at(4, 9).addItem(new LargeBolt());
        polymorphiaMoon.at(4, 9).addItem(new LargeBolt());
        polymorphiaMoon.at(4, 9).addItem(new LargeBolt());
        polymorphiaMoon.at(4, 9).addItem(new LargeFruit());

        polymorphiaMoon.at(4, 4).addItem(new MetalSheet());
        polymorphiaMoon.at(8, 4).addItem(new LargeBolt());
        polymorphiaMoon.at(14, 8).addItem(new MetalPipe());
        polymorphiaMoon.at(5, 5).addItem(new JarOfPickles());
        polymorphiaMoon.at(14, 9).addItem(new PotOfGold());

    }

    /**
     * Set up the game map 2.
     *
     * @param staticFactory The game map to be used.
     */
    public static void setUpGameMap2(GameMap staticFactory) {
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(5, 6).addItem(new PotOfGold());
        staticFactory.at(3,9).addActor(new HumanoidFigure());

    }

    /**
     * Set up the game map 3.
     *
     * @param refactorioMoon The game map to be used.
     */
    public static void setUpGameMap3(GameMap refactorioMoon) {
        refactorioMoon.at(6, 2).setGround(new Crater(new AstronautSpawner()));
        refactorioMoon.at(15, 2).setGround(new Crater(new BugSpawner()));
        refactorioMoon.at(22, 2).setGround(new Crater(new SpiderSpawner()));

        refactorioMoon.at(4, 10).addItem(new MetalSheet());
        refactorioMoon.at(9, 12).addItem(new MetalPipe());

    }

    /**
     * Set up a terminal station.
     *
     * @param controlCentre         The terminal control centre to be used.
     * @param terminalName          The name of the terminal.
     * @param terminalStationGround The terminal station ground to be used.
     * @param x                     The x-coordinate of the terminal station.
     * @param y                     The y-coordinate of the terminal station.
     */
    private static void setUpTerminalStations(TerminalControlCentre controlCentre, String terminalName, GameMap terminalStationGround, int x, int y) {
        controlCentre.updateTerminalSystem(terminalName, terminalStationGround.at(x, y + 1));
        terminalStationGround.at(x, y).setGround(new Terminal(controlCentre));
    }
}