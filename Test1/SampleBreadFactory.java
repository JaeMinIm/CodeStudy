package Test1;

import java.util.Map;

public class SampleBreadFactory extends BreadFactory{

	@Override
	public Bread createBread(String breadtype, Map<String, Integer> recipe) {
		// TODO Auto-generated method stub
		
		Bread bread = new Bread();
		bread.setBreadtype(breadtype);
		bread.setRecipe(recipe);
		return bread;
	
	}
}
	
