import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {
    IngredientType ingredientType;

    @Test
    public void ingredientTypeSauceTest() {
        assertTrue(IngredientType.valueOf("SAUCE").equals(IngredientType.SAUCE));
    }

    @Test
    public void ingredientTypeFillingTest() {
        assertTrue(IngredientType.valueOf("FILLING").equals(IngredientType.FILLING));
    }

    @Test
    public void ingredientTypeEnumCount() {
        assertEquals(2, IngredientType.values().length);
    }
}
