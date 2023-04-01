package com.example.demo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HR")
@Data
public class HR extends User{

}
