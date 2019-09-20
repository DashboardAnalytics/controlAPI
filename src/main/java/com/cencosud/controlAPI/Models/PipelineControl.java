package com.cencosud.controlAPI.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pipelineControl")
public class PipelineControl implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean status;

    public PipelineControl(){

    }

    public PipelineControl(boolean status){
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
