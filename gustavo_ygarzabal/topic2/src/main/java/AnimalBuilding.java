import com.globant.bootcamp.abstracts.Product;

import java.util.ArrayList;

public abstract class AnimalBuilding extends AnimalManager implements Building{
    private ArrayList<Product> products;


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    //TODO not implemented yet
    @Override
    public void showProducts() {
        products.forEach(Product::printProduct);
    }

    @Override
    public void cleanProducts() {
        this.products.clear();
    }
}
