package org.nodeclipse.coffeejspreview.views;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import code.satyagraha.gfm.commands.Linked;
import code.satyagraha.gfm.support.api.FileNature;
import code.satyagraha.gfm.support.api.GfmConfig;
import code.satyagraha.gfm.support.api.GfmTransformer;
import code.satyagraha.gfm.support.impl.GfmTransformerDefault;
import code.satyagraha.gfm.viewer.plugin.Activator;
import code.satyagraha.gfm.viewer.preferences.PreferenceAdapter;

public class CoffeeJSView extends ViewPart{

    /**
     * The ID of the view as specified by the extension.
     */
    public static final String ID = CoffeeJSView.class.getCanonicalName();

    private CoffeeJSBrowser coffeeJSBrowser;
//
//    private GfmTransformer gfmTransformer;
//    
//    private GfmConfig gfmConfig;
//
//    private EditorTracker editorTracker;
    
    @Override
    public void createPartControl(Composite parent) {
        Activator.debug("");

        coffeeJSBrowser = new CoffeeJSBrowser(parent) {

            @Override
            public void handleDrop(File file) {
//                if (gfmTransformer.isMarkdownFile(file)) {
//                    showFile(file);
//                }
            }

            @Override
            public void completed(ProgressEvent event) {
                super.completed(event);
                showBusy(false);
            }
        };

//        gfmTransformer = new GfmTransformerDefault();
//        gfmConfig = new PreferenceAdapter();
//        Logger logger = Logger.getLogger(CoffeeJSView.class.getCanonicalName());
//        logger.setLevel(Level.WARNING);
//        gfmTransformer.setConfig(gfmConfig, logger);
//
//        FileNature markdownFileNature = new FileNature() {
//            
//            @Override
//            public boolean isTrackableFile(IFile iFile) {
//                return iFile != null && gfmTransformer.isMarkdownFile(iFile.getLocation().toFile());
//            }
//        };
//        
//        editorTracker = new EditorTracker(getSite().getWorkbenchWindow(), this, markdownFileNature);
//        editorTracker.setNotificationsEnabled(Linked.isLinked());
    }

    @Override
    public void setFocus() {
        Activator.debug("");
    }

    @Override
    public void dispose() {
        Activator.debug("");
//        editorTracker.close();
//        editorTracker = null;
//        gfmTransformer = null;
        coffeeJSBrowser.dispose();
        coffeeJSBrowser = null;
        super.dispose();
    }

//    @Override
//    public void showIFile(IFile iFile) {
//        if (iFile != null) {
//            Activator.debug(iFile.getFullPath().toString());
//            showFile(iFile.getRawLocation().toFile());
//        } else {
//            Activator.debug("(null)");
//        }
//    }
//
//    protected void showFile(File mdFile) {
//        showBusy(true);
//        final File htFile = createHtmlFile(mdFile);
//        scheduleTransformation(mdFile, htFile, new Runnable() {
//
//            @Override
//            public void run() {
//                coffeeJSBrowser.showHtmlFile(htFile);
//            }
//        });
//    }
//
//    private File createHtmlFile(File mdFile) {
//        String htDir = gfmConfig.useTempDir() ? System.getProperty("java.io.tmpdir") : mdFile.getParent();
//        String htName = String.format(".%s.html", mdFile.getName());
//        return new File(htDir, htName);
//    }
//
//    private void scheduleTransformation(final File mdFile, final File htFile, final Runnable onDone) {
//        final String jobName = "Transforming: " + mdFile.getName();
//        Job job = new Job(jobName) {
//
//            @Override
//            protected IStatus run(IProgressMonitor monitor) {
//                IStatus status = Status.OK_STATUS;
//                try {
//                    gfmTransformer.transformMarkdownFile(mdFile, htFile);
//                } catch (IOException e) {
//                    status = new Status(Status.ERROR, Activator.PLUGIN_ID, jobName, e);
//                }
//                return status;
//            }
//        };
//        job.setUser(false);
//        job.setSystem(false);
//        job.setPriority(Job.SHORT);
//        job.addJobChangeListener(new JobChangeAdapter() {
//            
//            @Override
//            public void done(IJobChangeEvent event) {
//                if (event.getResult().isOK()) {
//                    Display.getDefault().asyncExec(onDone);
//                } else {
//                    // normal reporting has occurred
//                }
//            }
//        });
//        job.schedule();
//    }
//
//    public void goForward() {
//        Activator.debug("");
//        if (coffeeJSBrowser != null) {
//            coffeeJSBrowser.forward();
//        }
//    }
//
//    public void goBackward() {
//        Activator.debug("");
//        if (coffeeJSBrowser != null) {
//            coffeeJSBrowser.back();
//        }
//    }

    public static CoffeeJSView getInstance() {
        return (CoffeeJSView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(ID);
    }

//    public void setLinkedState(boolean state) {
//        Activator.debug("state: " + state);
//        if (editorTracker != null) {
//            editorTracker.setNotificationsEnabled(state);
//        }
//    }
//
//    public void reload() {
//        Activator.debug("");
//        if (editorTracker != null) {
//             editorTracker.notifyGfmListenerAlways();
//        }
//    }

}