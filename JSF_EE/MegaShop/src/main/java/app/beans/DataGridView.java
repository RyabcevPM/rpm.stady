package app.beans;

import app.entities.Product;
import app.model.ProductService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {

    private List<Product> products;

    private Product selectedProduct;

    @ManagedProperty("#{productService}")
    private ProductService service;

    @PostConstruct
    public void init() {
        products = service.createProducts(48);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
}