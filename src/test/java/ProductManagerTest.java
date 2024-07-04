import org.example.Product;
import org.example.ProductManager;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    private ShopRepository repo;
    private ProductManager manager;

    @BeforeEach
    void setUp() {
        repo = new ShopRepository();
        manager = new ProductManager(repo);
    }

    @Test
    void shouldAddProduct() {
        Product product = new Product(1, "Pr1", 1000);
        manager.add(product);
        Product[] expected = new Product[]{product};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByExistingText() {
        Product product1 = new Product(1, "Pr1", 1000);
        Product product2 = new Product(2, "Pr2", 2000);
        Product product3 = new Product(3, "Pr3", 3000);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        Product[] expected = new Product[]{product3};
        Product[] actual = manager.searchBy("Pr3");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNonExistingText() {
        Product product = new Product(1, "Pr1", 1000);
        Product product1 = new Product(2, "Pr2", 3000);
        manager.add(product);
        manager.add(product1);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("No product");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void shouldMatchByName() {
        Product product = new Product(1, "Pr1", 1000);
        Assertions.assertTrue(manager.matches(product, "Pr"));
    }

    @Test
    void shouldNotMatchByName() {
        Product product = new Product(1, "Pr1", 1000);
        Assertions.assertFalse(manager.matches(product, "No Product"));
    }
}
