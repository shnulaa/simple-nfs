package org.dcache.simplenfs;


public class RemotePath {
    private String drive_id;
    private String file_id;
    private String parent_file_id;
    private String type; // folder file
    private String content_type; // application/oct-stream
    private Long size;
    private String download_url;

    public String getDrive_id() {
        return drive_id;
    }

    public void setDrive_id(String drive_id) {
        this.drive_id = drive_id;
    }

    public String getParent_file_id() {
        return parent_file_id;
    }

    public void setParent_file_id(String parent_file_id) {
        this.parent_file_id = parent_file_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public boolean isDirectory() {
        return "folder".equals(type);
    }

    @Override
    public String toString() {
        return "RemotePath{" +
                "drive_id='" + drive_id + '\'' +
                ", file_id='" + file_id + '\'' +
                ", parent_file_id='" + parent_file_id + '\'' +
                ", type='" + type + '\'' +
                ", content_type='" + content_type + '\'' +
                ", size=" + size +
                ", download_url='" + download_url + '\'' +
                '}';
    }


}
