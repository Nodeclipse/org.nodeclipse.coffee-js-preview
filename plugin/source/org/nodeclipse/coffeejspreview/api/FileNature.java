package org.nodeclipse.coffeejspreview.api;

import org.eclipse.core.resources.IFile;

public interface FileNature {

    public abstract boolean isTrackableFile(IFile iFile);

}