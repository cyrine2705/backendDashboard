package com.example.demo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employe")
@Data

public class Employe extends User{


}
