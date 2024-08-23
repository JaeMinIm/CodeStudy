package Test1;

import java.util.Map;

public abstract class BreadFactory {
	
    public abstract Bread createBread(String breadtype, Map<String, Integer> recipe);

}

