package com.test.sftp;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ReceiveSftpFile {
 
    public static void main(String[] args) throws Exception {

 JSch jsch = new JSch();
        Session session = null;
        try {
           session = jsch.getSession("teleformconnect_test", "xfr-uat.itp.qld.gov.au", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("RjbiN4daLGcHlWx0Cauc");
            System.out.println("trying to connect");
            session.connect();
            System.out.println("trying to connect - connected");
            
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.get("/ToConnect/1234.txt", "X:\\temp");  
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  
        } catch (SftpException e) {
            e.printStackTrace();
        }

   }

}
