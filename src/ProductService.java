import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public List<Product> searchProductsByName(String name) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId()  == id ) {
                return product;
            }
        }
        return null; // Product with the specified ID was not found
    }

    public static String convertToHex(byte[] Data) {
        String hexString = "";
        for (int i = 0; i < Data.length; i++) {
            int halfbyte = Data[i] >> 4 & 15;
            int twoHalfs = 0;
            while (twoHalfs++ < 1) {
                if (halfbyte >= 0 && halfbyte <= 9) {
                    hexString += (char) (48 + halfbyte);
                } else {
                    hexString += (char) (97 + (halfbyte - 10));
                }
                halfbyte = Data[i] & 15;
            }
        }
        return hexString;
    }
}
