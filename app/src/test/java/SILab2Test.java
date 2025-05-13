import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryStatementCriteria() {
        RuntimeException ex1;
        //1
        ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1111111111111111"));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));
        //2
        final List<Item> items1 = Arrays.asList(
                new Item("a", 50, 500, 0.5),
                new Item("a", 50, 500, 0),
                new Item(null, 50, 500, 0)
        );
        RuntimeException ex2;
        ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1, "1111111111111111"));
        assertTrue(ex2.getMessage().contains("Invalid item!"));
        //3
        final List<Item> items2 = Arrays.asList(
                new Item("a", 0, 0, 0)
        );
        RuntimeException ex3;
        ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, null));
        assertTrue(ex3.getMessage().contains("Invalid card number!"));
        //4
        final List<Item> items3 = Arrays.asList(
                new Item("a", 0, 0, 0)
                );
        RuntimeException ex4;
        ex4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items3, "1g00000000000000"));
        assertTrue(ex4.getMessage().contains("Invalid character in card number!"));
        //5
        final List<Item> items4 = Arrays.asList(
                new Item("a", 0, 0, 0)
        );
        assertEquals(0.0, SILab2.checkCart(items4, "1000000000000000"));

    }

    @Test
    public void testMultipleConditionCriteria() {
        final List<Item> items = Arrays.asList(
        new Item ("a", 0, 301, 0),
        new Item ("a", 0, 300, 0.5),
        new Item ("a", 11, 300, 0),
        new Item ("a", 0, 0, 0)
        );

        assertEquals(3210.0, SILab2.checkCart(items, "1000000000000000"));
    }
}
