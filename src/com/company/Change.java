package com.company;

public class Change {
    private char fromCharacter;
    private char toCharacter;

    public Change(char fromCharacter, char toCharacter){
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }

    public String change(String characterString){
        char[] characterArray = characterString.toCharArray();              // convert String to char array
        for (int i = 0; i < characterArray.length; i++){
            if (characterArray[i] == this.fromCharacter){                   // if the character to change matches the character at that index
                characterArray[i] = this.toCharacter;                       // replace that character with the replacement character
            }
        }

        String returnString = new String(characterArray);

        return returnString;

        // Equal in function to characterString.replace(this.fromCharacter, this.toCharacter);

    }

    public static void main(String[] args){
        String word = "carrot";
        Change change1 = new Change('a', 'b');
        word = change1.change(word);

        System.out.println(word);

        Change Change2 = new Change('r', 'x');
        word = Change2.change(word);

        System.out.println(word);
    }
}
