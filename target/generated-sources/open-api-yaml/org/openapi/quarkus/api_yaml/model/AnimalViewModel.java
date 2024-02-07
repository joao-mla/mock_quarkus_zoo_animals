package org.openapi.quarkus.api_yaml.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import org.openapi.quarkus.api_yaml.model.EnclosureAnimalViewModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimalViewModel  {

    private UUID id;
    private String name;
    private String species;
    private EnclosureAnimalViewModel enclosure;

    /**
    * Get id
    * @return id
    **/
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    /**
     * Set id
     **/
    public void setId(UUID id) {
        this.id = id;
    }

    public AnimalViewModel id(UUID id) {
        this.id = id;
        return this;
    }

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

    public AnimalViewModel name(String name) {
        this.name = name;
        return this;
    }

    /**
    * Get species
    * @return species
    **/
    @JsonProperty("species")
    public String getSpecies() {
        return species;
    }

    /**
     * Set species
     **/
    public void setSpecies(String species) {
        this.species = species;
    }

    public AnimalViewModel species(String species) {
        this.species = species;
        return this;
    }

    /**
    * Get enclosure
    * @return enclosure
    **/
    @JsonProperty("enclosure")
    public EnclosureAnimalViewModel getEnclosure() {
        return enclosure;
    }

    /**
     * Set enclosure
     **/
    public void setEnclosure(EnclosureAnimalViewModel enclosure) {
        this.enclosure = enclosure;
    }

    public AnimalViewModel enclosure(EnclosureAnimalViewModel enclosure) {
        this.enclosure = enclosure;
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AnimalViewModel {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
    public static class AnimalViewModelQueryParam  {

        @jakarta.ws.rs.QueryParam("id")
        private UUID id;
        @jakarta.ws.rs.QueryParam("name")
        private String name;
        @jakarta.ws.rs.QueryParam("species")
        private String species;
        @jakarta.ws.rs.QueryParam("enclosure")
        private EnclosureAnimalViewModel enclosure;

        /**
        * Get id
        * @return id
        **/
        @JsonProperty("id")
        public UUID getId() {
            return id;
        }

        /**
         * Set id
         **/
        public void setId(UUID id) {
            this.id = id;
        }

        public AnimalViewModelQueryParam id(UUID id) {
            this.id = id;
            return this;
        }

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

        public AnimalViewModelQueryParam name(String name) {
            this.name = name;
            return this;
        }

        /**
        * Get species
        * @return species
        **/
        @JsonProperty("species")
        public String getSpecies() {
            return species;
        }

        /**
         * Set species
         **/
        public void setSpecies(String species) {
            this.species = species;
        }

        public AnimalViewModelQueryParam species(String species) {
            this.species = species;
            return this;
        }

        /**
        * Get enclosure
        * @return enclosure
        **/
        @JsonProperty("enclosure")
        public EnclosureAnimalViewModel getEnclosure() {
            return enclosure;
        }

        /**
         * Set enclosure
         **/
        public void setEnclosure(EnclosureAnimalViewModel enclosure) {
            this.enclosure = enclosure;
        }

        public AnimalViewModelQueryParam enclosure(EnclosureAnimalViewModel enclosure) {
            this.enclosure = enclosure;
            return this;
        }

        /**
         * Create a string representation of this pojo.
         **/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class AnimalViewModelQueryParam {\n");

            sb.append("    id: ").append(toIndentedString(id)).append("\n");
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