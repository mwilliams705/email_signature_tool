package com.hawklawfirm.email_signature_tool.FileUpload;

import com.hawklawfirm.email_signature_tool.storage.StorageException;

public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
