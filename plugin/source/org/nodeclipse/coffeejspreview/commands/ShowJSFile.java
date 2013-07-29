package org.nodeclipse.coffeejspreview.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.nodeclipse.coffeejspreview.plugin.Activator;
import org.nodeclipse.coffeejspreview.views.CoffeeJSView;

public class ShowJSFile extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
    	Activator.debug("ShowJSFile command is executing");
        IStructuredSelection structuredSelection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
        Object firstElement = structuredSelection.getFirstElement();
        if (firstElement instanceof IFile) {
            IFile iFile = (IFile) firstElement;
            try {
                IViewPart view = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(CoffeeJSView.ID);
                HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().activate(view);
            } catch (PartInitException e) {
                throw new ExecutionException("failed to show view", e);
            }
            CoffeeJSView.getInstance().showIFile(iFile);
        } else {
            Activator.debug("unexpected selection: " + firstElement);
        }
        return null;
    }
    
    
}