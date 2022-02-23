package cp.week7;

import java.util.ArrayList;
import java.util.List;

public class Box<T>{
	private final T content;

	public Box(T content) throws IllegalArgumentException{
        if(content == null){
            throw new IllegalArgumentException("IllegalArgumentException is thrown");
        }
		this.content = content;
	}

    public T content(){
        return this.content;
	}

    public <O> O apply(BoxFunction<T,O> function){
        return function.apply(this.content);
    }

    public static <I,O>List<? super O> applyToAll(List<Box<I>> boxes, BoxFunction<I,O> function){
        List<O> result = new ArrayList<>();
        for (Box<I> b : boxes)
            result.add(b.apply(function));
        return result;
    }
}