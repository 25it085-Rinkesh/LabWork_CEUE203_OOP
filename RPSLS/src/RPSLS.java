import java.util.Random;
import java.util.Scanner;

public class RPSLS {

    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    public static int winner(Move player, Move computer) {
        if (player == computer)
            return 0;

        switch (player) {
            case ROCK:
                if (computer == Move.SCISSORS || computer == Move.LIZARD)
                    return 1;
                break;

            case PAPER:
                if (computer == Move.ROCK || computer == Move.SPOCK)
                    return 1;
                break;

            case SCISSORS:
                if (computer == Move.PAPER || computer == Move.LIZARD)
                    return 1;
                break;

            case LIZARD:
                if (computer == Move.PAPER || computer == Move.SPOCK)
                    return 1;
                break;

            case SPOCK:
                if (computer == Move.ROCK || computer == Move.SCISSORS)
                    return 1;
                break;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Move[] moves = Move.values();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("===== Rock Paper Scissors Lizard Spock =====");

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nRound " + i);
            System.out.println("Choose: ROCK, PAPER, SCISSORS, LIZARD, SPOCK");

            Move player;

            try {
                player = Move.valueOf(sc.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice! Please enter a valid move.");
                i--; // Repeat same round
                continue;
            }

            Move computer = moves[random.nextInt(moves.length)];

            System.out.println("Player   : " + player);
            System.out.println("Computer : " + computer);

            int result = winner(player, computer);

            if (result == 1) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("This round is a tie!");
            }

            System.out.println("Current Score -> You: " + playerScore + " | Computer: " + computerScore);
        }

        System.out.println("\n========== GAME OVER ==========");
        System.out.println("Final Score");
        System.out.println("You      : " + playerScore);
        System.out.println("Computer : " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("\n🎉 Congratulations! You won the game!");
        } else if (computerScore > playerScore) {
            System.out.println("\n💻 Computer won the game!");
        } else {
            System.out.println("\n🤝 The game is a draw!");
        }

        sc.close();
    }
}