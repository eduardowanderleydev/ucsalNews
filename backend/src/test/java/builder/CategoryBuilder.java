package builder;

import br.ucsal.ucsalnews.entity.Category;

public class CategoryBuilder {

    private static final String Category_DEFAULT = "Lorem Ipsum is simply dummy text";


    private String category = Category_DEFAULT;

    private CategoryBuilder(){

    }

    public static CategoryBuilder oneCategory(){
        return new CategoryBuilder();
    }

    public CategoryBuilder withName(String category){
        this.category =category;
        return this;
    }
    
    public Category build(){
        Category obj = new Category();
        obj.setName(this.category);
        return obj;
    }
}
