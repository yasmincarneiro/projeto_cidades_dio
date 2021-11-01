package com.projeto_cidades.dio.projeto_cidades.Taxes.Service;

import javax.persistence.*;

@Entity(name = "Tax")
@Table(name = "icms")
public class Tax {

    @Id
    private Long id;

    private Long uf;

    @Column(name = "taxa")
    private Double tax;

    public Tax() {
    }

    public Long getId() {
        return id;
    }

    public Long getUf() {
        return uf;
    }

    public Double getTax() {
        return tax;
    }
}

