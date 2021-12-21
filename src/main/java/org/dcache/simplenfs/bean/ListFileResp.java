
package org.dcache.simplenfs.bean;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "items",
    "next_marker",
    "punished_file_count"
})
@Generated("jsonschema2pojo")
public class ListFileResp {

    @JsonProperty("items")
    public List<Item> items = null;
    @JsonProperty("next_marker")
    public String nextMarker;
    @JsonProperty("punished_file_count")
    public Integer punishedFileCount;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getNextMarker() {
        return nextMarker;
    }

    public void setNextMarker(String nextMarker) {
        this.nextMarker = nextMarker;
    }

    public Integer getPunishedFileCount() {
        return punishedFileCount;
    }

    public void setPunishedFileCount(Integer punishedFileCount) {
        this.punishedFileCount = punishedFileCount;
    }


}
