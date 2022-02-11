import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFiles extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error Accessing "+file.toAbsolutePath()+" "+exc.getMessage());
        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relatavizedPath = sourceRoot.relativize(dir);
        //System.out.println("Relatavized Path from preVisitFile= "+relatavizedPath);
        Path copyDir = targetRoot.resolve(relatavizedPath);
        //System.out.println("Resolved Path for copy from preVisitFile= "+copyDir);
        try{
            System.out.println("In PreVisit, dir= "+dir.toAbsolutePath()+", "+copyDir.toAbsolutePath());
            Files.copy(dir,copyDir);
        }catch(IOException e){
            System.out.println("Exception from preVisitFile "+e.getMessage());
            e.printStackTrace();
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relatavizedPath = sourceRoot.relativize(file);
        //System.out.println("Relatavized Path from visitFile= "+relatavizedPath);
        Path copyDir = targetRoot.resolve(relatavizedPath);
        //System.out.println("Resolved Path for copy from visitFile= "+copyDir);
        try{
            System.out.println("In VisitFile, file= "+file.toAbsolutePath()+", "+copyDir.toAbsolutePath());
            Files.copy(file,copyDir);
        }catch(IOException e){
            System.out.println("Exception from visitFile "+e.getMessage());
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

}
