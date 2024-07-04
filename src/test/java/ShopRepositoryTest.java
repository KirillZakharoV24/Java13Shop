import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopRepositoryTest {
    private ShopRepository repo;

    @BeforeEach
    void setUp() {
        repo = new ShopRepository();
    }

    @Test
    void shouldAddProduct() {
        Product product = new Product(1, "Pr1", 1000);
        repo.add(product);
        Product[] expected = new Product[]{product};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllProducts() {
        Product product1 = new Product(1, "Pr1", 1000);
        Product product2 = new Product(2, "Pr2", 2000);
        repo.add(product1);
        repo.add(product2);
        Product[] expected = new Product[]{product1, product2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        Product product1 = new Product(1, "Pr1", 1000);
        Product product2 = new Product(2, "Pr2", 2000);
        repo.add(product1);
        repo.add(product2);
        repo.removeById(1);
        Product[] expected = new Product[]{product2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldReturnCorrectAuthor() {
        Book book = new Book(1, "Book1", 1000, "Author1");

        String expected = "Author1";
        String actual = book.getAuthor();

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectManufacturer() {
        SmartPhone smartPhone = new SmartPhone(1, "SmartPhone1", 10000, "Man1");
        String expected = "Man1";
        String actual = smartPhone.getManuFacturer();

        assertEquals(expected, actual);
    }

    @Test

    public void shouldFindById() {
        Product product1 = new Product(21, "Something", 1234);
        Product product2 = new Product(31, "Smth2", 4321);
        Product product3 = new Product(41, "smth3", 5657);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product expected = product2;
        Product actual = repo.findById(31);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldntFindByNonExistentId() {
        Product product1 = new Product(21, "Something", 1234);
        Product product2 = new Product(31, "Smth2", 4321);
        Product product3 = new Product(41, "smth3", 5657);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product expected = null;
        Product actual = repo.findById(33);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectPrice() {
        Product product = new Product(1, "Product1", 1000);
        repo.add(product);

        int expected = 1000;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

}
