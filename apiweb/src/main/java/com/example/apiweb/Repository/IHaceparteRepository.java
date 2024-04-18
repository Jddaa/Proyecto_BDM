package com.example.apiweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiweb.Model.HaceParteModel;

public interface IHaceparteRepository extends JpaRepository<HaceParteModel,Integer> {
    
}
