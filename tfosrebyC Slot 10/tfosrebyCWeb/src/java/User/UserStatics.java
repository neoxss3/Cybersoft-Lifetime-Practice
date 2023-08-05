/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhbs
 */
public class UserStatics implements Comparable {

    String name;
    int guess;

    public UserStatics() {
    }

    public UserStatics(String name, int guess) {
        this.name = name;
        this.guess = guess;
    }

    public String getName() {
        return name;
    }

    public int getGuess() {
        return guess;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int compareTo(Object o) {
        UserStatics u = (UserStatics) o;
        return Integer.compare(this.guess, u.guess);
    }

}
