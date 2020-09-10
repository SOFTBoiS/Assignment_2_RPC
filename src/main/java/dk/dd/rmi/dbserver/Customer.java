package dk.dd.rmi.dbserver;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Customer implements Serializable
{

    @Id
    private Long accnum;
    @NonNull
    private String name;
    @NonNull
    private Double amount;

    public Long getAccnum() {
        return accnum;
    }

    public String getName() {
        return name;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAccnum(long accnum) {
        this.accnum = accnum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
