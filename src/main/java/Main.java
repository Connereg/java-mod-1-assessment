import java.util.Scanner;

class DealerNumContainer {
    public int number;
}

class TryAgainContainer {
    public boolean bool;
}


public class Main {
    public static void main(String[] args) {
        //Start Game with a standard greeting for all players
        System.out.println("Hello Traveler! I want to play a guessing game with you, let us take a look at the different kinds of rules we can play by!");
        TryAgainContainer tryAgainOption = new TryAgainContainer();

        Scanner tryAgainScanner = new Scanner(System.in);
        tryAgainOption.bool = true;
        
        while (tryAgainOption.bool == true) {
        //(Path: AB) - (Path:A) Create Difficulty Option Selection + (Path B:) Explanation of the Different Rules for each Game
            difficultyOptionSelector();
            Scanner difficultyScanner = new Scanner(System.in);
            int difficultyInput = difficultyScanner.nextInt();

            //(Path:B1) Ask for difficulty type to explain + return Explanation for that rulset
            if (difficultyInput == 1) {
                //Ruleset Explantion Selector
                difficultyExplanationSelector();
                Scanner rulesetSelectionScanner = new Scanner(System.in);
                int rulesetMenuInput = rulesetSelectionScanner.nextInt();
                
                switch (rulesetMenuInput) {
                    case 1:
                        ruleset1();
                        break;
                    case 2:
                        ruleset2();
                        break;
                    case 3:
                        ruleset3();
                        break;
                }
            }
            
            else if (difficultyInput == 2) {
                //Easy Mode
                System.out.println("___________________________________");
                System.out.println("I see you have chosen Easy mode! Looks like someone likes to win ;) ");
                System.out.println("I will now think of a number between 1 and 10 and keep it hidden from you...");
                System.out.println("Ah yes. This number will do well I think!");
                System.out.println("Now it is time to guess! You must give me a number greater than or equal to my number!");
                System.out.println("What number will you choose? (1-10): ");
                System.out.println("___________________________________");
                // TIME FOR GAME FUNCTION: EASYMODE
                Scanner easyUserInputScanner = new Scanner(System.in);
                int easyUserInputNum = easyUserInputScanner.nextInt();
                DealerNumContainer dealerNumber1 = new DealerNumContainer();
                randomNumberGenerator(dealerNumber1);
                comparisonEvaluator(difficultyInput, dealerNumber1.number, easyUserInputNum);
                int tryAgainSelectionNum = tryAgainScanner.nextInt(); 
                tryAgainFunc(tryAgainSelectionNum, tryAgainOption);
                
                
                
            }
            else if (difficultyInput == 3) {
                //Medium Mode
                System.out.println("___________________________________");
                System.out.println("I see you have chosen Medium mode! This may be harder than you think! ");
                System.out.println("I will now think of a number between 1 and 10 and keep it hidden from you...");
                System.out.println("Ah yes. This number will do well I think!");
                System.out.println("Now it is time to guess! You must give me a number strictly greater than my number!");
                System.out.println("What number will you choose? (1-10): ");
                System.out.println("___________________________________");
                // TIME FOR GAME FUNCTION: MEDIUMMODE
                Scanner mediumUserInputScanner = new Scanner(System.in);
                int mediumUserInputNum = mediumUserInputScanner.nextInt();
                DealerNumContainer dealerNumber2 = new DealerNumContainer();
                randomNumberGenerator(dealerNumber2);
                comparisonEvaluator(difficultyInput, dealerNumber2.number, mediumUserInputNum);
                int tryAgainSelectionNum = tryAgainScanner.nextInt();
                tryAgainFunc(tryAgainSelectionNum, tryAgainOption);

            }
            else if (difficultyInput == 4) {
                //Hard Mode
                System.out.println("___________________________________");
                System.out.println("I see you have chosen Hard mode! You are definitely brave I will give you that...");
                System.out.println("I will now think of a number between 1 and 10 and keep it hidden from you...");
                System.out.println("Ah yes. This number will do well I think!");
                System.out.println("Now it is time to guess! You must give me a number EXACTLY EQUAL to my number!");
                System.out.println("What number will you choose? (1-10): ");
                System.out.println("___________________________________");
                // TIME FOR GAME FUNCTION: HARDMODE
                Scanner hardUserInputScanner = new Scanner(System.in);
                int hardUserInputNum = hardUserInputScanner.nextInt();
                DealerNumContainer dealerNumber3 = new DealerNumContainer();
                randomNumberGenerator(dealerNumber3);
                comparisonEvaluator(difficultyInput, dealerNumber3.number, hardUserInputNum);
                int tryAgainSelectionNum = tryAgainScanner.nextInt();
                tryAgainFunc(tryAgainSelectionNum, tryAgainOption);

            }
            else {
                invalidInputError();
            }



        


        //(Path.B2 -> B1 OR AB) (AB) Offer to exit explanation list OR (B1) return to difficulty explanation list)

        //(Path: A1 -> A2 OR AB) User inputs a valid selection for difficulty OTHERWISE ask for difficulty option again

        //(Path: A2 -> A3) System asks for guess input from User and stores value

        //(Path: A3 -> A4) System determines hidden number and lets player know it is doing so

        //(Path: A4 -> A5) System evaluates winner via difficulty rules (Different evaluation methods for each difficulty)

        //(Path: A5 -> A6) System logs and declares winner with brief explanation

        //(Path: A6 -> AB OR EXIT) Asks user if they would like to restart the game, answer dictates either loop or EXIT program)
        }

    } //MAIN END

