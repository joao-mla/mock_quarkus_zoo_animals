package org.openapi.quarkus.api_yaml.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZoneCreationViewModel  {

    private String name;
    private String internalCode;

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

    public ZoneCreationViewModel name(String name) {
        this.name = name;
        return this;
    }

    /**
    * Get internalCode
    * @return internalCode
    **/
    @JsonProperty("internalCode")
    public String getInternalCode() {
        return internalCode;
    }

    /**
     * Set internalCode
     **/
    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public ZoneCreationViewModel internalCode(String internalCode) {
        this.internalCode = internalCode;
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ZoneCreationViewModel {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    internalCode: ").append(toIndentedString(internalCode)).append("\n");
        
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
    public static class ZoneCreationViewModelQueryParam  {

        @jakarta.ws.rs.QueryParam("name")
        private String name;
        @jakarta.ws.rs.QueryParam("internalCode")
        private String internalCode;

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

        public ZoneCreationViewModelQueryParam name(String name) {
            this.name = name;
            return this;
        }

        /**
        * Get internalCode
        * @return internalCode
        **/
        @JsonProperty("internalCode")
        public String getInternalCode() {
            return internalCode;
        }

        /**
         * Set internalCode
         **/
        public void setInternalCode(String internalCode) {
            this.internalCode = internalCode;
        }

        public ZoneCreationViewModelQueryParam internalCode(String internalCode) {
            this.internalCode = internalCode;
            return this;
        }

        /**
         * Create a string representation of this pojo.
         **/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ZoneCreationViewModelQueryParam {\n");

            sb.append("    name: ").append(toIndentedString(name)).append("\n");
            sb.append("    internalCode: ").append(toIndentedString(internalCode)).append("\n");
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