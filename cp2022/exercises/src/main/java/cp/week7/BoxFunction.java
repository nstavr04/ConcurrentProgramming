package cp.week7;

public interface BoxFunction<I,O> {
    // The interface methods are always public so saying so is redundant
    O apply(I input);
}
