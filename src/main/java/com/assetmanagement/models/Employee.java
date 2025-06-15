package com.assetmanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee {

        @Id
        int id;

        String fullName;
        String designation;

        public Employee(){}
        public Employee(int id, String fullName, String designation) {
            this.id = id;
            this.fullName = fullName;
            this.designation = designation;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }
}
