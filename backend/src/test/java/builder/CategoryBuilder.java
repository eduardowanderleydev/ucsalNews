package builder;

import br.ucsal.ucsalnews.entity.Category;

public class CategoryBuilder {

    private static final String Category_DEFAULT = "Some Category";


    private String category = Category_DEFAULT;

    public CategoryBuilder(){

    }

    public static CategoryBuilder oneCategory(){
        return new CategoryBuilder();
    }

    public CategoryBuilder withCategory(String category){
        this.category =category;
        return this;
    }
    
    public Category build(){
        Category obj = new Category();
        obj.setName(this.category);
        return obj;
    }
}
