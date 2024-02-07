package org.openapi.quarkus.api_yaml.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapi.quarkus.api_yaml.model.AnimalViewModel;
import org.openapi.quarkus.api_yaml.model.SpaceViewModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnclosureViewModel  {

    private UUID id;
    private String name;
    private SpaceViewModel space;
    private List<AnimalViewModel> animals;

    /**
    * Enclosure ID
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

    public EnclosureViewModel id(UUID id) {
        this.id = id;
        return this;
    }

    /**
    * Enclosure name
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

    public EnclosureViewModel name(String name) {
        this.name = name;
        return this;
    }

    /**
    * Get space
    * @return space
    **/
    @JsonProperty("space")
    public SpaceViewModel getSpace() {
        return space;
    }

    /**
     * Set space
     **/
    public void setSpace(SpaceViewModel space) {
        this.space = space;
    }

    public EnclosureViewModel space(SpaceViewModel space) {
        this.space = space;
        return this;
    }

    /**
    * Get animals
    * @return animals
    **/
    @JsonProperty("animals")
    public List<AnimalViewModel> getAnimals() {
        return animals;
    }

    /**
     * Set animals
     **/
    public void setAnimals(List<AnimalViewModel> animals) {
        this.animals = animals;
    }

    public EnclosureViewModel animals(List<AnimalViewModel> animals) {
        this.animals = animals;
        return this;
    }
    public EnclosureViewModel addAnimalsItem(AnimalViewModel animalsItem) {
        this.animals.add(animalsItem);
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnclosureViewModel {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    space: ").append(toIndentedString(space)).append("\n");
        sb.append("    animals: ").append(toIndentedString(animals)).append("\n");
        
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
    public static class EnclosureViewModelQueryParam  {

        @jakarta.ws.rs.QueryParam("id")
        private UUID id;
        @jakarta.ws.rs.QueryParam("name")
        private String name;
        @jakarta.ws.rs.QueryParam("space")
        private SpaceViewModel space;
        @jakarta.ws.rs.QueryParam("animals")
        private List<AnimalViewModel> animals = null;

        /**
        * Enclosure ID
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

        public EnclosureViewModelQueryParam id(UUID id) {
            this.id = id;
            return this;
        }

        /**
        * Enclosure name
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

        public EnclosureViewModelQueryParam name(String name) {
            this.name = name;
            return this;
        }

        /**
        * Get space
        * @return space
        **/
        @JsonProperty("space")
        public SpaceViewModel getSpace() {
            return space;
        }

        /**
         * Set space
         **/
        public void setSpace(SpaceViewModel space) {
            this.space = space;
        }

        public EnclosureViewModelQueryParam space(SpaceViewModel space) {
            this.space = space;
            return this;
        }

        /**
        * Get animals
        * @return animals
        **/
        @JsonProperty("animals")
        public List<AnimalViewModel> getAnimals() {
            return animals;
        }

        /**
         * Set animals
         **/
        public void setAnimals(List<AnimalViewModel> animals) {
            this.animals = animals;
        }

        public EnclosureViewModelQueryParam animals(List<AnimalViewModel> animals) {
            this.animals = animals;
            return this;
        }
        public EnclosureViewModelQueryParam addAnimalsItem(AnimalViewModel animalsItem) {
            this.animals.add(animalsItem);
            return this;
        }

        /**
         * Create a string representation of this pojo.
         **/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class EnclosureViewModelQueryParam {\n");

            sb.append("    id: ").append(toIndentedString(id)).append("\n");
            sb.append("    name: ").append(toIndentedString(name)).append("\n");
            sb.append("    space: ").append(toIndentedString(space)).append("\n");
            sb.append("    animals: ").append(toIndentedString(animals)).append("\n");
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