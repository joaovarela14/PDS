
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class DirectoryVisitor {

    public AtomicLong calculateDirectorySize(String pathString, boolean inside) {
        final AtomicLong totalSize = new AtomicLong(0);
        try {
            Path path = Paths.get(pathString);
            String canonicalPath = path.toAbsolutePath().toString();

            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!inside && !path.equals(dir)) {
                        return FileVisitResult.SKIP_SUBTREE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String filePath = file.toAbsolutePath().toString();
                    String fileDirectory = file.getParent().toAbsolutePath().toString();
                    long fileSize = attrs.size();

                    if (fileDirectory.equals(canonicalPath)) {
                        System.out.println(file.getFileName() + ": " + fileSize + " bytes");
                    } else if (inside) {
                        System.out.println(getRelativePath(canonicalPath, fileDirectory) + "->" + file.getFileName() + ": " + fileSize + " bytes");
                    }
                    totalSize.addAndGet(fileSize);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Error visiting: " + file);
                    System.err.println("Stopping...");
                    return FileVisitResult.TERMINATE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error accessing the file system: " + e.getMessage());
            return null;
        }
        return totalSize;
    }

    private String getRelativePath(String basePath, String targetPath) {
        if (targetPath.startsWith(basePath)) {
            return targetPath.substring(basePath.length());
        }
        return targetPath;
    }
}
