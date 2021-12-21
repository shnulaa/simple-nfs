package org.dcache.simplenfs;

import org.dcache.nfs.v4.NfsIdMapping;
import org.dcache.nfs.v4.xdr.nfsace4;
import org.dcache.nfs.vfs.*;
import org.dcache.nfs.vfs.DirectoryStream;

import javax.security.auth.Subject;
import java.io.IOException;
import java.util.Map;

public class RemoteFileSystem implements VirtualFileSystem {

    private AliDriverClient aliDriverClient;

    public RemoteFileSystem() {
        aliDriverClient = AliDriverClient.getInstance();
        aliDriverClient.refreshToken();
    }


    @Override
    public int access(Inode inode, int mode) throws IOException {
        return mode;
    }

    @Override
    public Inode create(Inode inode, Stat.Type type, String s, Subject subject, int i) throws IOException {
        return null;
    }

    @Override
    public FsStat getFsStat() throws IOException {
        Map<String, Object> map = aliDriverClient.getDriverInfo();

        long total = (long) map.get("sbox_total_size");
        long used = (long) map.get("sbox_used_size");
        return new FsStat(total, Long.MAX_VALUE, used, 100L);
    }

    @Override
    public Inode getRootInode() throws IOException {
        return null;
    }

    @Override
    public Inode lookup(Inode inode, String s) throws IOException {
        return null;
    }

    @Override
    public Inode link(Inode inode, Inode inode1, String s, Subject subject) throws IOException {
        return null;
    }

    @Override
    public DirectoryStream list(Inode inode, byte[] bytes, long l) throws IOException {
        return null;
    }

    @Override
    public byte[] directoryVerifier(Inode inode) throws IOException {
        return new byte[0];
    }

    @Override
    public Inode mkdir(Inode inode, String s, Subject subject, int i) throws IOException {
        return null;
    }

    @Override
    public boolean move(Inode inode, String s, Inode inode1, String s1) throws IOException {
        return false;
    }

    @Override
    public Inode parentOf(Inode inode) throws IOException {
        return null;
    }

    @Override
    public int read(Inode inode, byte[] bytes, long l, int i) throws IOException {
        return 0;
    }

    @Override
    public String readlink(Inode inode) throws IOException {
        return null;
    }

    @Override
    public void remove(Inode inode, String s) throws IOException {

    }

    @Override
    public Inode symlink(Inode inode, String s, String s1, Subject subject, int i) throws IOException {
        return null;
    }

    @Override
    public WriteResult write(Inode inode, byte[] bytes, long l, int i, StabilityLevel stabilityLevel) throws IOException {
        return null;
    }

    @Override
    public void commit(Inode inode, long l, int i) throws IOException {

    }

    @Override
    public Stat getattr(Inode inode) throws IOException {
        return null;
    }

    @Override
    public void setattr(Inode inode, Stat stat) throws IOException {

    }

    @Override
    public nfsace4[] getAcl(Inode inode) throws IOException {
        return new nfsace4[0];
    }

    @Override
    public void setAcl(Inode inode, nfsace4[] nfsace4s) throws IOException {

    }

    @Override
    public boolean hasIOLayout(Inode inode) throws IOException {
        return false;
    }

    @Override
    public AclCheckable getAclCheckable() {
        return null;
    }

    @Override
    public NfsIdMapping getIdMapper() {
        return null;
    }

    @Override
    public boolean getCaseInsensitive() {
        return false;
    }

    @Override
    public boolean getCasePreserving() {
        return false;
    }
}
