package org.dcache.simplenfs;

import com.google.common.primitives.Longs;
import com.sleepycat.je.utilint.CollectionUtils;
import com.sleepycat.utilint.StringUtils;
import org.cliffc.high_scale_lib.NonBlockingHashMap;
import org.cliffc.high_scale_lib.NonBlockingHashMapLong;
import org.dcache.nfs.status.NoEntException;
import org.dcache.nfs.v4.NfsIdMapping;
import org.dcache.nfs.v4.xdr.nfsace4;
import org.dcache.nfs.vfs.*;
import org.dcache.nfs.vfs.DirectoryStream;
import org.dcache.simplenfs.bean.ListFileResp;

import javax.security.auth.Subject;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class RemoteFileSystem implements VirtualFileSystem {

    private final RemotePath _root;
    private final NonBlockingHashMapLong<RemotePath> inodeToPath = new NonBlockingHashMapLong<>();
    private final NonBlockingHashMap<RemotePath, Long> pathToInode = new NonBlockingHashMap<>();

    private final AliDriverClient aliDriverClient;

//    private

    public RemoteFileSystem(RemotePath _root) {
        this._root = _root;
        aliDriverClient = AliDriverClient.getInstance();
        aliDriverClient.refreshToken();
        ///////////////////////////


//        Map<String, Object> items = map.get("Item");

//        map();
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


    /////////////////////////

    private Inode toFh(long inodeNumber) {
        return Inode.forFile(Longs.toByteArray(inodeNumber));
    }

    private long getInodeNumber(Inode inode) {
        return Longs.fromByteArray(inode.getFileId());
    }

    private RemotePath resolveInode(long inodeNumber) throws NoEntException {
        RemotePath path = inodeToPath.get(inodeNumber);
        if (path == null) {
            throw new NoEntException("inode #" + inodeNumber);
        }
        return path;
    }

    private long resolvePath(RemotePath path) throws NoEntException {
        Long inodeNumber = pathToInode.get(path);
        if (inodeNumber == null) {
            throw new NoEntException("path " + path);
        }
        return inodeNumber;
    }

    private void map(long inodeNumber, RemotePath path) {
        if (inodeToPath.putIfAbsent(inodeNumber, path) != null) {
            throw new IllegalStateException();
        }
        Long otherInodeNumber = pathToInode.putIfAbsent(path, inodeNumber);
        if (otherInodeNumber != null) {
            //try rollback
            if (inodeToPath.remove(inodeNumber) != path) {
                throw new IllegalStateException("cant map, rollback failed");
            }
            throw new IllegalStateException("path ");
        }
    }

    private void unmap(long inodeNumber, RemotePath path) {
        RemotePath removedPath = inodeToPath.remove(inodeNumber);
        if (!path.equals(removedPath)) {
            throw new IllegalStateException();
        }
        if (pathToInode.remove(path) != inodeNumber) {
            throw new IllegalStateException();
        }
    }

    private void remap(long inodeNumber, RemotePath oldPath, RemotePath newPath) {
        //TODO - attempt rollback?
        unmap(inodeNumber, oldPath);
        map(inodeNumber, newPath);
    }
}
