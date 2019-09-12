package com.cencosud.controlAPI.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "controlTables")
public class ControlTable implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String videoName;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private Long videoNumber;

    @Column(nullable = false)
    private String store;

    @Column(nullable = false)
    private String shoppingCenter;

    public ControlTable(){

    }

    public ControlTable(String videoName, int status, Long videoNumber, String store, String shoppingCenter){
        this.videoName = videoName;
        this.status = status;
        this.videoNumber = videoNumber;
        this.store = store;
        this.shoppingCenter = shoppingCenter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(Long videoNumber) {
        this.videoNumber = videoNumber;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getShoppingCenter() {
        return shoppingCenter;
    }

    public void setShoppingCenter(String shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }
}
