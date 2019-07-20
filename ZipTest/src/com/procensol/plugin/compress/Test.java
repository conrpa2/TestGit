package com.procensol.plugin.compress;
import java.io.File;
import java.io.IOException;

public class Test {

    private static final String OUTPUT_DIRECTORY = "c:/temp";
    private static final String TAR_GZIP_SUFFIX = ".7z";

    private static final String MULTIPLE_RESOURCES = "/example-multiple-resources";
    private static final String RECURSIVE_DIRECTORY = "/example-recursive-directory";

    private static final String MULTIPLE_RESOURCES_PATH = OUTPUT_DIRECTORY + MULTIPLE_RESOURCES + TAR_GZIP_SUFFIX;
    private static final String RECURSIVE_DIRECTORY_PATH = OUTPUT_DIRECTORY + RECURSIVE_DIRECTORY + TAR_GZIP_SUFFIX;


    public static void main(String... args) throws IOException {


        // get multiple resources files to compress
//        File resource1 = new File("c:/temp/Constant.java");
        File resource2 = new File("c:/temp/Zipit.zip");
        // compress multiple resources
        SevenZ.compress(MULTIPLE_RESOURCES_PATH, resource2);

        // decompress multiple resources
       // SevenZ.decompress(MULTIPLE_RESOURCES_PATH, new File(OUTPUT_DIRECTORY + MULTIPLE_RESOURCES));



        // get directory file to compress
        File directory = new File("C:\\temp\\outlook");

        // compress recursive directory
        SevenZ.compress(RECURSIVE_DIRECTORY_PATH, directory);

        // decompress recursive directory
       // SevenZ.decompress(RECURSIVE_DIRECTORY_PATH, new File(OUTPUT_DIRECTORY + RECURSIVE_DIRECTORY));
    }
}