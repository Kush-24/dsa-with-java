package com.kush.studyplan.lld;
import java.util.*;

// Player class to represent a player
class Player {
    private String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0; // Players start at position 0
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int newPosition) {
        this.currentPosition = newPosition;
    }
}

// SnakeAndLadderGame class to manage the game logic
class SnakeAndLadderGame {
    private List<Pair<Integer, Integer>> snakes;
    private List<Pair<Integer, Integer>> ladders;
    private List<Player> players;

    public SnakeAndLadderGame() {
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        players = new ArrayList<>();
    }

    // Method to add a snake to the game
    public void addSnake(int head, int tail) {
        snakes.add(new Pair<>(head, tail));
    }

    // Method to add a ladder to the game
    public void addLadder(int start, int end) {
        ladders.add(new Pair<>(start, end));
    }

    // Method to add a player to the game
    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    // Method to simulate rolling a dice
    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Method to move a player based on the dice roll
    private void movePlayer(Player player) {
        int diceValue = rollDice();
        System.out.printf("%s rolled a %d.\n", player.getName(), diceValue);
        int playerPosition = player.getCurrentPosition() + diceValue;

        for (Pair<Integer, Integer> ladder : ladders) {
            if (ladder.getKey() == playerPosition) {
                System.out.printf("%s found a ladder! Climbing up from %d to %d.\n", player.getName(), playerPosition, ladder.getValue());
                playerPosition = ladder.getValue();
                break;
            }
        }

        for (Pair<Integer, Integer> snake : snakes) {
            if (snake.getKey() == playerPosition) {
                System.out.printf("%s got bitten by a snake! Sliding down from %d to %d.\n", player.getName(), playerPosition, snake.getValue());
                playerPosition = snake.getValue();
                break;
            }
        }

        if (playerPosition <= 100) {
            player.setCurrentPosition(playerPosition);
        } else {
            System.out.printf("%s needs %d to win but rolled %d.\n", player.getName(), 100 - player.getCurrentPosition(), diceValue);
            System.out.printf("%s stays at %d.\n", player.getName(), player.getCurrentPosition());
        }
    }

    // Method to play the game
    public void playGame() throws InterruptedException {
        while (true) {
            for (Player player : players) {
                movePlayer(player);
                //Thread.sleep(100);
                if (player.getCurrentPosition() == 100) {
                    System.out.printf("%s wins the game!\n", player.getName());
                    return;
                }
            }
        }
    }
    
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

// Main class for starting the game
public class SnakeAndLadders {
    public static void main(String[] args) throws InterruptedException {
    	System.out.println("Starting the game..");
        SnakeAndLadderGame game = new SnakeAndLadderGame();

        // Setting up the game by adding snakes, ladders, and players
        game.addSnake(16, 6);
        game.addSnake(47, 26);
        // Add more snakes if needed...

        game.addLadder(2, 38);
        game.addLadder(7, 14);
        // Add more ladders if needed...

        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        // Add more players if needed...

        game.playGame();
    }
}
