package Week_11.Exercise_38.noticeboard;

import javax.swing.*;

/**
 * Exercise 38: Notice Board
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-02
 */

// Runs the Notice Board class
public class Main {

    public static void main(String[] args){
        NoticeBoard noticeBoard = new NoticeBoard();
        SwingUtilities.invokeLater(noticeBoard);
    }
}
