
package org.dcache.simplenfs.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "drive_id",
        "domain_id",
        "file_id",
        "name",
        "type",
        "created_at",
        "updated_at",
        "hidden",
        "starred",
        "status",
        "parent_file_id",
        "encrypt_mode",
        "creator_type",
        "creator_id",
        "creator_name",
        "last_modifier_type",
        "last_modifier_id",
        "last_modifier_name",
        "revision_id",
        "user_meta",
        "content_type",
        "file_extension",
        "mime_type",
        "mime_extension",
        "size",
        "upload_id",
        "crc64_hash",
        "content_hash",
        "content_hash_name",
        "download_url",
        "url",
        "category",
        "punish_flag"
})
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("drive_id")
    public String driveId;
    @JsonProperty("domain_id")
    public String domainId;
    @JsonProperty("file_id")
    public String fileId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("type")
    public String type;
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("updated_at")
    public String updatedAt;
    @JsonProperty("hidden")
    public Boolean hidden;
    @JsonProperty("starred")
    public Boolean starred;
    @JsonProperty("status")
    public String status;
    @JsonProperty("parent_file_id")
    public String parentFileId;
    @JsonProperty("encrypt_mode")
    public String encryptMode;
    @JsonProperty("creator_type")
    public String creatorType;
    @JsonProperty("creator_id")
    public String creatorId;
    @JsonProperty("creator_name")
    public String creatorName;
    @JsonProperty("last_modifier_type")
    public String lastModifierType;
    @JsonProperty("last_modifier_id")
    public String lastModifierId;
    @JsonProperty("last_modifier_name")
    public String lastModifierName;
    @JsonProperty("revision_id")
    public String revisionId;
    @JsonProperty("user_meta")
    public String userMeta;
    @JsonProperty("content_type")
    public String contentType;
    @JsonProperty("file_extension")
    public String fileExtension;
    @JsonProperty("mime_type")
    public String mimeType;
    @JsonProperty("mime_extension")
    public String mimeExtension;
    @JsonProperty("size")
    public Long size;
    @JsonProperty("upload_id")
    public String uploadId;
    @JsonProperty("crc64_hash")
    public String crc64Hash;
    @JsonProperty("content_hash")
    public String contentHash;
    @JsonProperty("content_hash_name")
    public String contentHashName;
    @JsonProperty("download_url")
    public String downloadUrl;

    @JsonProperty("labels")
    public Object labels;

    @JsonProperty("thumbnail")
    public Object thumbnail;

    @JsonProperty("video_media_metadata")
    public Object video_media_metadata;

    @JsonProperty("video_preview_metadata")
    public Object video_preview_metadata;

    @JsonProperty("image_media_metadata")
    public Object image_media_metadata;

    public String getDriveId() {
        return driveId;
    }

    public void setDriveId(String driveId) {
        this.driveId = driveId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParentFileId() {
        return parentFileId;
    }

    public void setParentFileId(String parentFileId) {
        this.parentFileId = parentFileId;
    }

    public String getEncryptMode() {
        return encryptMode;
    }

    public void setEncryptMode(String encryptMode) {
        this.encryptMode = encryptMode;
    }

    public String getCreatorType() {
        return creatorType;
    }

    public void setCreatorType(String creatorType) {
        this.creatorType = creatorType;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getLastModifierType() {
        return lastModifierType;
    }

    public void setLastModifierType(String lastModifierType) {
        this.lastModifierType = lastModifierType;
    }

    public String getLastModifierId() {
        return lastModifierId;
    }

    public void setLastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }

    public String getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(String revisionId) {
        this.revisionId = revisionId;
    }

    public String getUserMeta() {
        return userMeta;
    }

    public void setUserMeta(String userMeta) {
        this.userMeta = userMeta;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeExtension() {
        return mimeExtension;
    }

    public void setMimeExtension(String mimeExtension) {
        this.mimeExtension = mimeExtension;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getCrc64Hash() {
        return crc64Hash;
    }

    public void setCrc64Hash(String crc64Hash) {
        this.crc64Hash = crc64Hash;
    }

    public String getContentHash() {
        return contentHash;
    }

    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }

    public String getContentHashName() {
        return contentHashName;
    }

    public void setContentHashName(String contentHashName) {
        this.contentHashName = contentHashName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPunishFlag() {
        return punishFlag;
    }

    public void setPunishFlag(Integer punishFlag) {
        this.punishFlag = punishFlag;
    }

    @JsonProperty("url")
    public String url;
    @JsonProperty("category")
    public String category;
    @JsonProperty("punish_flag")
    public Integer punishFlag;

}
