package service;

import java.util.Collection;
import java.util.function.Predicate;

public interface Service<A> {

    A get(long id);
    Collection<A>getAll();
    Collection<A> getAllBy(Predicate<A> p);
    void create(A a);
    void delete(long id);

}
