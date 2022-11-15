import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private IngredientType ingredientType;
    private String name;
    private float price;

    public IngredientParameterizedTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}")
    public static Object[] createIngredientEntity() {
        return new Object[][]{
                {IngredientType.SAUCE, "sour cream", 200f},
                {IngredientType.FILLING, "cutlet", 100f}
        };
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }
}
