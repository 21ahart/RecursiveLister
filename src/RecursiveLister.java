import java.io.File;

public class RecursiveLister {
    private String path;
    private String list;

    public RecursiveLister(String path) {
        this.path = path;
        this.list = "";
    }

    public void listFiles() {
        listFilesRecursively(path);
    }

    public String listFilesRecursively(String dirPath) {
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        list += "Directory: " + file.getAbsolutePath() + "\n";
                        listFilesRecursively(file.getAbsolutePath());
                    } else {
                        list += "File: " + file.getAbsolutePath() + "\n";
                    }
                }
            }
        } else {
            System.out.println("Not a directory: " + dirPath);
        }
        return list;
    }
}
