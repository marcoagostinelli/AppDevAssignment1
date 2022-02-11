/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdev_1;


import java.util.Random;
import java.util.regex.Pattern;

public class PasswordGame {

    Random rand = new Random();//random number generator

    String password = "";
    String pass1 = "";//pass 1 2 and 3 store each part of the password
    String pass2 = "";
    String pass3 = "";

    int newLine = 0;//set all conditions to 0
    int single = 0;
    int equal = 0;
    int length = 0;
    int upper = 0;
    int lower = 0;
    int special = 0;

    final String[][][] book = {
        {
            {"ALICE was beginning to get very tired of sitting by her sister on the\n",
                "bank, and of having nothing to do. Once or twice she had peeped into the\n",
                "book her sister was reading, but it had no pictures or conversations in\n",
                "it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
                "conversations?\"\n"},
            {"So she was considering in her OWN mind (as well as she could, for the\n",
                "day made her feel very sleepy and stupid), whether the pleasure of\n",
                "making a daisy-chain would be worth the trouble of getting up and\n",
                "picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
                "close by her.\n"},
            {"There was nothing so very remarkable in that, nor did Alice think it so\n",
                "very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
                "dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
                "out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
                "started to her feet, for it flashed across her mind that she had never\n",
                "before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
                "out of it, and, burning with curiosity, she ran across the field after\n",
                "it and was just in time to see it pop down a large rabbit-hole, under\n",
                "the hedge. In another moment, down went Alice after it!"}
        },
        {
            {"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
                "telescope!\"\n"},
            {"And so it was indeed! She was now only ten inches high, and her face\n",
                "brightened up at the thought that she was now the right size for going\n",
                "through the little door into that lovely garden.\n"},
            {"After awhile, finding that nothing more happened, she decided on going\n",
                "into the garden at once; but, alas for poor Alice! When she got to the\n",
                "door, she found she had forgotten the little golden key, and when she\n",
                "went back to the table for it, she found she could not possibly reach\n",
                "it: she could see it quite plainly through the glass and she tried her\n",
                "best to climb up one of the legs of the table, but it was too slippery,\n",
                "and when she had tired herself out with trying, the poor little thing\n",
                "sat down and cried.\n"},
            {"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
                "sharply. \"I advise you to leave off this minute!\" She generally gave\n",
                "herself very good advice (though she very seldom followed it), and\n",
                "sometimes she scolded herself so severely as to bring tears into her\n",
                "eyes.\n"},
            {"Soon her eye fell on a little glass box that was lying under the table:\n",
                "she opened it and found in it a very small cake, on which the words \"EAT\n",
                "ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
                "Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
                "makes me grow smaller, I can creep under the door: so either way I'll\n",
                "get into the garden, and I don't care which happens!\"\n"},
            {"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
                "way?\" holding her hand on the top of her head to feel which way she was\n",
                "growing; and she was quite surprised to find that she remained the same\n",
                "size. So she set to work and very soon finished off the cake."}
        },
        {
            {"The King and Queen of Hearts were seated on their throne when they\n",
                "arrived, with a great crowd assembled about them--all sorts of little\n",
                "birds and beasts, as well as the whole pack of cards: the Knave was\n",
                "standing before them, in chains, with a soldier on each side to guard\n",
                "him; and near the King was the White Rabbit, with a trumpet in one hand\n",
                "and a scroll of parchment in the other. In the very middle of the court\n",
                "was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
                "trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},
            {"The judge, by the way, was the King and he wore his crown over his great\n",
                "wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
                "(some were animals and some were birds) I suppose they are the jurors.\"\n"},
            {"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
            {"\"HERALD! read the accusation!\" said the King."}
        }
    };

    public PasswordGame() {
        System.out.println("Welcome to the password generator!\n");
        int i;//used to keep track of how many attempts
        for (i = 0; i < 10000; i++) {//10,000 attempts

            if (newPasswordGen() == false) {//dont enen test other conditions if password doenst match current conditions
                continue;
            }
            if (checkForEqual() == false) {//check for equal
                continue;
            }
            if (checkForLength() == false) {//check for length
                continue;
            }
            if (checkForUpperCase() == false) {//check for an upper case
                continue;
            }
            if (checkForSpecialCharacter() == false) {//check for one special character
                continue;
            }
            checkForLowerCase();//check for lower case

            System.out.println("Password = " + String.format("%-15s", password) + "\t Newline = " + String.format("%-10s", newLine)
                    + " Single = " + String.format("%-5s", single) + "\t Equal = " + String.format("%-5s", equal) + "\t Length = "
                    + String.format("%-5s", length) + "\t Upper = " + String.format("%-5s", upper) + "\t Lower = " + String.format("%-5s", lower) + "\t Special = " + String.format("%-15s", special));

            if (lower > 0) {
                break;//end the program if a password doesnt contain a lower case
            }
            resetConditions();//reset the number of failed attempts once we find a password
        }
        System.out.println("Total passwords generated: " + i);
        System.out.println("Thanks for using password generator. Good Bye");
    }

    public int[] genRandNumbers() {//generates the random numbers for line, paragraph and page
        int page, paragraph, line;//used to store the random numbers
        page = rand.nextInt(book.length);
        paragraph = rand.nextInt(book[page].length);
        line = rand.nextInt(book[page][paragraph].length);
        int[] ans = {page, paragraph, line};
        return ans;//return the random numbers

    }

    public boolean newPasswordGen() {//creates a potential password and checks several conditions
        password = "";
        String tempWord;
        int[] randNums;//used to store random nums from genRandNumbers
        String[] bookLine;//the chosen line that we will create the password from

        randNums = genRandNumbers();
        bookLine = book[randNums[0]][randNums[1]][randNums[2]].split(" ");//convert line into array of strings

        for (int i = 0; i < 3; i++) {//used for generating the 3 words
            tempWord = bookLine[rand.nextInt(bookLine.length)];
            if (tempWord.contains("\n")) {//if word contains new line
                password = "";
                newLine++;
                return false;
            }
            if (tempWord.length() == 1) {// if word is a single letter
                password = "";
                single++;
                return false;
            }
            password += tempWord;
            pass1 = (i == 0) ? tempWord : pass1;//set the values of pass to verify them in step 6a
            pass2 = (i == 1) ? tempWord : pass2;
            pass3 = (i == 2) ? tempWord : pass3;
        }
        return true;
    }

    public boolean checkForEqual() {//checks if 2 of the 3 parts in a password are the same
        if (pass1.equals(pass2) || pass1.equals(pass3) || pass2.equals(pass3)) {
            equal++;
            return false;
        }
        return true;
    }

    public boolean checkForLength() {
        if (password.length() < 8 || password.length() > 15) {
            length++;
            return false;
        }
        return true;
    }

    public boolean checkForUpperCase() {
        if (!Pattern.matches(".*[A-Z].*", password)) {
            upper++;
            return false;
        }
        return true;
    }

    public boolean checkForLowerCase() {
        if (!Pattern.matches(".*[a-z].*", password)) {
            lower++;
            return false;
        }
        return true;
    }

    public boolean checkForSpecialCharacter() {
        if (!Pattern.matches("\\w*\\W\\w*", password)) {
            special++;
            return false;
        }
        return true;
    }

    public void resetConditions() {//this just resets all conditions to 0 after successfully creating a new password
        newLine = 0;
        single = 0;
        equal = 0;
        length = 0;
        upper = 0;
        lower = 0;
        special = 0;
    }
}