    public static void difficultyOptionSelector() {
        System.out.println("___________________________________");
        System.out.println("Choose one of the following options to proceed with our game: ");
        System.out.println("1. Explanation of Different Difficulty Rulesets ");
        System.out.println("Start the game with the following difficulty: ");
        System.out.println("2. Easy");
        System.out.println("3. Medium");
        System.out.println("4. Hard");
        System.out.println("Enter the number of your selection below!");
        System.out.println("_____________________");
    }
    public static void difficultyExplanationSelector() {
        System.out.println("___________________________________");
        System.out.println("Choose one of the following options to hear about the different rulesets: ");
        System.out.println("1. Explain Easy Mode Rules");
        System.out.println("2. Explain Medium Mode Rules");
        System.out.println("3. Explain Hard Mode Rules");
        System.out.println("4. Return to Game Difficulty Selection ");
        System.out.println("_____________________");
    }
    public static void ruleset1() {
        System.out.println("___________________________________");
        System.out.println(" EASY MODE RULES: ");
        System.out.println("You will guess a number between 1 and 10, the if your number is GREATER THAN OR EQUAL TO my hidden number you win the game");
        System.out.println("If your number is less than mine however, you will lose!");
    }
    public static void ruleset2() {
        System.out.println("___________________________________");
        System.out.println(" MEDIUM MODE RULES: ");
        System.out.println("You will guess a number between 1 and 10, the if your number is GREATER THAN my hidden number you win the game");
        System.out.println("If your number is less than or equal to mine however, you will lose!");
    }
    public static void ruleset3() {
        System.out.println("___________________________________");
        System.out.println(" HARD MODE RULES: ");
        System.out.println("You will guess a number between 1 and 10, the if your number is EXACTLY EQUAL TO my hidden number you win the game");
        System.out.println("If your number is less or greater than mine however, you will lose!");
    }
    public static void invalidInputError() {
        System.out.println("_________________________");
        System.out.println("This is not a valid input! Please refer to the options listed and select the number for the option you wish to choose");
        System.out.println("_________________________");
    }
    public static void randomNumberGenerator(DealerNumContainer returnedNum) {
        int max = 10;
        int min = 1;
        int range = (max - min) + 1;
        returnedNum.number = (int) (Math.random() * range) + min;
    }
    public static void comparisonEvaluator(int difficultyModeSelected, int finalDealerNum, int finalPlayerNum) {
        if (difficultyModeSelected == 2) {
            if (finalPlayerNum >= finalDealerNum) {
                System.out.println("Drats! You have picked " + finalPlayerNum + " and I picked " + finalDealerNum + "...");
                System.out.println("You foiled me! your number is greater than or equal to my number.");
                System.out.println("YOU WIN!");
                playAgainInstructions();
            }
            else {
                System.out.println("HA! Nice try, but you picked " + finalPlayerNum + " and I picked " + finalDealerNum + "!");
                System.out.println("Looks like YOU LOST! But fear not, you can always try again if your feeling lucky!");
                playAgainInstructions();
            }
        }
        else if (difficultyModeSelected == 3) {
            if (finalPlayerNum > finalDealerNum) {
                System.out.println("Drats! You have picked " + finalPlayerNum + " and I picked " + finalDealerNum + "...");
                System.out.println("You foiled me! your number is greater than my number.");
                System.out.println("YOU WIN!");
                playAgainInstructions();
            }
            else {
                System.out.println("HA! Nice try, but you picked " + finalPlayerNum + " and I picked " + finalDealerNum + "!");
                System.out.println("Looks like YOU LOST! But fear not, you can always try again if your feeling lucky!");
                playAgainInstructions();  
            }
        }
        else if (difficultyModeSelected == 4) {
            if (finalPlayerNum == finalDealerNum) {
                System.out.println("Drats! You have picked " + finalPlayerNum + " and I picked " + finalDealerNum + "...");
                System.out.println("You foiled me! your number is exactly equal to my number.");
                System.out.println("YOU WIN!");
                playAgainInstructions();

            }
            else {
                System.out.println("HA! Nice try, but you picked " + finalPlayerNum + " and I picked " + finalDealerNum + "!");
                System.out.println("Looks like YOU LOST! But fear not, you can always try again if your feeling lucky!");
                playAgainInstructions(); 
            }
        }
        else {
            System.out.println("_________________________");
            System.out.println("This is not a valid input! Please refer to the options listed and select the number for the option you wish to choose");
            System.out.println("Let's try again from the top... Maybe try reading the rules Traveler?");
            System.out.println("_________________________");
            return;
        }
    }
    public static void tryAgainFunc(int playerChoice, TryAgainContainer tryAgainOption) {
        if (playerChoice == 1) {
            tryAgainOption.bool = true;
        }
        else if (playerChoice == 2) {
            System.out.println("Thanks for playing! Wishing you the best of luck in the future!");
            tryAgainOption.bool = false;
        }
    }
    public static void playAgainInstructions() {
        System.out.println("________________________");
        System.out.println("Would you Like to play again?");
        System.out.println("1. Yes I would!");
        System.out.println("2. No, I am fine for now thanks!");
        System.out.println("_________________________");
    }
} //END OF FILE

//