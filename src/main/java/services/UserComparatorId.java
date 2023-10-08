package services;

import domain.User;

import java.util.Comparator;

public class UserComparatorId implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return Double.compare(o1.getUserId(), o2.getUserId());
    }
}
