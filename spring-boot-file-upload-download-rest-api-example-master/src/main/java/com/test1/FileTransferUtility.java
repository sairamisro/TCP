package com.test1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.FileSystemOptions;
import org.apache.commons.vfs.Selectors;
import org.apache.commons.vfs.UserAuthenticator;
import org.apache.commons.vfs.VFS;
import org.apache.commons.vfs.auth.StaticUserAuthenticator;
import org.apache.commons.vfs.impl.DefaultFileSystemConfigBuilder;

public class FileTransferUtility {

    public void transferFileFromRemote(String domain, String userName, String password, String remoteFileLocation,
            String fileDestinationLocation) {

        File f = new File(fileDestinationLocation);
        FileObject destn;
        try {
            FileSystemManager fm = VFS.getManager();

            destn = VFS.getManager().resolveFile(f.getAbsolutePath());

            if(!f.exists())
            {
                System.out.println("File : "+fileDestinationLocation +" does not exist. transferring file from : "+ remoteFileLocation+" to: "+fileDestinationLocation);
            }
            else
                System.out.println("File : "+fileDestinationLocation +" exists. Transferring(override) file from : "+ remoteFileLocation+" to: "+fileDestinationLocation);

            UserAuthenticator auth = new StaticUserAuthenticator(domain, userName, password);
            FileSystemOptions opts = new FileSystemOptions();
            DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
            FileObject fo = VFS.getManager().resolveFile(remoteFileLocation, opts);
            System.out.println(fo.exists());
            destn.copyFrom(fo, Selectors.SELECT_SELF);
            destn.close();
            if(f.exists())
            {
                System.out.println("File transfer from : "+ remoteFileLocation+" to: "+fileDestinationLocation+" is successful");
            }
        }

        catch (FileSystemException e) {
            e.printStackTrace();
        }

    }

}