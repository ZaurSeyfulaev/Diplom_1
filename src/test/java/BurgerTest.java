import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Spy
    private Burger burger;


    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        Mockito.verify(burger, Mockito.times(1)).setBuns(bun);

    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        addIngredientInList(3);
        burger.removeIngredient(1);
        Mockito.verify(burger, Mockito.times(1)).removeIngredient(1);
    }

    @Test
    public void moveIngredientTest() {
        addIngredientInList(3);
        burger.moveIngredient(1, 1);
        Mockito.verify(burger, Mockito.times(1)).moveIngredient(1, 1);
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
        List <Bun> buns = database.availableBuns();
        List <Ingredient> ingredients= database.availableIngredients();
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

