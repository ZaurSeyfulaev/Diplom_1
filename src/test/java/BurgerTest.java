import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Database database;

    @Spy
    private Burger burger;


    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);

    }

    @Test
    public void addIngredientTest() {
        addIngredientInList(1);
        assertTrue(burger.ingredients.contains(ingredient));

    }

    @Test
    public void removeIngredientTest() {
        addIngredientInList(3);
        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        addIngredientInList(3);
        Ingredient ingredientItem = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredientItem);
        burger.moveIngredient(3, 1);
        assertEquals(ingredientItem, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        addIngredientInList(2);
        assertEquals(600f, burger.getPrice(), 0);
    }


    @Test
    public void getReceiptTest() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Mockito.when(bun.getName()).thenReturn(buns.get(1).name);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredients.get(1).name);
        addIngredientInList(1);
        assertEquals(false, burger.getReceipt().isEmpty());

    }

    public void addIngredientInList(int index) {
        for (int i = 0; i < index; i++) {
            burger.addIngredient(ingredient);
        }
    }
}
