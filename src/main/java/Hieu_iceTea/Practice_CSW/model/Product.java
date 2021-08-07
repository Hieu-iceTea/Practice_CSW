package Hieu_iceTea.Practice_CSW.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitial", "handler"})
public class Product extends BaseModel implements Serializable {

    //region - Define Fields -
    private String name;
    private String price;
    private String quantity;
    //endregion


    //region - Relationship -

    //endregion


    //region - Getter, Setter -
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    //endregion


    //region - Method Extend -

    //endregion

}