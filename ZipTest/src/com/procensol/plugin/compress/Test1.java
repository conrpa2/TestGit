package com.procensol.plugin.compress;

import java.io.File;
import java.util.ArrayList;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
 
//import net.lingala.zip4j.core.ZipFile;
//import net.lingala.zip4j.exception.ZipException;
//import net.lingala.zip4j.model.ZipParameters;
//import net.lingala.zip4j.util.Zip4jConstants;
 
public class Test1
{
    public static void main(String[] args)
    {
        try {
            //This is name and path of zip file to be created
        	
        	char[] test = {'t','t','t','t'};
        	
            ZipFile zipFile = new ZipFile("C:/temp/ZipITNezted.zip", test);
             
            //Add files to be archived into zip file
            ArrayList<File> filesToAdd = new ArrayList<File>();
//            filesToAdd.add(new File("C:/temp/Constant.java"));
//            filesToAdd.add(new File("C:/temp/res.txt"));
            filesToAdd.add(new File("C:/temp/example-multiple-resources.7z"));
            
            //Initiate Zip Parameters which define various properties
            ZipParameters parameters = new ZipParameters();
            parameters.setIncludeRootFolder(true);
            parameters.setCompressionMethod(CompressionMethod.DEFLATE); // set compression method to deflate compression
             
            //DEFLATE_LEVEL_FASTEST     - Lowest compression level but higher speed of compression
            //DEFLATE_LEVEL_FAST        - Low compression level but higher speed of compression
            //DEFLATE_LEVEL_NORMAL  - Optimal balance between compression level/speed
            //DEFLATE_LEVEL_MAXIMUM     - High compression level with a compromise of speed
            //DEFLATE_LEVEL_ULTRA       - Highest compression level but low speed
            parameters.setCompressionLevel(CompressionLevel.NORMAL);
             
            //Set the encryption flag to true
            parameters.setEncryptFiles(true);
             
            //Set the encryption method to AES Zip Encryption
            parameters.setEncryptionMethod(EncryptionMethod.AES);
             
            //AES_STRENGTH_128 - For both encryption and decryption
            //AES_STRENGTH_192 - For decryption only
            //AES_STRENGTH_256 - For both encryption and decryption
            //Key strength 192 cannot be used for encryption. But if a zip file already has a
            //file encrypted with key strength of 192, then Zip4j can decrypt this file
            parameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
             
            //Set password
            //Now add files to the zip file
            zipFile.addFiles(filesToAdd, parameters);
        }
        catch (ZipException e)
        {
            e.printStackTrace();
        }
    }
}