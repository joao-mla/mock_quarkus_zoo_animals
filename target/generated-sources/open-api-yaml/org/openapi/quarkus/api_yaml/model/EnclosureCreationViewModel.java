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
public class EnclosureCreationViewModel  {

    private String name;
    private UUID space;

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

    public EnclosureCreationViewModel name(String name) {
        this.name = name;
        return this;
    }

    /**
    * Space UUID
    * @return space
    **/
    @JsonProperty("space")
    public UUID getSpace() {
        return space;
    }

    /**
     * Set space
     **/
    public void setSpace(UUID space) {
        this.space = space;
    }

    public EnclosureCreationViewModel space(UUID space) {
        this.space = space;
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnclosureCreationViewModel {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    space: ").append(toIndentedString(space)).append("\n");
        
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
    public static class EnclosureCreationViewModelQueryParam  {

        @jakarta.ws.rs.QueryParam("name")
        private String name;
        @jakarta.ws.rs.QueryParam("space")
        private UUID space;

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

        public EnclosureCreationViewModelQueryParam name(String name) {
            this.name = name;
            return this;
        }

        /**
        * Space UUID
        * @return space
        **/
        @JsonProperty("space")
        public UUID getSpace() {
            return space;
        }

        /**
         * Set space
         **/
        public void setSpace(UUID space) {
            this.space = space;
        }

        public EnclosureCreationViewModelQueryParam space(UUID space) {
            this.space = space;
            return this;
        }

        /**
         * Create a string representation of this pojo.
         **/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class EnclosureCreationViewModelQueryParam {\n");

            sb.append("    name: ").append(toIndentedString(name)).append("\n");
            sb.append("    space: ").append(toIndentedString(space)).append("\n");
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