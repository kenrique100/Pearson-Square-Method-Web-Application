package com.feedformulation.model;
import jakarta.persistence.*; // Importing JPA annotations for entity management
import lombok.AllArgsConstructor; // Importing Lombok annotation for generating all-args constructor
import lombok.Builder; // Importing Lombok annotation for builder pattern
import lombok.Data; // Importing Lombok annotation for generating getters, setters, and toString

import java.util.ArrayList; // Importing ArrayList for initializing ingredient list
import java.util.List; // Importing List interface for managing collections of ingredients

/**
 * Entity class representing a feed formulation response.
 * This class is used to store details about a specific feed formulation.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@Entity // Indicates that this class is a JPA entity
@Builder // Enables the builder pattern for creating instances of this class
@AllArgsConstructor // Generates a constructor with all fields as parameters
public class FeedResponse {

    /**
     * Unique identifier for the feed response, auto-generated by the database.
     */
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indicates that the ID will be generated by the database
    private Long id;

    /**
     * Unique identifier for the feed formulation.
     */
    private String formulationId;

    /**
     * The name of the feed formulation.
     */
    private String formulationName;

    /**
     * Date of the feed formulation, in yyyy-MM-dd format.
     */
    private String date;

    /**
     * Total quantity of the feed formulation (kg).
     */
    private double quantity;

    /**
     * Target crude protein (CP) value of the feed formulation.
     */
    private double targetCpValue;

    /**
     * List of ingredients used in the feed formulation.
     * Represents a one-to-many relationship with the Ingredient entity.
     */
    @OneToMany(mappedBy = "feedResponse", cascade = CascadeType.ALL) // Defines the one-to-many relationship
    @Builder.Default // Sets a default value for the ingredients list when using the builder
    private List<Ingredient> ingredients = new ArrayList<>(); // Initializes the ingredients list to an empty ArrayList

    // Default constructor for JPA
    public FeedResponse() {}
}
