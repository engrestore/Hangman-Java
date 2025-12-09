import java.util.Scanner;
import java.util.Random;
class HangmanGame {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       String[] list = { "JavaScript", "Python", "English", "Spanish", "Vietnamese", "French" };
       Random random = new Random();
       String word = list[random.nextInt(list.length)].toUpperCase();
       StringBuilder hiddenWord = new StringBuilder("_ ".repeat(word.length()));
       int maxAttempts = 6;
       int wrongGuesses = 0;
       String guessedLetters = "";
       System.out.println("Welcome to the HANGMAN GAME!");
       System.out.println("Guess the word: " + hiddenWord);
       System.out.println("+---+\n|   |\n|\n|\n|\n|\n=========");
       while (wrongGuesses < maxAttempts && hiddenWord.toString().contains("_")) {
           System.out.print("\nYour Guess: ");
           char guess = input.nextLine().toUpperCase().charAt(0);
           if (guessedLetters.contains(String.valueOf(guess))) {
               System.out.println("You already guessed '" + guess + "'. Try again.");
               continue;
           }
           guessedLetters += guess;
           if (word.contains(String.valueOf(guess))) {
               System.out.println("'" + guess + "' is correct!");
               for (int i = 0; i < word.length(); i++) {
                   if (word.charAt(i) == guess) {
                       hiddenWord.setCharAt(i * 2, guess);
                   }
               }
           } else {
               wrongGuesses++;
               System.out.println("'" + guess + "' is incorrect. Attempts left: " + (maxAttempts - wrongGuesses));
           }
           System.out.println("Current Progress: " + hiddenWord);
            if (wrongGuesses == 0){
                System.out.println("+---+\n|   |\n|\n|\n|\n|\n=========");
            }else if(wrongGuesses == 1){
                 System.out.println("+---+\n|   |\n|   O\n|\n|\n|\n=========");
            }else if(wrongGuesses == 2){
                 System.out.println("+---+\n|   |\n|   O\n|   |\n|\n|\n=========");
            }else if(wrongGuesses == 3){
                 System.out.println("+---+\n|   |\n|   O\n|  /|\n|\n|\n=========");
            }else if(wrongGuesses == 4){
                 System.out.println("+---+\n|   |\n|   O\n|  /|\\\n|\n|\n=========");
            }else if(wrongGuesses == 5){
                 System.out.println("+---+\n|   |\n|   O\n|  /|\\\n|  /\n|\n=========");
            }else if(wrongGuesses == 6){
                 System.out.println("+---+\n|   |\n|   O\n|  /|\\\n|  / \\\n|\n=========");
            }
       }  
       if (hiddenWord.toString().contains("_")) {
           System.out.println("\nYou lost! The word was: " + word);
       } else {
           System.out.println("\nCongratulations! You guessed the word: " + word);
       }
       input.close();
   }
}

