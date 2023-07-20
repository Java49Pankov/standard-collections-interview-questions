package telran.interviews;

import java.util.Set;

public interface MultiCounters {

	Integer addItem(Object item); 
	
	Integer getValue(Object item); 
	
	boolean remove(Object item) ; 
	
	Set<Object> getMaxItems(); 
}
