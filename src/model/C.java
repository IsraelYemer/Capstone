package model;

import java.util.List;
import java.util.Optional;

public interface C<T> {
	
	
		public Optional<T>get(Integer id);
		
		public List<T> getAll();
		
		public void save (T t);
		public void update(T t);
		public void delete(T t);
		
	
}
