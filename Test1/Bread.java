package Test1;

import java.util.Map;

public class Bread {
	
	// json breadType, recipe 매핑될 필드 선언
	private String breadType;
	private Map<String, Integer> recipe;
	
	//getter와 setter 
	public String getBreadtype() {
		return breadType;
	}
	
	public void setBreadtype(String breadType) {
		this.breadType = breadType;
	}
	
	public Map<String, Integer> getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Map<String, Integer> recipe) {
		this.recipe = recipe;
	}
	
	
	// 불러온정보 출력시 보여질부분들 셋팅
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("breadType: ").append(breadType).append("\n");
        sb.append("recipe\n");
        for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
		
	}


}

