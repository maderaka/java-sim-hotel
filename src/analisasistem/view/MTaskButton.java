/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.view;

import javax.swing.JComponent;

/**
 *
 * @author RakaMSM
 */
public class MTaskButton extends javax.swing.JToggleButton{
    private JComponent parentComp;
    private boolean resizeComponent = false;
    
    @Override
    public int getWidth(){
        if(isResizeComponent() && getParentComp() != null){
            super.setSize(parentComp.getWidth(),super.getHeight());
        }
        return super.getWidth();
    }

    /**
     * @return the parentComp
     */
    public JComponent getParentComp() {
        return parentComp;
    }

    /**
     * @param parentComp the parentComp to set
     */
    public void setParentComp(JComponent parentComp) {
        this.parentComp = parentComp;
    }

    /**
     * @return the resizeComponent
     */
    public boolean isResizeComponent() {
        return resizeComponent;
    }

    /**
     * @param resizeComponent the resizeComponent to set
     */
    public void setResizeComponent(boolean resizeComponent) {
        this.resizeComponent = resizeComponent;
    }
    
}
