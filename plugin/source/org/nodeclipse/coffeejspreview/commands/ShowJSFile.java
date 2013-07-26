package org.nodeclipse.coffeejspreview.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.nodeclipse.coffeejspreview.plugin.Activator;

public class ShowJSFile extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        Activator.debug("ShowJSFile command is executing");
        return null;
    }

}