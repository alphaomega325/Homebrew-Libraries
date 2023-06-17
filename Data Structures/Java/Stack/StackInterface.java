package Stack;
import java.util.*;

/**
 * Interface for a general purpose stack
 * @author alphaomega325
 * @version .01
 * @since 12-24-2016
 */

public interface StackInterface<T>{
        
    public boolean push(T item);

    public T pop();

    public T top();

    public boolean isEmpty();

    public boolean isFull();
    
}

