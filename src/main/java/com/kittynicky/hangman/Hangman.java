package com.kittynicky.hangman;

public class Hangman {

    public void printHangman(int countErrors) {
        switch (countErrors) {
            case 0: {
                System.out.println("""
                        __________
                            |    |
                                 |
                                 |
                                 |
                                 |
                                 |
                        _________|
                        """);
                break;
            }
            case 1: {
                System.out.println("""
                        __________
                            |    |
                           ( )   |
                                 |
                                 |
                                 |
                                 |
                        _________|
                        """);
                break;
            }
            case 2: {
                System.out.println("""
                        __________
                            |    |
                           ( )   |
                            |    |
                            |    |
                                 |
                                 |
                        _________|
                        """);
                break;
            }
            case 3: {
                System.out.println("""
                        __________
                            |    |
                           ( )   |
                          \\ |    |
                           \\|    |
                                 |
                                 |
                        _________|
                        """);
                break;
            }
            case 4: {
                System.out.println("""
                        __________
                            |    |
                           ( )   |
                          \\ | /  |
                           \\|/   |
                                 |
                                 |
                        _________|
                        """);
                break;
            }
            case 5: {
                System.out.println("""
                        __________
                            |    |
                           ( )   |
                          \\ | /  |
                           \\|/   |
                           /     |
                          /      |
                        _________|
                        """);
                break;
            }
            case 6: {
                System.out.println("""
                        __________
                            |    |
                           (x)   |
                          \\ | /  |
                           \\|/   |
                           / \\   |
                          /   \\  |
                        _________|
                        """);
                break;
            }
            default: {
                System.out.println("Unknown command");
                break;
            }
        }
    }


}
