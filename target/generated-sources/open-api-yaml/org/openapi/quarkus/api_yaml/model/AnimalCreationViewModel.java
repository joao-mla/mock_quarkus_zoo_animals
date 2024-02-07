package org.openapi.quarkus.api_yaml.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalCreationViewModel  {

    private String name;
    private UUID species;
    private UUID enclosure;

    /**
    * Get name
    * @return name
    **/
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Set name
     **/
    public void setName(String name) {
        this.name = name;
    }

    public AnimalCreationViewModel name(String name) {
        this.name = name;
        return this;
    }

    /**
    * Get species
    * @return species
    **/
    @JsonProperty("species")
    public UUID getSpecies() {
        return species;
    }

    /**
     * Set species
     **/
    public void setSpecies(UUID species) {
        this.species = species;
    }

    public AnimalCreationViewModel species(UUID species) {
        this.species = species;
        return this;
    }

    /**
    * Get enclosure
    * @return enclosure
    **/
    @JsonProperty("enclosure")
    public UUID getEnclosure() {
        return enclosure;
    }

    /**
     * Set enclosure
     **/
    public void setEnclosure(UUID enclosure) {
        this.enclosure = enclosure;
    }

    public AnimalCreationViewModel enclosure(UUID enclosure) {
        this.enclosure = enclosure;
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AnimalCreationViewModel {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    species: ").append(toIndentedString(species)).append("\n");
        sb.append("    enclosure: ").append(toIndentedString(enclosure)).append("\n");
        
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AnimalCreationViewModelQueryParam  {

        @jakarta.ws.rs.QueryParam("name")
        private String name;
        @jakarta.ws.rs.QueryParam("species")
        private UUID species;
        @jakarta.ws.rs.QueryParam("enclosure")
        private UUID enclosure;

        /**
        * Get name
        * @return name
        **/
        @JsonProperty("name")
        public String getName() {
            return name;
        }

        /**
         * Set name
         **/
        public void setName(String name) {
            this.name = name;
        }

        public AnimalCreationViewModelQueryParam name(String name) {
            this.name = name;
            return this;
        }

        /**
        * Get species
        * @return species
        **/
        @JsonProperty("species")
        public UUID getSpecies() {
            return species;
        }

        /**
         * Set species
         **/
        public void setSpecies(UUID species) {
            this.species = species;
        }

        public AnimalCreationViewModelQueryParam species(UUID species) {
            this.species = species;
            return this;
        }

        /**
        * Get enclosure
        * @return enclosure
        **/
        @JsonProperty("enclosure")
        public UUID getEnclosure() {
            return enclosure;
        }

        /**
         * Set enclosure
         **/
        public void setEnclosure(UUID enclosure) {
            this.enclosure = enclosure;
        }

        public AnimalCreationViewModelQueryParam enclosure(UUID enclosure) {
            this.enclosure = enclosure;
            return this;
        }

        /**
         * Create a string representation of this pojo.
         **/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class AnimalCreationViewModelQueryParam {\n");

            sb.append("    name: ").append(toIndentedString(name)).append("\n");
            sb.append("    species: ").append(toIndentedString(species)).append("\n");
            sb.append("    enclosure: ").append(toIndentedString(enclosure)).append("\n");
            sb.append("}");
            return sb.toString();
        }

        /**
         * Convert the given object to string with each line indented by 4 spaces
         * (except the first line).
         */
        private static String toIndentedString(Object o) {
            if (o == null) {
                return "null";
            }
            return o.toString().replace("\n", "\n    ");
        }
    }
}